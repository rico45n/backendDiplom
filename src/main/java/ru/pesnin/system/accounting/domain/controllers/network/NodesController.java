package ru.pesnin.system.accounting.domain.controllers.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.network.NodesDto;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.INodesService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Nodes/")
public class NodesController  {
    @Autowired
    private INodesService nodesService;

    @RequestMapping(value = "/NodesAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDto> findAll() {
        return nodesService.findAll();
    }

    @RequestMapping(value = "/{id_nodes}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public NodesDto read(@PathVariable("id_nodes") int obj) {
        return nodesService.read(obj);
    }

    @RequestMapping(value = "/DeleteNodes/{id_nodes}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDto> delete(@PathVariable("id_nodes") Integer id_nodes) {
        return nodesService.delete(id_nodes);
    }

    @RequestMapping(value = "/UpdateNodes/{id_nodes}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDto> update(@PathVariable("id_nodes") Integer id_nodes, @RequestBody NodesDto new_obj) {
        return nodesService.update(id_nodes, new_obj);
    }
    @RequestMapping(value = "/CreateNodes", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<NodesDto> create(@RequestBody NodesDto obj){
        return nodesService.create(obj);
    }

}

