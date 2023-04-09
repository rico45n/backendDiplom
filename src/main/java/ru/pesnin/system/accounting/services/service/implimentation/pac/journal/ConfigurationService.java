package ru.pesnin.system.accounting.services.service.implimentation.pac.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.journal.ConfigurationDto;
import ru.pesnin.system.accounting.services.entity.journal.ConfigurationEntity;
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
   private DevicesRepository devicesRepository;


    @Override
    public List<ConfigurationDto> findAll() {
        return mapperEntityToDto();
    }

    @Override
    public ConfigurationDto read(ConfigurationDto obj) {
        return null;
    }

    @Override
    public List<ConfigurationDto> delete(Integer id_config, Integer user_id) {
        configurationRepository.findById(id_config).map(deleteConfig->{
            deleteConfig.setIdUserOld(userRepository.findById(user_id).get());
            return configurationRepository.save(deleteConfig);
        });
        return mapperEntityToDto();
    }

    @Override
    public List<ConfigurationDto> update(Integer id_config, ConfigurationDto newObj) {

        configurationRepository.findById(id_config).map(configurationEntity -> {
                configurationEntity
                        .setConfiguration(
                                devicesRepository.findById(newObj.getIdDevice()).get(),
                                newObj.getConfigFirst(),
                                newObj.getConfigLast(),
                                newObj.getDeference(),
                                userRepository.findById(newObj.getIdUserReg()).get(),
                                userRepository.findById(newObj.getIdUserOld()).get()
                        );
                return configurationRepository.save(configurationEntity);
           });

           ConfigurationEntity configDom = new ConfigurationEntity();
           configDom.setConfiguration(devicesRepository.findById(newObj.getIdDevice()).get(),
                    newObj.getConfigLast(),
                   null,
                    null,
                    userRepository.findById(newObj.getIdUserReg()).get(),
                    userRepository.findById(0).get());
                configurationRepository.save(configDom);
            return mapperEntityToDto();
    }

    @Override
    public List<ConfigurationDto> create(ConfigurationDto obj) {
        ConfigurationEntity configurationEntity = new ConfigurationEntity();
        configurationEntity.setConfiguration(
                devicesRepository.findById(obj.getIdDevice()).get(),
                obj.getConfigFirst(),
                obj.getConfigLast(),
                obj.getDeference(),
                userRepository.findById(obj.getIdUserReg()).get(),
                userRepository.findById(0).get());
        configurationRepository.save(configurationEntity);
        return mapperEntityToDto();
    }

    private List<ConfigurationDto> mapperEntityToDto()
    {
        List<ConfigurationDto> listDto = new ArrayList<>();
        List<ConfigurationEntity> listEntity = configurationRepository.findAll();
        for(int i = 0; i<listEntity.size(); i++) {
            ConfigurationEntity objEntity = listEntity.get(i);
            listDto.add(new ConfigurationDto(objEntity));
        }
        return listDto;
    }
}
