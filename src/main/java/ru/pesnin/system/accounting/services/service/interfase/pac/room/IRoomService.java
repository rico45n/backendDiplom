package ru.pesnin.system.accounting.services.service.interfase.pac.room;



import ru.pesnin.system.accounting.integration.dto.room.RoomDto;
import ru.pesnin.system.accounting.services.entity.room.RoomEntity;

import java.util.List;
import java.util.Optional;

public interface IRoomService {
    List<RoomDto> findAll();
    RoomDto read(Integer idRoom);
    List<RoomDto> delete(Integer idRoom);
    List<RoomDto> update(Integer idRoom, RoomDto newObj);
    List<RoomDto> create(RoomDto obj);
}
