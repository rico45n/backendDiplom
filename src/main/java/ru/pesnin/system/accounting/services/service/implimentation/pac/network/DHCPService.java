package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.network.Dhcp_poolDomain;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.network.DHСP_poolRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IDHCPService;


import java.util.List;

@Service
public class DHCPService implements IDHCPService {
    @Autowired
    private DHСP_poolRepository dhсp_poolRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;

    @Override
    public List<Dhcp_poolDomain> findAll() {
        try {
            return dhсp_poolRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Dhcp_poolDomain read(Dhcp_poolDomain pool_obj) {
        return null;
    }

    @Override
    public List<Dhcp_poolDomain> delete(Integer id_dhcp_pool) {
        try{
            if (dhсp_poolRepository.findById(id_dhcp_pool).get().getIs_status().getId_status() == 2) {
                return dhсp_poolRepository.findAll();
            }
            else {
                dhсp_poolRepository.findById(id_dhcp_pool).map(dhcp_poolDomain -> {
                    dhcp_poolDomain.setIs_status(refStatusRepository.findById(2).get());
                    return dhсp_poolRepository.save(dhcp_poolDomain);
                });
                return dhсp_poolRepository.findAll();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return dhсp_poolRepository.findAll();
        }
    }

    @Override
    public List<Dhcp_poolDomain> update(Integer id_dhcp, Dhcp_poolDomain new_obj) {
        try {
            if (dhсp_poolRepository.findById(id_dhcp).get().getIs_status().getId_status() == 2) {
                return dhсp_poolRepository.findAll();
            }
            else {
                dhсp_poolRepository.findById(id_dhcp).map(dhcp_poolDomain -> {
                    dhcp_poolDomain.setAddress_start(new_obj.getAddress_start());
                    dhcp_poolDomain.setAddress_end(new_obj.getAddress_end());
                    return dhсp_poolRepository.save(dhcp_poolDomain);
                });
                return dhсp_poolRepository.findAll();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<Dhcp_poolDomain> create(Dhcp_poolDomain obj) {
        try {
            Dhcp_poolDomain dhcp_poolDomain = new Dhcp_poolDomain();
            dhcp_poolDomain.setAddress_start(obj.getAddress_start());
            dhcp_poolDomain.setAddress_end(obj.getAddress_end());
            dhcp_poolDomain.setIs_status(refStatusRepository.findById(1).get());
            dhсp_poolRepository.save(dhcp_poolDomain);
            return dhсp_poolRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
