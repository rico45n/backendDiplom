package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.MapperStringToEntity;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDTO;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.INetworkService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Network/")
public class NetworkController  {
    @Autowired
    private INetworkService networkService;

    @RequestMapping(value = "/NetworkAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDTO> findAll() {
        return networkService.findAll();
    }

    @RequestMapping(value = "/SearchNetwork/{id_network}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NetworkDTO read(@PathVariable("id_network") NetworkDTO obj) {
        return networkService.read(obj);
    }

    @RequestMapping(value = "/DeleteNetwork/{id_network}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDTO> delete(@PathVariable("id_network") Integer id, @RequestBody NetworkDTO obj) {
        return networkService.delete( id, obj);
    }

    @RequestMapping(value = "/UpdateNetwork/{id_network}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDTO> update(@PathVariable("id_network") Integer id_network, @RequestBody NetworkDTO obj) {
        return networkService.update(id_network, obj);
    }
    @RequestMapping(value = "/CreateNetwork", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NetworkDTO> create(@RequestBody NetworkDTO obj){
        return networkService.create(obj);
    }

    @RequestMapping(value = "/CreateNetworkDHCP", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Integer createNetworkDhcp(@RequestBody MapperStringToEntity obj){

        return networkService.createNetworkDhcp(obj);
    }

}


