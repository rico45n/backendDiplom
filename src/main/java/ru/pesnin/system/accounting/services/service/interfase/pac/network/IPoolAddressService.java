package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.integration.dto.network.PoolAddressDto;

import java.util.List;

public interface IPoolAddressService {

    List<PoolAddressDto> findAll();
    PoolAddressDto read(PoolAddressDto obj);
    List<PoolAddressDto> delete(Integer idPool, PoolAddressDto obj);
    List<PoolAddressDto> update(Integer idPool, PoolAddressDto newObj);
    List<PoolAddressDto> create(PoolAddressDto obj);
}
