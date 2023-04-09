package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.MapperStringToEntity;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDto;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
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
import java.util.Optional;

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
    private IpServiceI ipService;

    @Override
    public List<NetworkDto> findAll() {
        return this.replaysment(networkRepository.findAll());
    }

    @Override
    public NetworkDto read(int obj) {
        var e = networkRepository.findById(obj).get();
        return NetworkDto.builder()
                .idNetwork(e.getIdNetwork())
                .poolAddress(e.getPoolIpAddress())
                .idPoolAddress(e.getIdPoolAddress().getIdPoolAddress())
                .userReg(e.getIdUserReg().getFioUser())
                .idUserReg(e.getIdUserReg().getUserId())
                .userOld(e.getIdUserOld().getFioUser())
                .idUserOld(e.getIdUserOld().getUserId())
                .vlan(e.getVlan())
                .idVlan(e.getIdVlan().getIdVlan())
                .dhcpPool(e.getDHCPPoolIpAddress())
                .idDhcpPool(e.getIdDhcpPool().getIdDhcpPool())
                .ipAddressNetwork(e.getIpAddressNetwork())
                .networkMask(e.getNetworkMask())
                .build();
    }

    private List<NetworkDto> replaysment(List<NetworkEntity> entities) {
        List<NetworkDto> networkDtos = new ArrayList<>();
        for (NetworkEntity entity : entities) {
            networkDtos.add(NetworkDto.builder()
                    .idNetwork(entity.getIdNetwork())
                    .poolAddress(entity.getPoolIpAddress())
                    .idPoolAddress(entity.getIdPoolAddress().getIdPoolAddress())
                    .userReg(entity.getIdUserReg().getFioUser())
                    .idUserReg(entity.getIdUserReg().getUserId())
                    .userOld(entity.getIdUserOld().getFioUser())
                    .idUserOld(entity.getIdUserOld().getUserId())
                    .vlan(entity.getVlan())
                    .idVlan(entity.getIdVlan().getIdVlan())
                    .dhcpPool(entity.getDHCPPoolIpAddress())
                    .idDhcpPool(entity.getIdDhcpPool().getIdDhcpPool())
                    .ipAddressNetwork(entity.getIpAddressNetwork())
                    .networkMask(entity.getNetworkMask())
                    .ipAndMask(entity.getIpAddressNetwork() + "/" + entity.getNetworkMask())
                    .build());
        }
        return networkDtos;
    }

    @Override
    public List<NetworkDto> delete(Integer idNetwork) {
        networkRepository.deleteById(idNetwork);
        return this.findAll();
    }

    @Override
    public List<NetworkDto> update(Integer idNetwork, NetworkDto obj) {
        try {
            Optional<VlanEntity> vlanEntity = vlanRepository.findById(obj.getIdVlan());
            Optional<UsersEntity> usersEntityReg = userRepository.findById(obj.getIdUserReg());
            Optional<UsersEntity> usersEntityOld = userRepository.findById(obj.getIdUserOld());
            var poll = pool_address_repository.findById(obj.getIdPoolAddress());
            var dhcp = dhcpPoolRepository.findById(obj.getIdPoolAddress());
            networkRepository.findById(idNetwork).map(networkEntity -> {
                networkEntity.setIdVlan(vlanEntity.get());
                networkEntity.setNetworkMask(obj.getNetworkMask());
                networkEntity.setIpAddressNetwork(obj.getIpAddressNetwork());
                networkEntity.setIdUserOld(usersEntityOld.get());
                networkEntity.setIdUserReg(usersEntityReg.get());
                networkEntity.setIdPoolAddress(poll.get());
                networkEntity.setIdDhcpPool(dhcp.get());
                return networkRepository.save(networkEntity);
            });
            return mapperEntityToDto();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }

    }

    @Override
    public List<NetworkDto> create(NetworkDto obj) {
        try {
            var pool = pool_address_repository.findById(obj.getIdDhcpPool()).get();
            var userReg = userRepository.findById(obj.getIdUserReg()).get();
            var userOld = userRepository.findById(obj.getIdUserOld()).get();
            var vlan = vlanRepository.findById(obj.getIdVlan()).get();
            var dhcp = dhcpPoolRepository.findById(obj.getIdDhcpPool()).get();
            networkRepository.save(NetworkEntity.builder()
                    .idNetwork(obj.getIdNetwork())
                    .idPoolAddress(pool)
                    .idUserReg(userReg)
                    .idUserOld(userOld)
                    .idVlan(vlan)
                    .idDhcpPool(dhcp)
                    .ipAddressNetwork(obj.getIpAddressNetwork())
                    .networkMask(obj.getNetworkMask())
                    .build());

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

    private List<NetworkDto> mapperEntityToDto() {
        List<NetworkDto> listNetDto = new ArrayList<>();
        List<NetworkEntity> listNetEntity = networkRepository.findAll();
        for (NetworkEntity networkEntity : listNetEntity) {
            listNetDto.add(new NetworkDto(networkEntity));
        }
        return listNetDto;
    }
}
