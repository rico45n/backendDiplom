package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.network.PoolAddressDto;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;
import ru.pesnin.system.accounting.services.entity.network.DhcpPoolEntity;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;
import ru.pesnin.system.accounting.services.entity.network.PoolAddressEntity;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.network.DhcpPoolRepository;
import ru.pesnin.system.accounting.services.repository.network.NetworkRepository;
import ru.pesnin.system.accounting.services.repository.network.PoolAddressRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IPoolAddressService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoolAddressService implements IPoolAddressService {

    @Autowired
    private PoolAddressRepository poolAddressRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;

    @Autowired
    private NetworkRepository networkRepository;
    @Autowired
    private NetworkJournalRepository networkJournalRepository;
    @Autowired
    private DhcpPoolRepository dhcpPoolRepository;

    @Override
    public List<PoolAddressDto> findAll() {
        try {
            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public PoolAddressDto read(PoolAddressDto obj) {
        return obj;
    }

    @Override
    public List<PoolAddressDto> delete(Integer idPool, PoolAddressDto poolAddressDto) {
        try {
            poolAddressRepository.findById(idPool).map(poolAddressEntity -> {
                poolAddressEntity.setDateOld(new Date());
                poolAddressEntity.setIdUserOld(userRepository.findById(poolAddressDto.getIdUserOld()).get());
                poolAddressEntity.setIsStatus(refStatusRepository.findById(2).get());
                return poolAddressRepository.save(poolAddressEntity);
            });

            try {
                List<NetworkEntity> networkEntities = networkRepository.findByAndIdPoolAddress(idPool);
                for (NetworkEntity networkEntity : networkEntities) {
                    networkEntity.setIsStatus(refStatusRepository.findById(2).get());
                    networkEntity.setIdUserOld(userRepository.findById(poolAddressDto.getIdUserOld()).get());
                    networkEntity.setDateOld(new Date());
                    networkRepository.save(networkEntity);
                }

            } catch (Exception e) {
                System.out.println("Ошибка удаления сети: " + e.getMessage());
            }
            try {

                List<NetworkEntity> networkEntities = networkRepository.findByAndIdPoolAddress(idPool);

                for (NetworkEntity networkEntity : networkEntities) {
                    List<NetworkJournalEntity> networkJournalEntities = networkJournalRepository.CascadeDelNet(networkEntity.getIdNetwork());
                    for (NetworkJournalEntity networkJournalEntity : networkJournalEntities) {
                        networkJournalEntity.setDateOld(new Date());
                        networkJournalEntity.setIsStatus(refStatusRepository.findById(2).get());
                        networkJournalEntity.setIdUserOld(userRepository.findById(poolAddressDto.getIdUserOld()).get());
                        networkJournalRepository.save(networkJournalEntity);
                    }
                }

            } catch (Exception e) {
                System.out.println("Ошибка удаления записи из Журнала ip-адресного пространства:" + e.getMessage());
            }

            try {
                List<NetworkEntity> networkDomains = networkRepository.findByAndIdPoolAddress(idPool);
                for (NetworkEntity networkDomain : networkDomains) {
                    DhcpPoolEntity dhcpPoolEntity = dhcpPoolRepository.findById(networkDomain.getIdDhcpPool().getIdDhcpPool()).get();
                    dhcpPoolEntity.setIsStatus(refStatusRepository.findById(2).get());
                    dhcpPoolRepository.save(dhcpPoolEntity);
                }
            } catch (Exception e) {
                System.out.println("Ошибка удаления DHCP пула:" + e.getMessage());
            }
            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    @Override
    public List<PoolAddressDto> update(Integer idPool, PoolAddressDto newPoolAdderDto) {
        try {

            poolAddressRepository.findById(idPool).map(poolAddressEntity -> {
                poolAddressEntity.setDateOld(new Date());
                poolAddressEntity.setIdUserOld(userRepository.findById(newPoolAdderDto.getIdUserOld()).get());
                poolAddressEntity.setIsStatus(refStatusRepository.findById(2).get());
                return poolAddressRepository.save(poolAddressEntity);
            });

            PoolAddressEntity poolAddressEntity = new PoolAddressEntity();
            poolAddressEntity.setNewPool(
                    newPoolAdderDto,
                    userRepository.findById(newPoolAdderDto.getIdUserOld()).get(),
                    userRepository.findById(0).get(),
                    refStatusRepository.findById(1).get(),
                    new Date(),
                    null
            );
            poolAddressRepository.save(poolAddressEntity);
            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    @Override
    public List<PoolAddressDto> create(PoolAddressDto obj) {
        try {

            PoolAddressEntity poolAddressEntity = new PoolAddressEntity();
            poolAddressEntity.setNewPool(
                    obj,
                    userRepository.findById(obj.getIdUserReg()).get(),
                    userRepository.findById(0).get(),
                    refStatusRepository.findById(1).get(),
                    new Date(),
                    null
            );
            poolAddressRepository.save(poolAddressEntity);
            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    private List<PoolAddressDto> mapperEntityToDto() {
        List<PoolAddressDto> listDto = new ArrayList<>();
        List<PoolAddressEntity> listEntity = poolAddressRepository.findAll();
        for (int i = 0; i < listEntity.size(); i++) {
            PoolAddressEntity objEntity = listEntity.get(i);
            listDto.add(new PoolAddressDto(objEntity));
        }
        return listDto;
    }
}
