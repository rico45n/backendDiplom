package ru.pesnin.system.accounting.services.service.implimentation.pac.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.filter.NetworkJournalIpAddressFilter;
import ru.pesnin.system.accounting.integration.dto.journal.NetworkJournalDTO;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalDomain;
import ru.pesnin.system.accounting.services.entity.network.NetworkDomain;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.devices.DevicesRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.network.DHСP_poolRepository;
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
    private DHСP_poolRepository dhсp_poolRepository;

    @Override
    public List<NetworkJournalDTO> findAll() {
        return mapperEntityToDTO();
    }

    @Override
    public NetworkJournalDTO read(NetworkJournalDTO obj) {
        return null;
    }

    @Override
    public List<NetworkJournalDTO> delete(Integer id_network_journal, NetworkJournalDTO new_obj) {
        try {
            networkJournalRepository.findById(id_network_journal).map(networkJournalDomain -> {
                networkJournalDomain.setDate_old(new Date());
                networkJournalDomain.setId_user_old(userRepository.findById(new_obj.getId_user_reg()).get());
                networkJournalDomain.setIs_status(refStatusRepository.findById(2).get());
                return networkJournalRepository.save(networkJournalDomain);
            });
            return mapperEntityToDTO();
        }catch (Exception e){
            return mapperEntityToDTO();
        }
    }

    @Override
    public List<NetworkJournalDTO> update(Integer id_network_journal , NetworkJournalDTO obj) {
        try{
            networkJournalRepository.findById(id_network_journal).map(networkJournalDomain -> {
                networkJournalDomain.setDate_old(new Date());
                networkJournalDomain.setId_user_old(userRepository.findById(obj.getId_user_reg()).get());
                networkJournalDomain.setIs_status(refStatusRepository.findById(2).get());
                return networkJournalRepository.save(networkJournalDomain);
            });
            NetworkJournalDomain networkJournalDomain = new NetworkJournalDomain();
            networkJournalDomain.setNetworkJournalDomain(
                    networkRepository.findById(obj.getId_network()).get(),
                    obj,
                    userRepository.findById(obj.getId_user_reg()).get(),
                    userRepository.findById(0).get(),
                    devicesRepository.findById(obj.getId_devices()).get(),
                    refStatusRepository.findById(1).get());

            networkJournalRepository.save(networkJournalDomain);
            return mapperEntityToDTO();
        }catch (Exception e) {
            return mapperEntityToDTO();
        }
    }

    @Override
    public List<NetworkJournalDTO> create(NetworkJournalDTO obj) {
        try{
            NetworkJournalDomain networkJournalDomain = new NetworkJournalDomain();
            networkJournalDomain.setNetworkJournalDomain(
                    networkRepository.findById(obj.getId_network()).get(),
                    obj,
                    userRepository.findById(obj.getId_user_reg()).get(),
                    userRepository.findById(0).get(),
                    devicesRepository.findById(obj.getId_devices()).get(),
                    refStatusRepository.findById(1).get());

            networkJournalRepository.save(networkJournalDomain);
            return mapperEntityToDTO();
        }catch (Exception e) {
            System.out.println(e.getMessage());
            return mapperEntityToDTO();
        }
    }

    @Override
    public List<NetworkJournalIpAddressFilter> findByIpAddress(Integer id_network) {
        try {

            String netAddrIP = networkRepository.findById(id_network).get().getIp_address_network();
            String netAddrIPend = ipService.netAddress(networkRepository.findById(id_network).get().getNetworkInfo());

            NetworkDomain networkDomain = networkRepository.findById(id_network).get();
            List<String> ListIpAddressNet = new ArrayList<>();
            List<String> ListDHCPIPAddress = new ArrayList<>();

            try {
                String netAddrDHCP = dhсp_poolRepository.findById(networkDomain.getId_DHCP_pool().getId_DHCP_pool()).get().getPoolIP();

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

                List<String> ip_address_from_db = networkJournalRepository.findBy_ipAddress();

                for (int i = 0; i < ip_address_from_db.size(); i++){
                    for (int j = 0; j < ListDHCPIPAddress.size(); j++){
                        if(equals(ListDHCPIPAddress.get(j)) == equals(ip_address_from_db.get(i))){
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

    private List<NetworkJournalDTO> mapperEntityToDTO()
    {
        List<NetworkJournalDTO> listDTO = new ArrayList<>();
        List<NetworkJournalDomain> listDom = networkJournalRepository.findAll();
        for(int i = 0; i<listDom.size(); i++) {
            NetworkJournalDomain obj_dom = listDom.get(i);
            listDTO.add(new NetworkJournalDTO(obj_dom));
        }
        return listDTO;
    }


}
