package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.network.Pool_address_DTO;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalDomain;
import ru.pesnin.system.accounting.services.entity.network.Dhcp_poolDomain;
import ru.pesnin.system.accounting.services.entity.network.NetworkDomain;
import ru.pesnin.system.accounting.services.entity.network.Pool_address_Domain;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.journal.NetworkJournalRepository;
import ru.pesnin.system.accounting.services.repository.network.DHСP_poolRepository;
import ru.pesnin.system.accounting.services.repository.network.NetworkRepository;
import ru.pesnin.system.accounting.services.repository.network.Pool_address_Repository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.IPoolAddressService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class PoolAddressService implements IPoolAddressService {

    @Autowired
    private Pool_address_Repository pool_address_repository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RefStatusRepository refStatusRepository;

    @Autowired
    private NetworkRepository networkRepository;
    @Autowired
    private NetworkJournalRepository networkJournalRepository;
    @Autowired
    private DHСP_poolRepository dhcp_poolRepository;

    @Override
    public List<Pool_address_DTO> findAll() {
        try {
            return mapperEntityToDTO();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Pool_address_DTO read(Pool_address_DTO obj) {
        return obj;
    }

    @Override
    public List<Pool_address_DTO> delete(Integer id_pool, Pool_address_DTO obj) {
        try {
            pool_address_repository.findById(id_pool).map(pool_address_domain -> {
                pool_address_domain.setDate_old(new Date());
                pool_address_domain.setId_user_old(userRepository.findById(obj.getId_user_old()).get());
                pool_address_domain.setIs_status(refStatusRepository.findById(2).get());
                return pool_address_repository.save(pool_address_domain);
            });

            try {
                List<NetworkDomain> networkDomains = networkRepository.findBy_AndId_pool_address(id_pool);
                for (NetworkDomain networkDomain : networkDomains){
                   networkDomain.setIs_status(refStatusRepository.findById(2).get());
                   networkDomain.setId_user_old(userRepository.findById(obj.getId_user_old()).get());
                   networkDomain.setDate_old(new Date());
                   networkRepository.save(networkDomain);
               }

            }catch (Exception e){
                System.out.println("Ошибка удаления сети: "+ e.getMessage());
            }
            try {

                List<NetworkDomain> networkDomains = networkRepository.findBy_AndId_pool_address(id_pool);

                for (NetworkDomain networkDomain : networkDomains){
                    List<NetworkJournalDomain> networkJournalDomains = networkJournalRepository.CascadeDelNet(networkDomain.getId_network());
                    for (NetworkJournalDomain networkJournalDomain : networkJournalDomains){
                        networkJournalDomain.setDate_old(new Date());
                        networkJournalDomain.setIs_status(refStatusRepository.findById(2).get());
                        networkJournalDomain.setId_user_old(userRepository.findById(obj.getId_user_old()).get());
                       networkJournalRepository.save(networkJournalDomain);
                    }
                }

            }catch (Exception e)
            {
                System.out.println("Ошибка удаления записи из Журнала ip-адресного пространства:" + e.getMessage());
            }

            try{
                List<NetworkDomain> networkDomains = networkRepository.findBy_AndId_pool_address(id_pool);

                for (NetworkDomain networkDomain : networkDomains){
                        Dhcp_poolDomain dhcp_poolDomain = dhcp_poolRepository.findById(networkDomain.getId_DHCP_pool().getId_DHCP_pool()).get();
                        dhcp_poolDomain.setIs_status(refStatusRepository.findById(2).get());
                        dhcp_poolRepository.save(dhcp_poolDomain);
                }
            }catch (Exception e){
                System.out.println("Ошибка удаления DHCP пула:" + e.getMessage());
            }
            return mapperEntityToDTO();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return mapperEntityToDTO();
        }
    }

    @Override
    public List<Pool_address_DTO> update(Integer id_pool, Pool_address_DTO new_obj) {
        try {

            pool_address_repository.findById(id_pool).map(pool_address_domain -> {
                pool_address_domain.setDate_old(new Date());
                pool_address_domain.setId_user_old(userRepository.findById(new_obj.getId_user_old()).get());
                pool_address_domain.setIs_status(refStatusRepository.findById(2).get());
                return pool_address_repository.save(pool_address_domain);
            });

            Pool_address_Domain pool_address_domain = new Pool_address_Domain();
            pool_address_domain.setNewPool(
                    new_obj,
                    userRepository.findById(new_obj.getId_user_old()).get(),
                    userRepository.findById(0).get(),
                    refStatusRepository.findById(1).get(),
                    new Date(),
                    null
            );
            pool_address_repository.save(pool_address_domain);
            return mapperEntityToDTO();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return mapperEntityToDTO();
        }
    }

    @Override
    public List<Pool_address_DTO> create(Pool_address_DTO obj) {
        try {

            Pool_address_Domain pool_address_domain = new Pool_address_Domain();
            pool_address_domain.setNewPool(
                    obj,
                    userRepository.findById(obj.getId_user_reg()).get(),
                    userRepository.findById(0).get(),
                    refStatusRepository.findById(1).get(),
                    new Date(),
                    null
            );
            pool_address_repository.save(pool_address_domain);
            return mapperEntityToDTO();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return mapperEntityToDTO();
        }
    }

    private List<Pool_address_DTO> mapperEntityToDTO()
        {
            List<Pool_address_DTO> listDTO = new ArrayList<>();
            List<Pool_address_Domain> listDom = pool_address_repository.findAll();
            for(int i = 0; i<listDom.size(); i++) {
            Pool_address_Domain obj_dom = listDom.get(i);
            listDTO.add(new Pool_address_DTO(obj_dom));
            }
        return listDTO;
    }
}
