package ru.pesnin.system.accounting.services.service.interfase.pac.network;


import ru.pesnin.system.accounting.services.entity.network.Dhcp_poolDomain;

import java.util.List;

public interface IDHCPService {

    List<Dhcp_poolDomain> findAll();
    Dhcp_poolDomain read(Dhcp_poolDomain pool_address);
    List<Dhcp_poolDomain> delete(Integer id_dhcp_pool);
    List<Dhcp_poolDomain> update(Integer pool,Dhcp_poolDomain new_pool);
    List<Dhcp_poolDomain> create(Dhcp_poolDomain pool);
}
