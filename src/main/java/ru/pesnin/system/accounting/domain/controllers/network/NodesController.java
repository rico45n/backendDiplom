package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.network.NodesDTO;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.INodesService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Nodes/")
public class NodesController  {
    @Autowired
    private INodesService nodesService;

    @RequestMapping(value = "/NodesAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDTO> findAll() {
        return nodesService.findAll();
    }

    @RequestMapping(value = "/SearchNodes/{id_nodes}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NodesDTO read(@PathVariable("id_nodes") NodesDTO obj) {
        return nodesService.read(obj);
    }

    @RequestMapping(value = "/DeleteNodes/{id_nodes}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDTO> delete(@PathVariable("id_nodes") Integer id_nodes) {
        return nodesService.delete(id_nodes);
    }

    @RequestMapping(value = "/UpdateNodes/{id_nodes}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDTO> update(@PathVariable("id_nodes") Integer id_nodes, @RequestBody NodesDTO new_obj) {
        return nodesService.update(id_nodes, new_obj);
    }
    @RequestMapping(value = "/CreateNodes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDTO> create(@RequestBody NodesDTO obj){
        return nodesService.create(obj);
    }

}

