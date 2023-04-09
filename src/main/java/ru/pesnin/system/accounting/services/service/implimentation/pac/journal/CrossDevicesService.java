package ru.pesnin.system.accounting.services.service.implimentation.pac.journal;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.journal.CrossDevicesDto;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;
import ru.pesnin.system.accounting.services.entity.journal.CrossDevicesEntity;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;
import ru.pesnin.system.accounting.services.entity.network.CrossesEntity;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.repository.devices.DevicesRepository;
import ru.pesnin.system.accounting.services.repository.journal.CrossDevicesRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.network.CrossesRepository;
import ru.pesnin.system.accounting.services.repository.network.VlanRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.journal.ICrossDevicesService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CrossDevicesService implements ICrossDevicesService {
    @Autowired
    private CrossDevicesRepository crossDevicesRepository;
    @Autowired
    private DevicesRepository devicesRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private VlanRepository vlanRepository;
    @Autowired
    private NetworkJournalRepository networkJournalRepository;
    @Autowired
    private CrossesRepository crossesRepository;


    @Override
    public List<CrossDevicesDto> findAll() {
        return mapperEntityToDto();
    }

    @Override
    public CrossDevicesDto read(int obj) {
        return null;
    }

    @Override
    public List<CrossDevicesDto> delete(Integer idCrossDev) {
        crossDevicesRepository.deleteById(idCrossDev);
        return mapperEntityToDto();
    }

    @Override
    public List<CrossDevicesDto> update(Integer idCrossDev, CrossDevicesDto obj) {

        return mapperEntityToDto();
    }

    @Override
    public List<CrossDevicesDto> create(CrossDevicesDto obj) {
        try {
            System.out.println(obj);
            var cross = crossesRepository.findById(obj.getIdCrosses());
            var dev = devicesRepository.findById(obj.getIdDevicesFirst());
            var dev2 = devicesRepository.findById(obj.getIdDevicesEnd());
            var userOtv = userRepository.findById(obj.getIdUserOtv());
            var userOld = userRepository.findById(obj.getIdUserOld());
            var net = networkJournalRepository.findById(obj.getIdNetworkJournal());
            var lan = vlanRepository.findById(obj.getIdVlan());

            crossDevicesRepository.save(CrossDevicesEntity.builder()
                    .idCrosses(cross.get())
                    .idDevicesFirst(dev.get())
                    .idDevicesEnd(dev2.get())
                    .idUserOtv(userOtv.get())
                    .idUserOld(userOld.get())
                    .idNetworkJournal(net.get())
                    .description(obj.getDescription())
                    .idVlan(lan.get())
                    .build());
            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    private List<CrossDevicesDto> mapperEntityToDto() {
        List<CrossDevicesDto> listDto = new ArrayList<>();
        List<CrossDevicesEntity> listEntity = crossDevicesRepository.findAll();
        for (CrossDevicesEntity objEntity : listEntity) {
            listDto.add(new CrossDevicesDto(objEntity));
        }
        return listDto;
    }


}
