package ru.pesnin.system.accounting.services.service.interfase.pac.network;


import ru.pesnin.system.accounting.services.entity.network.DhcpPoolEntity;

import java.util.List;

public interface IDHCPService {

    List<DhcpPoolEntity> findAll();
    DhcpPoolEntity read(int poolAddress);
    List<DhcpPoolEntity> delete(Integer idDhcpPool);
    List<DhcpPoolEntity> update(Integer pool, DhcpPoolEntity newPool);
    List<DhcpPoolEntity> create(DhcpPoolEntity pool);
}
