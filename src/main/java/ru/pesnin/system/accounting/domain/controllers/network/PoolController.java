package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.network.PoolAddressDto;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IPoolAddressService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Pool/")
public class  PoolController  {
    @Autowired
    private IPoolAddressService pool_service;

    @RequestMapping(value = "/PoolAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PoolAddressDto> findAll() {
        return pool_service.findAll();
    }

    @RequestMapping(value = "/SearchPool/{id_pool_address}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public PoolAddressDto read(@PathVariable("id_pool_address") PoolAddressDto obj) {
        return pool_service.read(obj);
    }

    @RequestMapping(value = "/DeletePool/{id_pool_address}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PoolAddressDto> delete(@PathVariable("id_pool_address") Integer id_pool , @RequestBody PoolAddressDto obj) {
        return pool_service.delete(id_pool ,obj);
    }

    @RequestMapping(value = "/UpdatePool/{id_pool_address}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PoolAddressDto> update(@PathVariable("id_pool_address") Integer id_pool, @RequestBody PoolAddressDto new_obj) {
        return pool_service.update(id_pool, new_obj);
    }
    @RequestMapping(value = "/CreatePool", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<PoolAddressDto> create(@RequestBody PoolAddressDto obj){
        return pool_service.create(obj);
    }

}


