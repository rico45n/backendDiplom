package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.integration.dto.network.PoolAddressDto;

import java.util.List;

public interface IPoolAddressService {

    List<PoolAddressDto> findAll();
    PoolAddressDto read(int obj);
    List<PoolAddressDto> delete(Integer idPool);
    List<PoolAddressDto> update(Integer idPool, PoolAddressDto newObj);
    List<PoolAddressDto> create(PoolAddressDto obj);
}
