package ru.pesnin.system.accounting.domain.controllers.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceEntity;
import ru.pesnin.system.accounting.services.service.interfase.pac.device.ITypeDeviceService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/TypeDevices/")
public class TypeDeviceController {
    @Autowired
    private ITypeDeviceService typeDeviceService;

    @RequestMapping(value = "/TypeDevicesAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceEntity> findAll() {
        return typeDeviceService.findAll();
    }

    @RequestMapping(value = "/{id_type_dev}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TypeDeviceEntity read(@PathVariable("id_type_dev") int obj) {
        return typeDeviceService.read(obj);
    }

    @RequestMapping(value = "/DeleteTypeDevices/{id_type_dev}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceEntity> delete(@PathVariable("id_type_dev") Integer obj) {
        return typeDeviceService.delete(obj);
    }

    @RequestMapping(value = "/UpdateTypeDevices/{id_type_dev}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceEntity> update(@RequestBody TypeDeviceEntity obj,
                                         @PathVariable("id_type_dev")  Integer id_type_dev) {
        return typeDeviceService.update(obj, id_type_dev);
    }
    @RequestMapping(value = "/CreateTypeDevices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceEntity> create(@RequestBody TypeDeviceEntity obj){
        return typeDeviceService.create(obj);
    }
}
