package ru.pesnin.system.accounting.domain.controllers.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceDomain;
import ru.pesnin.system.accounting.services.service.interfase.pac.device.ITypeDeviceService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/TypeDevices/")
public class TypeDeviceController {
    @Autowired
    private ITypeDeviceService typeDeviceService;

    @RequestMapping(value = "/TypeDevicesAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceDomain> findAll() {
        return typeDeviceService.findAll();
    }

    @RequestMapping(value = "/SearchTypeDevices/{id_type_dev}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public TypeDeviceDomain read(@PathVariable("id_type_dev") TypeDeviceDomain obj) {
        return typeDeviceService.read(obj);
    }

    @RequestMapping(value = "/DeleteTypeDevices/{id_type_dev}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceDomain> delete(@PathVariable("id_type_dev") Integer obj) {

        return typeDeviceService.delete(obj);
    }

    @RequestMapping(value = "/UpdateTypeDevices/{id_type_dev}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceDomain> update(@RequestBody TypeDeviceDomain obj,
                                         @PathVariable("id_type_dev")  Integer id_type_dev) {
        return typeDeviceService.update(obj, id_type_dev);
    }
    @RequestMapping(value = "/CreateTypeDevices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<TypeDeviceDomain> create(@RequestBody TypeDeviceDomain obj){
        return typeDeviceService.create(obj);
    }
}
