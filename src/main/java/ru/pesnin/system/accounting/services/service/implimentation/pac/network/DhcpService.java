package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.network.DhcpPoolEntity;
import ru.pesnin.system.accounting.services.repository.network.DhcpPoolRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IDHCPService;


import java.util.List;

@Service
public class DhcpService implements IDHCPService {
    @Autowired
    private DhcpPoolRepository dhcpPoolRepository;

    @Override
    public List<DhcpPoolEntity> findAll() {
        try {
            return dhcpPoolRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public DhcpPoolEntity read(int poolObj) {
        return dhcpPoolRepository.findById(poolObj).get();
    }

    @Override
    public List<DhcpPoolEntity> delete(Integer idDhcpPool) {
        dhcpPoolRepository.deleteById(idDhcpPool);
        return this.findAll();
    }

    @Override
    public List<DhcpPoolEntity> update(Integer idDhcp, DhcpPoolEntity newDhcpPoolEntity) {
        try {
            dhcpPoolRepository.findById(idDhcp).map(dhcpPoolEntity -> {
                dhcpPoolEntity.setAddressStart(newDhcpPoolEntity.getAddressStart());
                dhcpPoolEntity.setAddressEnd(newDhcpPoolEntity.getAddressEnd());
                return dhcpPoolRepository.save(dhcpPoolEntity);
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return null;
    }

    @Override
    public List<DhcpPoolEntity> create(DhcpPoolEntity obj) {
        try {
            DhcpPoolEntity dhcpPoolEntity = new DhcpPoolEntity();
            dhcpPoolEntity.setAddressStart(obj.getAddressStart());
            dhcpPoolEntity.setAddressEnd(obj.getAddressEnd());
            dhcpPoolRepository.save(dhcpPoolEntity);
            return dhcpPoolRepository.findAll();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
