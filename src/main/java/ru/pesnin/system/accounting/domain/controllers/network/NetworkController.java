package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.MapperStringToEntity;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDto;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.INetworkService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Network/")
public class NetworkController  {
    @Autowired
    private INetworkService networkService;

    @RequestMapping(value = "/NetworkAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDto> findAll() {
        return networkService.findAll();
    }

    @RequestMapping(value = "/SearchNetwork/{id_network}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NetworkDto read(@PathVariable("id_network") NetworkDto obj) {
        return networkService.read(obj);
    }

    @RequestMapping(value = "/DeleteNetwork/{id_network}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDto> delete(@PathVariable("id_network") Integer id, @RequestBody NetworkDto obj) {
        return networkService.delete( id, obj);
    }

    @RequestMapping(value = "/UpdateNetwork/{id_network}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDto> update(@PathVariable("id_network") Integer id_network, @RequestBody NetworkDto obj) {
        return networkService.update(id_network, obj);
    }
    @RequestMapping(value = "/CreateNetwork", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDto> create(@RequestBody NetworkDto obj){
        return networkService.create(obj);
    }

    @RequestMapping(value = "/CreateNetworkDHCP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer createNetworkDhcp(@RequestBody MapperStringToEntity obj){

        return networkService.createNetworkDhcp(obj);
    }

}


