package ru.pesnin.system.accounting.domain.controllers.devices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.devices.DevicesDto;
import ru.pesnin.system.accounting.integration.dto.devices.InfoCrossDeviceEndDto;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalDeviceFilter;
import ru.pesnin.system.accounting.services.service.interfase.pac.device.IDeviceService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Devices/")
public class DevicesController {
    @Autowired
    private IDeviceService deviceService;

    @RequestMapping(value = "/DevicesAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DevicesDto> findAll() {
        return deviceService.findAll();
    }

    @RequestMapping(value = "/SearchDevices/{id_devices}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DevicesDto read(@PathVariable("id_devices") DevicesDto obj) {
        return deviceService.read(obj);
    }

    @RequestMapping(value = "/DeleteDevices/{id_devices}?{id_user_old}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DevicesDto> delete(@PathVariable("id_devices") Integer id_devices, @PathVariable("id_user_old") Integer id_user_old) {
        return deviceService.delete(id_devices, id_user_old);
    }

    @RequestMapping(value = "/SearchCrossDevicesInfo/{id_devices}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public InfoCrossDeviceEndDto searchCrossDeviceInfo(@PathVariable("id_devices") Integer id_devices) {
        return deviceService.searchCrossDeviceInfo(id_devices);
    }

    @RequestMapping(value = "/getAllCrossDevicesInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<InfoCrossDeviceEndDto> getAllCrossDevicesInfo() {
        return deviceService.getAllCrossDevicesInfo();
    }

    @RequestMapping(value = "/UpdateDevices/{id_devices}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DevicesDto> update(@RequestBody DevicesDto obj,
                                   @PathVariable("id_devices")  Integer id_devices) {
        return deviceService.update(obj, id_devices);
    }
    @RequestMapping(value = "/CreateDevices", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DevicesDto> create(@RequestBody DevicesDto obj){
        try {
            return deviceService.create(obj);
        }catch (Exception e){
            return deviceService.findAll();
        }
    }

    @RequestMapping(value = "/getNetJournalDeviceFilter", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkJournalDeviceFilter> getAllDeviceFilter() {
        return deviceService.getAllDeviceFilter();
    }
}
