package ru.pesnin.system.accounting.domain.controllers.journal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.journal.ConfigurationDTO;
import ru.pesnin.system.accounting.services.service.interfase.pac.journal.IConfigurationService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Configuration/")
public class ConfigurationController {
    @Autowired
    private IConfigurationService configurationService;

    @RequestMapping(value = "/ConfigurationAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDTO> findAll() {
        return configurationService.findAll();
    }

    @RequestMapping(value = "/SearchConfiguration/{id_config}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ConfigurationDTO read(@PathVariable("id_config") ConfigurationDTO obj) {
        return configurationService.read(obj);
    }

    @RequestMapping(value = "/DeleteConfiguration/{id_config}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDTO> delete(@PathVariable("id_config") Integer id_config, @RequestBody ConfigurationDTO config) {
        return configurationService.delete(id_config, config.getId_user_old());
    }

    @RequestMapping(value = "/UpdateConfiguration/{id_config}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDTO> update(@PathVariable("id_config") Integer id_config, @RequestBody ConfigurationDTO new_obj) {
        return configurationService.update(id_config, new_obj);
    }
    @RequestMapping(value = "/CreateConfiguration", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<ConfigurationDTO> create(@RequestBody ConfigurationDTO obj){
        return configurationService.create(obj);
    }
}
