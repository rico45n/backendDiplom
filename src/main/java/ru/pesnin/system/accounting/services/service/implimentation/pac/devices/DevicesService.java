package ru.pesnin.system.accounting.services.service.implimentation.pac.devices;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.devices.DevicesDTO;
import ru.pesnin.system.accounting.integration.dto.devices.InfoCrossDeviceEndDTO;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalDeviceFilter;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;
import ru.pesnin.system.accounting.services.entity.devices.DevicesDomain;
import ru.pesnin.system.accounting.services.entity.devices.PropsPortDomain;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceDomain;
import ru.pesnin.system.accounting.services.entity.journal.CrossDevicesDomain;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalDomain;
import ru.pesnin.system.accounting.services.entity.room.RoomDomain;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;
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
    public List<DevicesDTO> findAll() {
        return mapperEntityToDTO();
    }

    @Override
    public DevicesDTO read(DevicesDTO obj) {
        return null;
    }

    @Override
    public InfoCrossDeviceEndDTO searchCrossDeviceInfo(Integer id_devices) {
        try {
            Query deviceEnd = em.createNativeQuery("select * from network.infocrossedevice inf where inf.id_devices = ?1", InfoCrossDeviceEndDTO.class);
            deviceEnd.setParameter(1, id_devices);
            return (InfoCrossDeviceEndDTO) deviceEnd.getResultList().get(0);
        }
        catch (Exception e){
            return null;
        }
    }

    @Override
    public List<InfoCrossDeviceEndDTO> getAllCrossDevicesInfo() {
      Query deviceEnd =  em.createNativeQuery("select * from network.infocrossedevice inf", InfoCrossDeviceEndDTO.class);

        List<InfoCrossDeviceEndDTO> infoCrossDeviceEndDTOList = (List<InfoCrossDeviceEndDTO>) deviceEnd.getResultList();
        return infoCrossDeviceEndDTOList;
    }

    @Override
    public List<DevicesDTO> delete(Integer id_devices, Integer id_user_old) {
        Optional<DevicesDomain> devicesDomain = devicesRepository.findById(id_devices);

        propsPortRepository.delete(devicesDomain.get().getId_props_port());
        devicesRepository.delete(id_devices);
        List<NetworkJournalDomain> networkJournalDomains = networkJournalRepository.findBy_AndId_devices(id_devices);
        for(NetworkJournalDomain networkJournalDomain : networkJournalDomains){
            networkJournalDomain.setIs_status(refStatusRepository.findById(2).get());
            networkJournalDomain.setDate_old(new Date());
            networkJournalDomain.setId_user_old(userRepository.findById(id_user_old).get());
            networkJournalRepository.save(networkJournalDomain);
        }

       try {
           try {
               List<CrossDevicesDomain> crossDevicesDomains = crossDevicesRepository.findBy_deviceFirst(id_devices);
                for(CrossDevicesDomain crossDevicesDomain : crossDevicesDomains){
                   crossDevicesDomain.setIs_status(refStatusRepository.findById(2).get());
                   crossDevicesDomain.setDescription("Удалено устройство");
                   crossDevicesDomain.setId_user_old(userRepository.findById(id_user_old).get());
                   crossDevicesDomain.setDate_old(new Date());
                   crossDevicesRepository.save(crossDevicesDomain);
               }
           } catch (Exception e) {
               CrossDevicesDomain crossDevicesDomain = crossDevicesRepository.findBy_deviceEnd(id_devices);
               crossDevicesDomain.setIs_status(refStatusRepository.findById(2).get());
               crossDevicesDomain.setDescription("Удалено устройство");
               crossDevicesDomain.setId_user_old(userRepository.findById(id_user_old).get());
               crossDevicesDomain.setDate_old(new Date());
               crossDevicesRepository.save(crossDevicesDomain);
           }
       }catch (Exception e){
           System.out.println("Не удалось удалить запись в журнале подключений: "+ e.getMessage());
       }
        return mapperEntityToDTO();
    }

    @Override
    public List<DevicesDTO> update(DevicesDTO obj, Integer id_devices) {
        PropsPortDomain propsPortDomain = new PropsPortDomain(obj.getCountOptPort(),obj.getCountEthernetPort());

        Optional<TypeDeviceDomain> typeDeviceDomain = typeDeviceRepository.findById(obj.getId_type_devices());
        Optional<UsersDomain> usersDomain = userRepository.findById(obj.getId_user_otv());
        Optional<RoomDomain> roomDomain = roomRepository.findById(obj.getId_room());
        Optional<RefStatusDomain> refStatusDomain = refStatusRepository.findById(obj.getId_status());

            devicesRepository.findById(id_devices).map(employee -> {
                employee.setId_type_devices(typeDeviceDomain.get());
                employee.setUser_otv(usersDomain.get());
                employee.setHostname(obj.getHostname());
                employee.setMac_address(obj.getMac_address());
                employee.setInventar_number(obj.getInventar_number());
                employee.setId_room(roomDomain.get());
                employee.setId_props_port(propsPortDomain);
                employee.setIs_status(refStatusDomain.get());
            return devicesRepository.save(employee);
        });

        System.out.println(devicesRepository.findById(obj.getId_devices()));
        return mapperEntityToDTO();
    }

    @Override
    public List<DevicesDTO> create(DevicesDTO obj) {
        PropsPortDomain propsPortDomain = new PropsPortDomain(obj.getCountOptPort(),obj.getCountEthernetPort());
        propsPortRepository.save(propsPortDomain);

        Optional<TypeDeviceDomain> typeDeviceDomain = typeDeviceRepository.findById(obj.getId_type_devices());
        Optional<UsersDomain> usersDomain = userRepository.findById(obj.getId_user_otv());
        Optional<RoomDomain> roomDomain = roomRepository.findById(obj.getId_room());
        Optional<RefStatusDomain> refStatusDomain = refStatusRepository.findById(obj.getId_status());

        DevicesDomain devicesDomain = new DevicesDomain(typeDeviceDomain.get(),
                usersDomain.get(), obj.getHostname(),obj.getMac_address(),
                obj.getInventar_number(), roomDomain.get(), propsPortDomain, refStatusDomain.get());

        devicesRepository.save(devicesDomain);

        return mapperEntityToDTO();
    }

    @Override
    public List<NetworkJournalDeviceFilter> getAllDeviceFilter() {
        List<DevicesDomain> devicesDomains = devicesRepository.getInfoConnectDevice();
        List<NetworkJournalDeviceFilter> networkJournalDeviceFilters = new ArrayList<>();

        for (DevicesDomain devices: devicesDomains) {
            NetworkJournalDeviceFilter net = new NetworkJournalDeviceFilter();
            net.setId_devices(devices.getId_devices());
            net.setHostname(devices.getHostname());
            networkJournalDeviceFilters.add(net);
        }
        return networkJournalDeviceFilters;
    }

    private List<DevicesDTO> mapperEntityToDTO()
    {
        List<DevicesDTO> listDTO = new ArrayList<>();
        List<DevicesDomain> listDom = devicesRepository.findAll();
        for(int i = 0; i<listDom.size(); i++) {
            DevicesDomain dom = listDom.get(i);
            listDTO.add(new DevicesDTO(dom));
        }
        return listDTO;
    }
}
