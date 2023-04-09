package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.services.entity.network.VlanEntity;

import java.util.List;

public interface IVlanService {
    List<VlanEntity> findAll();
    VlanEntity read(int obj);
    List<VlanEntity> delete(Integer idVlan);
    List<VlanEntity> update(Integer idVlan, VlanEntity obj);
    List<VlanEntity> create(VlanEntity obj);
}
