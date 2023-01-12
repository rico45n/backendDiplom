package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.network.Dhcp_poolDomain;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IDHCPService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/DHCP/")
public class DhcpController {
    @Autowired
    private IDHCPService pool_service;

    @RequestMapping(value = "/DHCPAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Dhcp_poolDomain> findAll() {
        return pool_service.findAll();
    }

    @RequestMapping(value = "/SearchDHCP/{id_DHСP_pool}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Dhcp_poolDomain read(@PathVariable("id_DHСP_pool") Dhcp_poolDomain obj) {
        return pool_service.read(obj);
    }

    @RequestMapping(value = "/DeleteDHCP/{id_DHСP_pool}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Dhcp_poolDomain> delete(@PathVariable("id_DHСP_pool") Integer id_dhcp) {
        return pool_service.delete(id_dhcp);
    }

    @RequestMapping(value = "/UpdateDHCP/{id_DHСP_pool}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Dhcp_poolDomain> update(@PathVariable("id_DHСP_pool") Integer id_DHCP_pool, @RequestBody Dhcp_poolDomain new_obj) {
        return pool_service.update(id_DHCP_pool, new_obj);
    }
    @RequestMapping(value = "/CreateDHCP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Dhcp_poolDomain> create(@RequestBody Dhcp_poolDomain obj){
        return pool_service.create(obj);
    }

}
