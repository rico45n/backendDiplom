package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.services.entity.network.VlanDomain;

import java.util.List;

public interface IVlanService {
    List<VlanDomain> findAll();
    VlanDomain read(VlanDomain obj);
    List<VlanDomain> delete(Integer id_vlan,  VlanDomain obj);
    List<VlanDomain> update(Integer id_vlan, VlanDomain obj);
    List<VlanDomain> create(VlanDomain obj);
}
