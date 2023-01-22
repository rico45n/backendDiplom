package ru.pesnin.system.accounting.services.service.interfase.pac.journal;



import ru.pesnin.system.accounting.integration.dto.journal.ConfigurationDto;

import java.util.List;

public interface IConfigurationService {
    List<ConfigurationDto> findAll();
    ConfigurationDto read(ConfigurationDto obj);
    List<ConfigurationDto> delete(Integer idConfig, Integer userId);
    List<ConfigurationDto> update(Integer idConfig, ConfigurationDto newObj);
    List<ConfigurationDto> create(ConfigurationDto obj);
}
