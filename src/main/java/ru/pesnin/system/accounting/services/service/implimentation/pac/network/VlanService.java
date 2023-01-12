package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.network.VlanDomain;
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
    public List<VlanDomain> findAll() {
        return vlanRepository.findAll();
    }

    @Override
    public VlanDomain read(VlanDomain obj) {
        return null;
    }

    @Override
    public List<VlanDomain> delete(Integer id_vlan, VlanDomain obj) {
        try {
            if(vlanRepository.findById(id_vlan).get().getIs_status().getId_status() == 2) {
                return vlanRepository.findAll();
            }
            else {
                vlanRepository.findById(id_vlan).map(vlanDomain -> {
                    vlanDomain.setIs_status(refStatusRepository.findById(2).get());
                    return vlanRepository.save(vlanDomain);
                });
                return vlanRepository.findAll();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return vlanRepository.findAll();
        }
    }

    @Override
    public List<VlanDomain> update(Integer id_vlan, VlanDomain obj) {
        try {
                if (vlanRepository.findById(id_vlan).get().getIs_status().getId_status() == 2) {
                    return vlanRepository.findAll();
                }
                else {
                    vlanRepository.findById(id_vlan).map(vlanDomain -> {
                        vlanDomain.setVlan_name(obj.getVlan_name());
                        vlanDomain.setVlan_number(obj.getVlan_number());
                        vlanDomain.setIs_status(refStatusRepository.findById(1).get());
                        return vlanRepository.save(vlanDomain);
                    });
                    return vlanRepository.findAll();
                }
        } catch (Exception e) {
                System.out.println(e.getMessage());
                return vlanRepository.findAll();
            }
    }

    @Override
    public List<VlanDomain> create(VlanDomain obj) {
        try {
            VlanDomain vlanDomain = new VlanDomain();
            vlanDomain.setVlan(
                    obj,
                    refStatusRepository.findById(1).get()
            );
            vlanRepository.save(vlanDomain);
            return vlanRepository.findAll();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return vlanRepository.findAll();
        }
    }
}
