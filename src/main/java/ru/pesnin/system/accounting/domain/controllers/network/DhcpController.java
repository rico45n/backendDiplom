package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.network.DhcpPoolEntity;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IDHCPService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/DHCP/")
public class DhcpController {
    @Autowired
    private IDHCPService pool_service;

    @RequestMapping(value = "/DHCPAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DhcpPoolEntity> findAll() {
        return pool_service.findAll();
    }

    @RequestMapping(value = "/SearchDHCP/{id_DHСP_pool}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public DhcpPoolEntity read(@PathVariable("id_DHСP_pool") DhcpPoolEntity obj) {
        return pool_service.read(obj);
    }

    @RequestMapping(value = "/DeleteDHCP/{id_DHСP_pool}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DhcpPoolEntity> delete(@PathVariable("id_DHСP_pool") Integer id_dhcp) {
        return pool_service.delete(id_dhcp);
    }

    @RequestMapping(value = "/UpdateDHCP/{id_DHСP_pool}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DhcpPoolEntity> update(@PathVariable("id_DHСP_pool") Integer id_DHCP_pool, @RequestBody DhcpPoolEntity new_obj) {
        return pool_service.update(id_DHCP_pool, new_obj);
    }
    @RequestMapping(value = "/CreateDHCP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<DhcpPoolEntity> create(@RequestBody DhcpPoolEntity obj){
        return pool_service.create(obj);
    }

}
