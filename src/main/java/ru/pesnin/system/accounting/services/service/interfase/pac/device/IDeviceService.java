package ru.pesnin.system.accounting.services.service.interfase.pac.device;


import ru.pesnin.system.accounting.integration.dto.devices.DevicesDTO;
import ru.pesnin.system.accounting.integration.dto.devices.InfoCrossDeviceEndDTO;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalDeviceFilter;

import java.util.List;

public interface IDeviceService {
    List<DevicesDTO> findAll();
    DevicesDTO read(DevicesDTO obj);
    InfoCrossDeviceEndDTO searchCrossDeviceInfo(Integer id_devices);
    List<InfoCrossDeviceEndDTO> getAllCrossDevicesInfo();
    List<DevicesDTO> delete(Integer id_devices, Integer id_user_old);
    List<DevicesDTO> update(DevicesDTO obj,Integer id_devices);
    List<DevicesDTO> create(DevicesDTO obj);
    List<NetworkJournalDeviceFilter> getAllDeviceFilter();
}
