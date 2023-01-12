package ru.pesnin.system.accounting.services.service.implimentation.pac.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.journal.ConfigurationDTO;
import ru.pesnin.system.accounting.services.entity.journal.ConfigurationDomain;
import ru.pesnin.system.accounting.services.repository.RefStatusRepository;
import ru.pesnin.system.accounting.services.repository.devices.DevicesRepository;
import ru.pesnin.system.accounting.services.repository.journal.ConfigurationRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.journal.IConfigurationService;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ConfigurationService implements IConfigurationService {
   @Autowired
   private ConfigurationRepository configurationRepository;
   @Autowired
   private UserRepository userRepository;
   @Autowired
   private RefStatusRepository refStatusRepository;
   @Autowired
   private DevicesRepository devicesRepository;


    @Override
    public List<ConfigurationDTO> findAll() {
        return mapperEntityToDTO();
    }

    @Override
    public ConfigurationDTO read(ConfigurationDTO obj) {
        return null;
    }

    @Override
    public List<ConfigurationDTO> delete(Integer id_config, Integer user_id) {
        configurationRepository.findById(id_config).map(deleteConfig->{
            deleteConfig.setId_user_old(userRepository.findById(user_id).get());
            deleteConfig.setDate_old(new Date());
            deleteConfig.setIs_status(refStatusRepository.findById(2).get());
            return configurationRepository.save(deleteConfig);
        });
        return mapperEntityToDTO();
    }

    @Override
    public List<ConfigurationDTO> update(Integer id_config, ConfigurationDTO new_obj) {

        configurationRepository.findById(id_config).map(configurationDomain -> {
                configurationDomain
                        .setConfiguration(
                                devicesRepository.findById(new_obj.getId_device()).get(),
                                new_obj.getConfig_first(),
                                new_obj.getConfig_last(),
                                new_obj.getDeference(),
                                userRepository.findById(new_obj.getId_user_reg()).get(),
                                userRepository.findById(new_obj.getId_user_old()).get(),
                                new Date(),
                                new Date(),
                                refStatusRepository.findById(2).get()
                        );
                return configurationRepository.save(configurationDomain);
           });

           ConfigurationDomain configDom = new ConfigurationDomain();
           configDom.setConfiguration(devicesRepository.findById(new_obj.getId_device()).get(),
                    new_obj.getConfig_last(),
                   null,
                    null,
                    userRepository.findById(new_obj.getId_user_reg()).get(),
                    userRepository.findById(0).get(),
                    new Date(),
                    null,
                    refStatusRepository.findById(1).get());
                configurationRepository.save(configDom);
            return mapperEntityToDTO();
    }

    @Override
    public List<ConfigurationDTO> create(ConfigurationDTO obj) {
        ConfigurationDomain createConfigDom = new ConfigurationDomain();
        createConfigDom.setConfiguration(
                devicesRepository.findById(obj.getId_device()).get(),
                obj.getConfig_first(),
                null,
                null,
                userRepository.findById(obj.getId_user_reg()).get(),
                userRepository.findById(0).get(),
                new Date(),
                null,
                refStatusRepository.findById(1).get());
        configurationRepository.save(createConfigDom);
        return mapperEntityToDTO();
    }

    private List<ConfigurationDTO> mapperEntityToDTO()
    {
        List<ConfigurationDTO> listDTO = new ArrayList<>();
        List<ConfigurationDomain> listDom = configurationRepository.findAll();
        for(int i = 0; i<listDom.size(); i++) {
            ConfigurationDomain obj_dom = listDom.get(i);
            listDTO.add(new ConfigurationDTO(obj_dom));
        }
        return listDTO;
    }
}
