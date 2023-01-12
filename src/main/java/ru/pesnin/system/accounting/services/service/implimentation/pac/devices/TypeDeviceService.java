package ru.pesnin.system.accounting.services.service.implimentation.pac.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceDomain;
import ru.pesnin.system.accounting.services.repository.devices.TypeDeviceRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.device.ITypeDeviceService;


import java.util.List;

@Service
public class TypeDeviceService implements ITypeDeviceService {

    @Autowired
    private TypeDeviceRepository typeDeviceRepository;

    @Override
    public List<TypeDeviceDomain> findAll() {
        return typeDeviceRepository.findAll();
    }

    @Override
    public TypeDeviceDomain read(TypeDeviceDomain obj) {
        return null;
    }

    @Override
    public List<TypeDeviceDomain> delete(Integer id) {
        return typeDeviceRepository.findAll();
    }

    @Override
    public List<TypeDeviceDomain> update(TypeDeviceDomain obj, Integer id) {
        typeDeviceRepository.findById(id).map(element->{
            element.setName_type_dev(obj.getName_type_dev());
            return typeDeviceRepository.save(element);
        });
        return typeDeviceRepository.findAll();
    }

    @Override
    public List<TypeDeviceDomain> create(TypeDeviceDomain obj) {
        typeDeviceRepository.save(obj);
        return typeDeviceRepository.findAll();
    }
}
