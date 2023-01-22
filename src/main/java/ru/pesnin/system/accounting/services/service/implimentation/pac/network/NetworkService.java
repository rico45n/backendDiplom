package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.MapperStringToEntity;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDto;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.network.DhcpPoolRepository;
import ru.pesnin.system.accounting.services.repository.network.NetworkRepository;
import ru.pesnin.system.accounting.services.repository.network.PoolAddressRepository;
import ru.pesnin.system.accounting.services.repository.network.VlanRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.ipservice.IpServiceI;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.INetworkService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NetworkService implements INetworkService {
    @Autowired
    private NetworkRepository networkRepository;
    @Autowired
    private DhcpPoolRepository dhcpPoolRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PoolAddressRepository pool_address_repository;
    @Autowired
    private VlanRepository vlanRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;
    @Autowired
    private NetworkJournalRepository networkJournalRepository;

    @Autowired
    private IpServiceI ipService;

    @Override
    public List<NetworkDto> findAll() {
        return mapperEntityToDto();
    }

    @Override
    public NetworkDto read(NetworkDto obj) {
        return null;
    }

    @Override
    public List<NetworkDto> delete(Integer idNetwork, NetworkDto obj) {
        if(networkRepository.findById(idNetwork).get().getIsStatus().getIdStatus() == 2)
        {
            return mapperEntityToDto();
        }
        else {
            try {
                networkRepository.findById(idNetwork).map(networkEntity -> {
                    networkEntity.setDateOld(new Date());
                    networkEntity.setIdUserOld(userRepository.findById(obj.getIdUserOld()).get());
                    networkEntity.setIsStatus(refStatusRepository.findById(2).get());
                    return networkRepository.save(networkEntity);
                });
                List<NetworkJournalEntity> networkJournalEntities = networkJournalRepository.CascadeDelNet(idNetwork);
                for(NetworkJournalEntity networkJournalEntity : networkJournalEntities){
                    networkJournalEntity.setIsStatus(refStatusRepository.findById(2).get());
                    networkJournalEntity.setIdUserOld(userRepository.findById(obj.getIdUserOld()).get());
                    networkJournalEntity.setDateOld(new Date());
                    networkJournalRepository.save(networkJournalEntity);
                }
                return mapperEntityToDto();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return mapperEntityToDto();
            }
        }
    }

    @Override
    public List<NetworkDto> update(Integer idNetwork, NetworkDto obj) {
        if(networkRepository.findById(idNetwork).get().getIsStatus().getIdStatus() == 2) {
            return mapperEntityToDto();
        }
        else {
            try {
                networkRepository.findById(idNetwork).map(networkEntity -> {
                    networkEntity.setDateOld(new Date());
                    networkEntity.setIdUserOld(userRepository.findById(obj.getIdUserOld()).get());
                    networkEntity.setIsStatus(refStatusRepository.findById(2).get());
                    return networkRepository.save(networkEntity);
                });

                NetworkEntity network = new NetworkEntity();
                network.setNewNetworkEntity(
                        obj,
                        pool_address_repository.findById(obj.getIdPoolAddress()).get(),
                        userRepository.findById(obj.getIdUserReg()).get(),
                        userRepository.findById(obj.getIdUserOld()).get(),
                        vlanRepository.findById(obj.getIdVlan()).get(),
                        dhcpPoolRepository.findById(obj.getIdDhcpPool()).get(),
                        refStatusRepository.findById(1).get()
                );
                networkRepository.save(network);
                return mapperEntityToDto();
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return mapperEntityToDto();
            }
        }
    }

    @Override
    public List<NetworkDto> create(NetworkDto obj) {
        try {
            NetworkEntity networkEntity = new NetworkEntity();
            networkEntity.setNewNetworkEntity(
                    obj,
                    pool_address_repository.findById(obj.getIdPoolAddress()).get(),
                    userRepository.findById(obj.getIdUserReg()).get(),
                    userRepository.findById(0).get(),
                    vlanRepository.findById(obj.getIdVlan()).get(),
                    dhcpPoolRepository.findById(obj.getIdDhcpPool()).get(),
                    refStatusRepository.findById(1).get()
            );
            networkRepository.save(networkEntity);
            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    @Override
    public Integer createNetworkDhcp(MapperStringToEntity obj) {
        return null;
    }

    private List<NetworkDto> mapperEntityToDto()
    {
        List<NetworkDto> listNetDto = new ArrayList<>();
        List<NetworkEntity> listNetEntity = networkRepository.findAll();
        for (NetworkEntity networkEntity : listNetEntity) {
            String endIpAddress = ipService.netAddress(networkEntity.getNetworkInfo());

            float status = (((float) networkRepository.getInitIp_inNetwork(networkEntity.getIpAddressNetwork()).size() /
                    (float) ipService.getAllIpAddress(networkEntity.getIpAddressNetwork(), endIpAddress).size()) * 100);

            String name_status = networkRepository.getInitIp_inNetwork(networkEntity.getIpAddressNetwork()).size() + " из " +
                    ipService.getAllIpAddress(networkEntity.getIpAddressNetwork(), endIpAddress).size();

            listNetDto.add(new NetworkDto(networkEntity, (float) ((float) Math.round(status * 100.0) / 100.0), name_status));
        }
        return listNetDto;
    }
}
