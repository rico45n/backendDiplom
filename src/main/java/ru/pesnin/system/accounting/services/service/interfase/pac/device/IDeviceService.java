package ru.pesnin.system.accounting.services.service.interfase.pac.device;


import ru.pesnin.system.accounting.integration.dto.devices.DevicesDto;
import ru.pesnin.system.accounting.integration.dto.devices.InfoCrossDeviceEndDto;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalDeviceFilter;

import java.util.List;

public interface IDeviceService {
    List<DevicesDto> findAll();
    DevicesDto read(DevicesDto obj);
    InfoCrossDeviceEndDto searchCrossDeviceInfo(Integer idDevices);
    List<InfoCrossDeviceEndDto> getAllCrossDevicesInfo();
    List<DevicesDto> delete(Integer idDevices, Integer idUserOld);
    List<DevicesDto> update(DevicesDto obj, Integer idDevices);
    List<DevicesDto> create(DevicesDto obj);
    List<NetworkJournalDeviceFilter> getAllDeviceFilter();
}
