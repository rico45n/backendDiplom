package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IVlanService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Vlan/")
public class VlanController {
    @Autowired
    private IVlanService vlanService;

    @RequestMapping(value = "/VlanAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VlanEntity> findAll() {
        return vlanService.findAll();
    }

    @RequestMapping(value = "/SearchVlan/{id_vlan}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public VlanEntity read(@PathVariable("id_vlan") VlanEntity obj) {
        return vlanService.read(obj);
    }

    @RequestMapping(value = "/DeleteVlan/{id_vlan}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VlanEntity>  delete(@PathVariable("id_vlan") Integer id_vlan, @RequestBody VlanEntity obj) {
        return vlanService.delete(id_vlan, obj);
    }

    @RequestMapping(value = "/UpdateVlan/{id_vlan}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VlanEntity> update(@PathVariable("id_vlan") Integer id_vlan, @RequestBody VlanEntity new_obj) {
        return vlanService.update(id_vlan, new_obj);
    }
    @RequestMapping(value = "/CreateVlan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<VlanEntity> create(@RequestBody VlanEntity obj){
        return vlanService.create(obj);
    }

}
