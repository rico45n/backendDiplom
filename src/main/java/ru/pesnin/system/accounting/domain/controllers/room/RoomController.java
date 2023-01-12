package ru.pesnin.system.accounting.domain.controllers.room;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.integration.dto.room.RoomDTO;
import ru.pesnin.system.accounting.services.service.interfase.pac.room.IRoomService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/Room/")
public class RoomController  {
    @Autowired
    private IRoomService roomService;

    @RequestMapping(value = "/RoomlAll", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RoomDTO> findAll() {
        return roomService.findAll();
    }

    @RequestMapping(value = "/SearchRoom/{id_room}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public RoomDTO read(@PathVariable("id_room") RoomDTO obj) {
        return roomService.read(obj);
    }

    @RequestMapping(value = "/DeleteRoom/{id_room}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RoomDTO>  delete(@PathVariable("id_room") Integer obj) {
        return roomService.delete(obj);
    }

    @RequestMapping(value = "/UpdateRoom/{id_room}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RoomDTO> update(@PathVariable("id_room") Integer id_room, @RequestBody RoomDTO new_obj) {
        return roomService.update(id_room, new_obj);
    }
    @RequestMapping(value = "/CreateRoom", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<RoomDTO> create(@RequestBody RoomDTO obj){
        return roomService.create(obj);
    }

}
