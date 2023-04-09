package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;
import ru.pesnin.system.accounting.services.repository.network.VlanRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IVlanService;


import java.util.List;

@Service
public class VlanService implements IVlanService {

    @Autowired
    private VlanRepository vlanRepository;

    @Override
    public List<VlanEntity> findAll() {
        return vlanRepository.findAll();
    }

    @Override
    public VlanEntity read(int obj) {
        return vlanRepository.findById(obj).get();
    }

    @Override
    public List<VlanEntity> delete(Integer idVlan) {
        vlanRepository.deleteById(idVlan);
        return this.findAll();
    }

    @Override
    public List<VlanEntity> update(Integer idVlan, VlanEntity obj) {
        try {

            vlanRepository.findById(idVlan).map(vlanEntity -> {
                vlanEntity.setVlanName(obj.getVlanName());
                vlanEntity.setVlanNumber(obj.getVlanNumber());
                return vlanRepository.save(vlanEntity);
            });
            return vlanRepository.findAll();

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
                    obj
            );
            vlanRepository.save(vlanEntity);
            return vlanRepository.findAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return vlanRepository.findAll();
        }
    }
}
