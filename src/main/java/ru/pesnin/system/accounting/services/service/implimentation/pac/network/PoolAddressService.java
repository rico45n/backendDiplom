package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.network.PoolAddressDto;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;
import ru.pesnin.system.accounting.services.entity.network.DhcpPoolEntity;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;
import ru.pesnin.system.accounting.services.entity.network.NodesEntity;
import ru.pesnin.system.accounting.services.entity.network.PoolAddressEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.network.DhcpPoolRepository;
import ru.pesnin.system.accounting.services.repository.network.NetworkRepository;
import ru.pesnin.system.accounting.services.repository.network.PoolAddressRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IPoolAddressService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PoolAddressService implements IPoolAddressService {

    @Autowired
    private PoolAddressRepository poolAddressRepository;
    @Autowired
    private UserRepository userRepository;


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
    public PoolAddressDto read(int obj) {
        var e = poolAddressRepository.findById(obj).get();
        System.out.println(e);
        return PoolAddressDto.builder()
                .idPoolAddress(e.getIdPoolAddress())
                .namePool(e.getNamePool())
                .ipAddresStart(e.getIpAddresStart())
                .ipAddresEnd(e.getIpAddresEnd())
                .userOld(e.getFIOOld())
                .idUserOld(e.getIdUserOld().getUserId())
                .userReg(e.getFIOReg())
                .idUserReg(e.getIdUserReg().getUserId())
                .build();
    }

    @Override
    public List<PoolAddressDto> delete(Integer idPool) {
        poolAddressRepository.deleteById(idPool);
        return this.findAll();
    }

    @Override
    public List<PoolAddressDto> update(Integer idPool, PoolAddressDto newPoolAdderDto) {
        try {
            Optional<UsersEntity> usersEntityReg = userRepository.findById(newPoolAdderDto.getIdUserReg());
            Optional<UsersEntity> usersEntityOld = userRepository.findById(newPoolAdderDto.getIdUserOld());
            poolAddressRepository.findById(idPool).map(poolAddressEntity -> {
                poolAddressEntity.setNamePool(newPoolAdderDto.getNamePool());
                poolAddressEntity.setIpAddresStart(newPoolAdderDto.getIpAddresStart());
                poolAddressEntity.setIpAddresEnd(newPoolAdderDto.getIpAddresEnd());
                poolAddressEntity.setIdUserOld(usersEntityOld.get());
                poolAddressEntity.setIdUserReg(usersEntityReg.get());
                poolAddressEntity.setIdUserOld(userRepository.findById(newPoolAdderDto.getIdUserOld()).get());
                return poolAddressRepository.save(poolAddressEntity);
            });

            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    @Override
    public List<PoolAddressDto> create(PoolAddressDto obj) {
        try {
            Optional<UsersEntity> usersEntityReg = userRepository.findById(obj.getIdUserReg());
            Optional<UsersEntity> usersEntityOld = userRepository.findById(obj.getIdUserOld());
            poolAddressRepository.save(PoolAddressEntity.builder()
                    .idPoolAddress(obj.getIdPoolAddress())
                    .namePool(obj.getNamePool())
                    .ipAddresStart(obj.getIpAddresStart())
                    .ipAddresEnd(obj.getIpAddresEnd())
                    .idUserOld(usersEntityOld.get())
                    .idUserReg(usersEntityReg.get())
                    .build());
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
