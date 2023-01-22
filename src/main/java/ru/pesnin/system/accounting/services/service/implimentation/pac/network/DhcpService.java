package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.network.DhcpPoolEntity;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.network.DhcpPoolRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IDHCPService;


import java.util.List;

@Service
public class DhcpService implements IDHCPService {
    @Autowired
    private DhcpPoolRepository dhcpPoolRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;

    @Override
    public List<DhcpPoolEntity> findAll() {
        try {
            return dhcpPoolRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public DhcpPoolEntity read(DhcpPoolEntity poolObj) {
        return null;
    }

    @Override
    public List<DhcpPoolEntity> delete(Integer idDhcpPool) {
        try{
            if (dhcpPoolRepository.findById(idDhcpPool).get().getIsStatus().getIdStatus() == 2) {
                return dhcpPoolRepository.findAll();
            }
            else {
                dhcpPoolRepository.findById(idDhcpPool).map(dhcpPoolEntity -> {
                    dhcpPoolEntity.setIsStatus(refStatusRepository.findById(2).get());
                    return dhcpPoolRepository.save(dhcpPoolEntity);
                });
                return dhcpPoolRepository.findAll();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
            return dhcpPoolRepository.findAll();
        }
    }

    @Override
    public List<DhcpPoolEntity> update(Integer idDhcp, DhcpPoolEntity newDhcpPoolEntity) {
        try {
            if (dhcpPoolRepository.findById(idDhcp).get().getIsStatus().getIdStatus() == 2) {
                return dhcpPoolRepository.findAll();
            }
            else {
                dhcpPoolRepository.findById(idDhcp).map(dhcpPoolEntity -> {
                    dhcpPoolEntity.setAddressStart(newDhcpPoolEntity.getAddressStart());
                    dhcpPoolEntity.setAddressEnd(newDhcpPoolEntity.getAddressEnd());
                    return dhcpPoolRepository.save(dhcpPoolEntity);
                });
                return dhcpPoolRepository.findAll();
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public List<DhcpPoolEntity> create(DhcpPoolEntity obj) {
        try {
            DhcpPoolEntity dhcpPoolEntity = new DhcpPoolEntity();
            dhcpPoolEntity.setAddressStart(obj.getAddressStart());
            dhcpPoolEntity.setAddressEnd(obj.getAddressEnd());
            dhcpPoolEntity.setIsStatus(refStatusRepository.findById(1).get());
            dhcpPoolRepository.save(dhcpPoolEntity);
            return dhcpPoolRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
