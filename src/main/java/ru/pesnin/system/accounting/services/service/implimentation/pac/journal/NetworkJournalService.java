package ru.pesnin.system.accounting.services.service.implimentation.pac.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalIpAddressFilter;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDto;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalEntity;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.devices.DevicesRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;

import ru.pesnin.system.accounting.services.repository.network.DhcpPoolRepository;
import ru.pesnin.system.accounting.services.repository.network.NetworkRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.ipservice.IpServiceI;
import ru.pesnin.system.accounting.services.service.interfase.pac.journal.INetworkJournalService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NetworkJournalService implements INetworkJournalService {
    @Autowired
    private NetworkJournalRepository networkJournalRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;
    @Autowired
    private NetworkRepository networkRepository;
    @Autowired
    private DevicesRepository devicesRepository;
    @Autowired
    private IpServiceI ipService;
    @Autowired
    private DhcpPoolRepository dhcpPoolRepository;

    @Override
    public List<NetworkJournalDto> findAll() {
        return mapperEntityToDto();
    }

    @Override
    public NetworkJournalDto read(NetworkJournalDto obj) {
        return null;
    }

    @Override
    public List<NetworkJournalDto> delete(Integer idNetworkJournal, NetworkJournalDto newObj) {
        try {
            networkJournalRepository.findById(idNetworkJournal).map(networkJournalDomain -> {
                networkJournalDomain.setDateOld(new Date());
                networkJournalDomain.setIdUserOld(userRepository.findById(newObj.getIdUserReg()).get());
                networkJournalDomain.setIsStatus(refStatusRepository.findById(2).get());
                return networkJournalRepository.save(networkJournalDomain);
            });
            return mapperEntityToDto();
        }catch (Exception e){
            return mapperEntityToDto();
        }
    }

    @Override
    public List<NetworkJournalDto> update(Integer idNetworkJournal , NetworkJournalDto obj) {
        try{
            networkJournalRepository.findById(idNetworkJournal).map(networkJournalEntity -> {
                networkJournalEntity.setDateOld(new Date());
                networkJournalEntity.setIdUserOld(userRepository.findById(obj.getIdUserReg()).get());
                networkJournalEntity.setIsStatus(refStatusRepository.findById(2).get());
                return networkJournalRepository.save(networkJournalEntity);
            });
            NetworkJournalEntity networkJournalEntity = new NetworkJournalEntity();
            networkJournalEntity.setNetworkJournalEntity(
                    networkRepository.findById(obj.getIdNetwork()).get(),
                    obj,
                    userRepository.findById(obj.getIdUserReg()).get(),
                    userRepository.findById(0).get(),
                    devicesRepository.findById(obj.getIdDevices()).get(),
                    refStatusRepository.findById(1).get());

            networkJournalRepository.save(networkJournalEntity);
            return mapperEntityToDto();
        }catch (Exception e) {
            return mapperEntityToDto();
        }
    }

    @Override
    public List<NetworkJournalDto> create(NetworkJournalDto obj) {
        try{
            NetworkJournalEntity networkJournalEntity = new NetworkJournalEntity();
            networkJournalEntity.setNetworkJournalEntity(
                    networkRepository.findById(obj.getIdNetwork()).get(),
                    obj,
                    userRepository.findById(obj.getIdUserReg()).get(),
                    userRepository.findById(0).get(),
                    devicesRepository.findById(obj.getIdDevices()).get(),
                    refStatusRepository.findById(1).get());

            networkJournalRepository.save(networkJournalEntity);
            return mapperEntityToDto();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    @Override
    public List<NetworkJournalIpAddressFilter> findByIpAddress(Integer id_network) {
        try {
            String netAddrIP = networkRepository.findById(id_network).get().getIpAddressNetwork();
            String netAddrIPend = ipService.netAddress(networkRepository.findById(id_network).get().getNetworkInfo());

            NetworkEntity networkDomain = networkRepository.findById(id_network).get();
            List<String> ListIpAddressNet = new ArrayList<>();
            List<String> ListDHCPIPAddress = new ArrayList<>();

            try {
                String netAddrDHCP = dhcpPoolRepository.findById(networkDomain.getIdDhcpPool().getIdDhcpPool()).get().getPoolIP();

                String[] dhcpPoolAddress = netAddrDHCP.replaceAll(" ", "").split("-");

                ListIpAddressNet = ipService.getAllIpAddress(netAddrIP, netAddrIPend);
                ListDHCPIPAddress = ipService.getAllIpAddress(dhcpPoolAddress[0], dhcpPoolAddress[1]);

                for (int dhcpIP = 0; dhcpIP < ListDHCPIPAddress.size(); dhcpIP++) {
                    for (int netIP = 0; netIP < ListIpAddressNet.size(); netIP++) {
                        if (equals(ListDHCPIPAddress.get(dhcpIP)) == equals(ListIpAddressNet.get(netIP))) {
                            String t = ListIpAddressNet.get(netIP) + " (dhcp)";
                            ListIpAddressNet.remove(netIP);
                            ListIpAddressNet.add(t);
                            break;
                        }
                    }
                }

                List<String> ipAddressFromDb = networkJournalRepository.findBy_ipAddress();

                for (int i = 0; i < ipAddressFromDb.size(); i++){
                    for (int j = 0; j < ListDHCPIPAddress.size(); j++){
                        if(equals(ListDHCPIPAddress.get(j)) == equals(ipAddressFromDb.get(i))){
                            ListDHCPIPAddress.remove(j);
                            break;
                        }
                    }
                }

            }catch (Exception e) {
                ListIpAddressNet = ipService.getAllIpAddress(netAddrIP, netAddrIPend);
            }

            List<NetworkJournalIpAddressFilter> networkJournalIpAddressFilters = new ArrayList<>();
            for (int ip = 0; ip < ListIpAddressNet.size(); ip ++) {
                NetworkJournalIpAddressFilter netFilter = new NetworkJournalIpAddressFilter(ip, ListIpAddressNet.get(ip));
                networkJournalIpAddressFilters.add(netFilter);
            }

            return networkJournalIpAddressFilters;
        }catch (Exception e){
            NetworkJournalIpAddressFilter networkJournalIpAddressFilter = new NetworkJournalIpAddressFilter(0,"");
            List<NetworkJournalIpAddressFilter> networkJournalIpAddressFilters = new ArrayList<>();
            networkJournalIpAddressFilters.add(networkJournalIpAddressFilter);
            return networkJournalIpAddressFilters;
        }
    }

    private List<NetworkJournalDto> mapperEntityToDto()
    {
        List<NetworkJournalDto> listDto = new ArrayList<>();
        List<NetworkJournalEntity> listEntity = networkJournalRepository.findAll();
        for(int i = 0; i<listEntity.size(); i++) {
            NetworkJournalEntity obj_dom = listEntity.get(i);
            listDto.add(new NetworkJournalDto(obj_dom));
        }
        return listDto;
    }


}
