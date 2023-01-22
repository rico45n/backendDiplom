package ru.pesnin.system.accounting.services.service.implimentation.pac.devices;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.devices.DevicesDto;
import ru.pesnin.system.accounting.integration.dto.devices.InfoCrossDeviceEndDto;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalDeviceFilter;
import ru.pesnin.system.accounting.services.entity.RefStatusEntity;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.devices.PropsPortEntity;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceEntity;
import ru.pesnin.system.accounting.services.entity.journal.CrossDevicesEntity;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;
import ru.pesnin.system.accounting.services.entity.room.RoomEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.devices.DevicesRepository;
import ru.pesnin.system.accounting.services.repository.devices.PropsPortRepository;
import ru.pesnin.system.accounting.services.repository.devices.TypeDeviceRepository;
import ru.pesnin.system.accounting.services.repository.journal.CrossDevicesRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.room.RoomRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.device.IDeviceService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import jakarta.persistence.*;
@Service
public class DevicesService implements IDeviceService {
    @Autowired
    private DevicesRepository devicesRepository;
    @Autowired
    private PropsPortRepository propsPortRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private TypeDeviceRepository typeDeviceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;
    @Autowired
    private NetworkJournalRepository networkJournalRepository;
    @Autowired
    private CrossDevicesRepository crossDevicesRepository;
    @Autowired
    private EntityManager em;

    @Override
    public List<DevicesDto> findAll() {
        return mapperEntityToDTO();
    }

    @Override
    public DevicesDto read(DevicesDto obj) {
        return null;
    }

    @Override
    public InfoCrossDeviceEndDto searchCrossDeviceInfo(Integer idDevices) {
        try {
            Query deviceEnd = em.createNativeQuery("select * from network.infocrossedevice inf where inf.id_devices = ?1", InfoCrossDeviceEndDto.class);
            deviceEnd.setParameter(1, idDevices);
            return (InfoCrossDeviceEndDto) deviceEnd.getResultList().get(0);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<InfoCrossDeviceEndDto> getAllCrossDevicesInfo() {
      Query deviceEnd =  em.createNativeQuery("select * from network.infocrossedevice inf", InfoCrossDeviceEndDto.class);

        List<InfoCrossDeviceEndDto> infoCrossDeviceEndDTOList = (List<InfoCrossDeviceEndDto>) deviceEnd.getResultList();
        return infoCrossDeviceEndDTOList;
    }

    @Override
    public List<DevicesDto> delete(Integer idDevices, Integer idUserOld) {
        Optional<DevicesEntity> devicesEntity = devicesRepository.findById(idDevices);

        propsPortRepository.delete(devicesEntity.get().getIdPropsPort());
        devicesRepository.delete(idDevices);
        List<NetworkJournalEntity> networkJournalDomains = networkJournalRepository.findBy_AndId_devices(idDevices);
        for(NetworkJournalEntity networkJournalDomain : networkJournalDomains){
            networkJournalDomain.setIsStatus(refStatusRepository.findById(2).get());
            networkJournalDomain.setDateOld(new Date());
            networkJournalDomain.setIdUserOld(userRepository.findById(idUserOld).get());
            networkJournalRepository.save(networkJournalDomain);
        }

       try {
           try {
               List<CrossDevicesEntity> crossDevicesEntities = crossDevicesRepository.findBy_deviceFirst(idDevices);
                for(CrossDevicesEntity crossDevicesEntity : crossDevicesEntities){
                   crossDevicesEntity.setIsStatus(refStatusRepository.findById(2).get());
                   crossDevicesEntity.setDescription("Удалено устройство");
                   crossDevicesEntity.setIdUserOld(userRepository.findById(idUserOld).get());
                   crossDevicesEntity.setDateOld(new Date());
                   crossDevicesRepository.save(crossDevicesEntity);
               }
           } catch (Exception e) {
               CrossDevicesEntity crossDevicesEntity = crossDevicesRepository.findBy_deviceEnd(idDevices);
               crossDevicesEntity.setIsStatus(refStatusRepository.findById(2).get());
               crossDevicesEntity.setDescription("Удалено устройство");
               crossDevicesEntity.setIdUserOld(userRepository.findById(idUserOld).get());
               crossDevicesEntity.setDateOld(new Date());
               crossDevicesRepository.save(crossDevicesEntity);
           }
       }catch (Exception e){
           System.out.println("Не удалось удалить запись в журнале подключений: "+ e.getMessage());
       }
        return mapperEntityToDTO();
    }

    @Override
    public List<DevicesDto> update(DevicesDto obj, Integer idDevices) {
        PropsPortEntity propsPortEntity = new PropsPortEntity(obj.getCountOptPort(),obj.getCountEthernetPort());

        Optional<TypeDeviceEntity> typeDeviceEntity = typeDeviceRepository.findById(obj.getIdTypeDevices());
        Optional<UsersEntity> usersEntity = userRepository.findById(obj.getIdUserOtv());
        Optional<RoomEntity> roomEntity = roomRepository.findById(obj.getIdRoom());
        Optional<RefStatusEntity> refStatusEntity = refStatusRepository.findById(obj.getIdStatus());

            devicesRepository.findById(idDevices).map(employee -> {
                employee.setIdTypeDevices(typeDeviceEntity.get());
                employee.setUserOtv(usersEntity.get());
                employee.setHostname(obj.getHostName());
                employee.setMacAddress(obj.getMacAddress());
                employee.setInventarNumber(obj.getInventarNumber());
                employee.setIdRoom(roomEntity.get());
                employee.setIdPropsPort(propsPortEntity);
                employee.setIsStatus(refStatusEntity.get());
            return devicesRepository.save(employee);
        });

        System.out.println(devicesRepository.findById(obj.getIdDevices()));
        return mapperEntityToDTO();
    }

    @Override
    public List<DevicesDto> create(DevicesDto obj) {
        PropsPortEntity propsPortEntity = new PropsPortEntity(obj.getCountOptPort(),obj.getCountEthernetPort());
        propsPortRepository.save(propsPortEntity);

        Optional<TypeDeviceEntity> typeDeviceEntity = typeDeviceRepository.findById(obj.getIdTypeDevices());
        Optional<UsersEntity> usersEntity = userRepository.findById(obj.getIdUserOtv());
        Optional<RoomEntity> roomEntity = roomRepository.findById(obj.getIdRoom());
        Optional<RefStatusEntity> refStatusEntity = refStatusRepository.findById(obj.getIdStatus());

        DevicesEntity devicesDomain = new DevicesEntity(typeDeviceEntity.get(),

                usersEntity.get(), obj.getHostName(),obj.getMacAddress(),
                obj.getInventarNumber(), roomEntity.get(), propsPortEntity, refStatusEntity.get());

        devicesRepository.save(devicesDomain);

        return mapperEntityToDTO();
    }

    @Override
    public List<NetworkJournalDeviceFilter> getAllDeviceFilter() {
        List<DevicesEntity> devicesDomains = devicesRepository.getInfoConnectDevice();
        List<NetworkJournalDeviceFilter> networkJournalDeviceFilters = new ArrayList<>();

        for (DevicesEntity devices: devicesDomains) {
            NetworkJournalDeviceFilter net = new NetworkJournalDeviceFilter();
            net.setIdDevices(devices.getIdDevices());
            net.setHostName(devices.getHostname());
            networkJournalDeviceFilters.add(net);
        }
        return networkJournalDeviceFilters;
    }

    private List<DevicesDto> mapperEntityToDTO()
    {
        List<DevicesDto> listDTO = new ArrayList<>();
        List<DevicesEntity> listDom = devicesRepository.findAll();
        for(int i = 0; i<listDom.size(); i++) {
            DevicesEntity dom = listDom.get(i);
            listDTO.add(new DevicesDto(dom));
        }
        return listDTO;
    }
}
