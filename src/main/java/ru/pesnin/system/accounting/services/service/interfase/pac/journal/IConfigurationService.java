package ru.pesnin.system.accounting.services.service.interfase.pac.journal;



import ru.pesnin.system.accounting.integration.dto.journal.ConfigurationDTO;

import java.util.List;

public interface IConfigurationService {
    List<ConfigurationDTO> findAll();
    ConfigurationDTO read(ConfigurationDTO obj);
    List<ConfigurationDTO> delete(Integer id_config, Integer user_id);
    List<ConfigurationDTO> update(Integer id_config, ConfigurationDTO new_obj);
    List<ConfigurationDTO> create(ConfigurationDTO obj);
}
