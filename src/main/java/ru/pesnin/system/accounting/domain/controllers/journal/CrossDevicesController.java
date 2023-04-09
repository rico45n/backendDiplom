package ru.pesnin.system.accounting.domain.controllers.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.journal.CrossDevicesDto;
import ru.pesnin.system.accounting.services.service.interfase.pac.journal.ICrossDevicesService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/CrossDevices/")
public class CrossDevicesController  {
    @Autowired
    private ICrossDevicesService crossDevicesService;

    @RequestMapping(value = "/CrossDevicesAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossDevicesDto> findAll() {
        return crossDevicesService.findAll();
    }

    @RequestMapping(value = "/{id_crossdevices}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public CrossDevicesDto read(@PathVariable("id_crossdevices") int obj) {
        return crossDevicesService.read(obj);
    }

    @RequestMapping(value = "/DeleteCrossDevices/{id_crossdevices}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossDevicesDto> delete(@PathVariable("id_crossdevices") Integer id_crossdevices) {
        return crossDevicesService.delete(id_crossdevices);
    }

    @RequestMapping(value = "/UpdateCrossDevices/{id_crossdevices}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossDevicesDto> update(@PathVariable("id_crossdevices") Integer id_crossdevices, @RequestBody CrossDevicesDto new_obj) {
        return crossDevicesService.update(id_crossdevices, new_obj);
    }
    @RequestMapping(value = "/CreateCrossDevices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossDevicesDto> create(@RequestBody CrossDevicesDto obj){
        return crossDevicesService.create(obj);
    }

}
