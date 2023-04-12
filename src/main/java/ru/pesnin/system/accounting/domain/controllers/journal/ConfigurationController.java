package ru.pesnin.system.accounting.domain.controllers.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.journal.ConfigurationDto;
import ru.pesnin.system.accounting.services.service.interfase.pac.journal.IConfigurationService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Configuration/")
public class ConfigurationController {
    @Autowired
    private IConfigurationService configurationService;

    @RequestMapping(value = "/ConfigurationAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDto> findAll() {
        return configurationService.findAll();
    }

    @RequestMapping(value = "/SearchConfiguration/{id_config}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ConfigurationDto read(@PathVariable("id_config") ConfigurationDto obj) {
        return configurationService.read(obj);
    }

    @RequestMapping(value = "/DeleteConfiguration/{id_config}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDto> delete(@PathVariable("id_config") Integer id_config) {
        return configurationService.delete(id_config);
    }

    @RequestMapping(value = "/UpdateConfiguration/{id_config}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDto> update(@PathVariable("id_config") Integer id_config, @RequestBody ConfigurationDto new_obj) {
        return configurationService.update(id_config, new_obj);
    }
    @RequestMapping(value = "/CreateConfiguration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDto> create(@RequestBody ConfigurationDto obj){
        return configurationService.create(obj);
    }
}
