package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.network.VlanRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IVlanService;


import java.util.List;

@Service
public class VlanService implements IVlanService {

    @Autowired
    private VlanRepository vlanRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;

    @Override
    public List<VlanEntity> findAll() {
        return vlanRepository.findAll();
    }

    @Override
    public VlanEntity read(VlanEntity obj) {
        return null;
    }

    @Override
    public List<VlanEntity> delete(Integer idVlan, VlanEntity obj) {
        try {
            if(vlanRepository.findById(idVlan).get().getIsStatus().getIdStatus() == 2) {
                return vlanRepository.findAll();
            }
            else {
                vlanRepository.findById(idVlan).map(vlanEntity -> {
                    vlanEntity.setIsStatus(refStatusRepository.findById(2).get());
                    return vlanRepository.save(vlanEntity);
                });
                return vlanRepository.findAll();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return vlanRepository.findAll();
        }
    }

    @Override
    public List<VlanEntity> update(Integer idVlan, VlanEntity obj) {
        try {
                if (vlanRepository.findById(idVlan).get().getIsStatus().getIdStatus() == 2) {
                    return vlanRepository.findAll();
                }
                else {
                    vlanRepository.findById(idVlan).map(vlanEntity -> {
                        vlanEntity.setVlanName(obj.getVlanName());
                        vlanEntity.setVlanNumber(obj.getVlanNumber());
                        vlanEntity.setIsStatus(refStatusRepository.findById(1).get());
                        return vlanRepository.save(vlanEntity);
                    });
                    return vlanRepository.findAll();
                }
        } catch (Exception e) {
                System.out.println(e.getMessage());
                return vlanRepository.findAll();
            }
    }

    @Override
    public List<VlanEntity> create(VlanEntity obj) {
        try {
            VlanEntity vlanEntity = new VlanEntity();
            vlanEntity.setVlan(
                    obj,
                    refStatusRepository.findById(1).get()
            );
            vlanRepository.save(vlanEntity);
            return vlanRepository.findAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return vlanRepository.findAll();
        }
    }
}
