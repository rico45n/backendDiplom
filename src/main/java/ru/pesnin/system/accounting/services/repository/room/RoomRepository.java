package ru.pesnin.system.accounting.services.repository.room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pesnin.system.accounting.services.entity.room.RoomEntity;

public interface RoomRepository extends JpaRepository<RoomEntity,Integer> {

    @Query(value = "delete from network.room where cast (id_room as varchar) = cast(?1 as varchar)",
        nativeQuery = true)
    boolean delete(Integer id_room);
}
