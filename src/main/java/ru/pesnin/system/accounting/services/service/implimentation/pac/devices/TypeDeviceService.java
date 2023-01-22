package ru.pesnin.system.accounting.services.service.implimentation.pac.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceEntity;
import ru.pesnin.system.accounting.services.repository.devices.TypeDeviceRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.device.ITypeDeviceService;


import java.util.List;

@Service
public class TypeDeviceService implements ITypeDeviceService {

    @Autowired
    private TypeDeviceRepository typeDeviceRepository;

    @Override
    public List<TypeDeviceEntity> findAll() {
        return typeDeviceRepository.findAll();
    }

    @Override
    public TypeDeviceEntity read(TypeDeviceEntity obj) {
        return null;
    }

    @Override
    public List<TypeDeviceEntity> delete(Integer id) {
        return typeDeviceRepository.findAll();
    }

    @Override
    public List<TypeDeviceEntity> update(TypeDeviceEntity obj, Integer id) {
        typeDeviceRepository.findById(id).map(element->{
            element.setNameTypeDev(obj.getNameTypeDev());
            return typeDeviceRepository.save(element);
        });
        return typeDeviceRepository.findAll();
    }

    @Override
    public List<TypeDeviceEntity> create(TypeDeviceEntity obj) {
        typeDeviceRepository.save(obj);
        return typeDeviceRepository.findAll();
    }
}
