package ru.pesnin.system.accounting.services.service.interfase.pac.device;



import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceEntity;

import java.util.List;

public interface ITypeDeviceService {
    List<TypeDeviceEntity> findAll();
    TypeDeviceEntity read(int obj);
    List<TypeDeviceEntity> delete(Integer obj);
    List<TypeDeviceEntity> update(TypeDeviceEntity obj, Integer id);
    List<TypeDeviceEntity> create(TypeDeviceEntity obj);
}
