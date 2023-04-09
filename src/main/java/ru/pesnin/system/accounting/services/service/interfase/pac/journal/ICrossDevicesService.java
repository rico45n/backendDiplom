package ru.pesnin.system.accounting.services.service.interfase.pac.journal;



import ru.pesnin.system.accounting.integration.dto.journal.CrossDevicesDto;

import java.util.List;

public interface ICrossDevicesService {
    List<CrossDevicesDto> findAll();
    CrossDevicesDto read(int obj);
    List<CrossDevicesDto> delete(Integer idCross_dev);
    List<CrossDevicesDto> update(Integer idCross_dev, CrossDevicesDto newObj);
    List<CrossDevicesDto> create(CrossDevicesDto obj);
}
