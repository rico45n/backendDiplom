package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.integration.dto.network.Pool_address_DTO;

import java.util.List;

public interface IPoolAddressService {

    List<Pool_address_DTO> findAll();
    Pool_address_DTO read(Pool_address_DTO obj);
    List<Pool_address_DTO> delete(Integer id_pool, Pool_address_DTO obj);
    List<Pool_address_DTO> update(Integer id_pool, Pool_address_DTO new_obj);
    List<Pool_address_DTO> create(Pool_address_DTO obj);
}
