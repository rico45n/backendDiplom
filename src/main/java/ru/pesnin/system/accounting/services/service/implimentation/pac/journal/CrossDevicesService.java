package ru.pesnin.system.accounting.services.service.implimentation.pac.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.journal.CrossDevicesDto;
import ru.pesnin.system.accounting.services.entity.journal.CrossDevicesEntity;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
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
    private RefStatusRepository refStatusRepository;
    @Autowired
    private CrossesRepository crossesRepository;


    @Override
    public List<CrossDevicesDto> findAll() {
        return mapperEntityToDto();
    }

    @Override
    public CrossDevicesDto read(CrossDevicesDto obj) {
        return null;
    }

    @Override
    public List<CrossDevicesDto>  delete(Integer idCrossDev, CrossDevicesDto obj) {
        if (crossDevicesRepository.findById(idCrossDev).get().getIsStatus().getIdStatus() != 2) {
            crossDevicesRepository.findById(idCrossDev).map(crossDevicesDomain -> {
                crossDevicesDomain.setDateOld(new Date());
                crossDevicesDomain.setIdUserOld(userRepository.findById(obj.getIdUserOld()).get());
                crossDevicesDomain.setDescription(obj.getDescription());
                crossDevicesDomain.setIsStatus(refStatusRepository.findById(2).get());
                return crossDevicesRepository.save(crossDevicesDomain);
            });


        }
        return mapperEntityToDto();
    }

    @Override
    public List<CrossDevicesDto> update(Integer idCrossDev, CrossDevicesDto obj) {

        if (crossDevicesRepository.findById(idCrossDev).get().getIsStatus().getIdStatus() != 2) {
            crossDevicesRepository.findById(idCrossDev).map(crossDevicesDomainDel -> {
                crossDevicesDomainDel.setDateOld(new Date());
                crossDevicesDomainDel.setIdUserOld(userRepository.findById(obj.getIdUserOld()).get());
                crossDevicesDomainDel.setDescription(obj.getDescription());
                crossDevicesDomainDel.setIsStatus(refStatusRepository.findById(2).get());
                return crossDevicesRepository.save(crossDevicesDomainDel);
            });

            CrossDevicesEntity crossDevicesEntity = new CrossDevicesEntity();

            crossDevicesEntity.setCrossDevicesEntity(
                    devicesRepository.findById(obj.getIdDevicesFirst()).get(),
                    devicesRepository.findById(obj.getIdDevicesEnd()).get(),
                    userRepository.findById(obj.getIdUserOld()).get(),
                    userRepository.findById(0).get(),
                    networkJournalRepository.findById(obj.getIdNetworkJournal()).get(),
                    null,
                    new Date(),
                    null,
                    vlanRepository.findById(obj.getIdVlan()).get(),
                    crossesRepository.findById(obj.getIdCrosses()).get(),
                    refStatusRepository.findById(1).get()
            );
            crossDevicesRepository.save(crossDevicesEntity);
        }
        return mapperEntityToDto();
    }

    @Override
    public List<CrossDevicesDto> create(CrossDevicesDto obj) {
        try {
            CrossDevicesEntity crossDevicesDomain = new CrossDevicesEntity(
                    devicesRepository.findById(obj.getIdDevicesFirst()).get(),
                    devicesRepository.findById(obj.getIdDevicesEnd()).get(),
                    userRepository.findById(obj.getIdUserOtv()).get(),
                    userRepository.findById(0).get(),
                    networkJournalRepository.findById(obj.getIdNetworkJournal()).get(),
                    null,
                    new Date(),
                    null,
                    vlanRepository.findById(obj.getIdVlan()).get(),
                    crossesRepository.findById(obj.getIdCrosses()).get(),
                    refStatusRepository.findById(1).get()
            );
            crossDevicesRepository.save(crossDevicesDomain);
            return mapperEntityToDto();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    private List<CrossDevicesDto> mapperEntityToDto()
    {
        List<CrossDevicesDto> listDto = new ArrayList<>();
        List<CrossDevicesEntity> listEntity = crossDevicesRepository.findAll();
        for (CrossDevicesEntity objEntity : listEntity) {
            listDto.add(new CrossDevicesDto(objEntity));
        }
        return listDto;
    }


}
