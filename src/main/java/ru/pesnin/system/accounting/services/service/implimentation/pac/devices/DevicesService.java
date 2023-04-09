package ru.pesnin.system.accounting.services.service.implimentation.pac.devices;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.devices.DevicesDto;
import ru.pesnin.system.accounting.integration.dto.devices.InfoCrossDeviceEndDto;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalDeviceFilter;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.devices.PropsPortEntity;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceEntity;
import ru.pesnin.system.accounting.services.entity.room.RoomEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.repository.devices.DevicesRepository;
import ru.pesnin.system.accounting.services.repository.devices.PropsPortRepository;
import ru.pesnin.system.accounting.services.repository.devices.TypeDeviceRepository;
import ru.pesnin.system.accounting.services.repository.journal.CrossDevicesRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.room.RoomRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.device.IDeviceService;


import java.util.ArrayList;
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
    public DevicesDto read(int id) {
        var e = devicesRepository.findById(id).get();
        return DevicesDto.builder()
                .idDevices(e.getIdDevices())
                .countEthernetPort(e.getIdPropsPort().getEthernetPort())
                .countOptPort(e.getIdPropsPort().getOVPort())
                .idTypeDevices(e.getIdTypeDevices().getIdTypeDev())
                .typeDevice(e.getIdTypeDevices().getNameTypeDev())
                .idUserOtv(e.getUserOtv().getUserId())
                .userOtv(e.getUserOtv().getFioUser())
                .hostName(e.getHostname())
                .macAddress(e.getMacAddress())
                .inventarNumber(e.getInventarNumber())
                .idRoom(e.getIdRoom().getIdRoom())
                .room(e.getIdRoom().getNameRoom())
                .idPropsPort(e.getIdPropsPort().getIdPropsPort())
                .countOptPort(e.getIdPropsPort().getOVPort())
                .countEthernetPort(e.getIdPropsPort().getEthernetPort())
                .build();
    }

    @Override
    public InfoCrossDeviceEndDto searchCrossDeviceInfo(Integer idDevices) {
        try {
            Query deviceEnd = em.createNativeQuery("select * from network.infocrossedevice inf where inf.id_devices = ?1", InfoCrossDeviceEndDto.class);
            deviceEnd.setParameter(1, idDevices);
            return (InfoCrossDeviceEndDto) deviceEnd.getResultList().get(0);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<InfoCrossDeviceEndDto> getAllCrossDevicesInfo() {
        Query deviceEnd = em.createNativeQuery("select * from network.infocrossedevice inf", InfoCrossDeviceEndDto.class);

        List<InfoCrossDeviceEndDto> infoCrossDeviceEndDTOList = (List<InfoCrossDeviceEndDto>) deviceEnd.getResultList();
        return infoCrossDeviceEndDTOList;
    }

    @Override
    public List<DevicesDto> delete(Integer idDevices) {
        try {
            devicesRepository.deleteById(idDevices);
            return this.findAll();
        } catch (Exception ignore) {
            return this.findAll();
        }
    }

    @Override
    public List<DevicesDto> update(DevicesDto obj, Integer idDevices) {
        PropsPortEntity propsPortEntity = new PropsPortEntity(obj.getCountOptPort(), obj.getCountEthernetPort());
        Optional<TypeDeviceEntity> typeDeviceEntity = typeDeviceRepository.findById(obj.getIdTypeDevices());
        Optional<UsersEntity> usersEntity = userRepository.findById(obj.getIdUserOtv());
        Optional<RoomEntity> roomEntity = roomRepository.findById(obj.getIdRoom());
        devicesRepository.findById(idDevices).map(employee -> {
            employee.setIdTypeDevices(typeDeviceEntity.get());
            employee.setUserOtv(usersEntity.get());
            employee.setHostname(obj.getHostName());
            employee.setMacAddress(obj.getMacAddress());
            employee.setInventarNumber(obj.getInventarNumber());
            employee.setIdRoom(roomEntity.get());
            employee.setIdPropsPort(propsPortEntity);
            return devicesRepository.save(employee);
        });

        return mapperEntityToDTO();
    }

    @Override
    public List<DevicesDto> create(DevicesDto obj) {
        PropsPortEntity propsPortEntity = new PropsPortEntity(obj.getCountOptPort(), obj.getCountEthernetPort());
        propsPortRepository.save(propsPortEntity);

        Optional<TypeDeviceEntity> typeDeviceEntity = typeDeviceRepository.findById(obj.getIdTypeDevices());
        Optional<UsersEntity> usersEntity = userRepository.findById(obj.getIdUserOtv());
        Optional<RoomEntity> roomEntity = roomRepository.findById(obj.getIdRoom());

        DevicesEntity devicesDomain = new DevicesEntity(typeDeviceEntity.get(),

                usersEntity.get(), obj.getHostName(), obj.getMacAddress(),
                obj.getInventarNumber(), roomEntity.get(), propsPortEntity);

        devicesRepository.save(devicesDomain);

        return mapperEntityToDTO();
    }

    @Override
    public List<NetworkJournalDeviceFilter> getAllDeviceFilter() {
        List<DevicesEntity> devicesDomains = devicesRepository.getInfoConnectDevice();
        List<NetworkJournalDeviceFilter> networkJournalDeviceFilters = new ArrayList<>();

        for (DevicesEntity devices : devicesDomains) {
            NetworkJournalDeviceFilter net = new NetworkJournalDeviceFilter();
            net.setIdDevices(devices.getIdDevices());
            net.setHostName(devices.getHostname());
            networkJournalDeviceFilters.add(net);
        }
        return networkJournalDeviceFilters;
    }

    private List<DevicesDto> mapperEntityToDTO() {
        List<DevicesDto> listDTO = new ArrayList<>();
        List<DevicesEntity> listDom = devicesRepository.findAll();
        for (int i = 0; i < listDom.size(); i++) {
            DevicesEntity dom = listDom.get(i);
            listDTO.add(new DevicesDto(dom));
        }
        return listDTO;
    }
}
