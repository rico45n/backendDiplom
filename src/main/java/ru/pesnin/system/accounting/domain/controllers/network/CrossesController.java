package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.network.CrossesEntity;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.ICrossesService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Crosses/")
public class CrossesController  {
    @Autowired
    private ICrossesService crossesService;

    @RequestMapping(value = "", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossesEntity> findAll() {
        return crossesService.findAll();
    }

    @RequestMapping(value = "{idCrosses}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Optional<CrossesEntity> read(@PathVariable("idCrosses") CrossesEntity obj) {

        return crossesService.read(obj);
    }

    @RequestMapping(value = "/DeleteCrosses/{id_crosses}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossesEntity> delete(@PathVariable("id_crosses") Integer obj) {
        return crossesService.delete(obj);
    }

    @RequestMapping(value = "/UpdateCrosses/{id_crosses}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossesEntity> update(@PathVariable("id_crosses") Integer id_crosses_first, @RequestBody CrossesEntity new_obj) {
        return crossesService.update(id_crosses_first, new_obj);
    }
    @RequestMapping(value = "/CreateCrosses", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<CrossesEntity> create(@RequestBody CrossesEntity obj){
        return crossesService.create(obj);
    }
}
