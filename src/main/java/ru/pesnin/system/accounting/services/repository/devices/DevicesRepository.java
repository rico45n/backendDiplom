package ru.pesnin.system.accounting.services.repository.devices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pesnin.system.accounting.services.entity.devices.DevicesEntity;


import java.util.List;
import java.util.Optional;

public interface DevicesRepository extends JpaRepository<DevicesEntity, Integer> {

    @Query(value = "UPDATE network.devices SET is_status = 2 WHERE id_devices=?1\n; " +
            "Update  network.configuration SET is_status = 2 WHERE id_device = ?1\n;" +
            "Update  network.cross_devices SET is_status = 2 WHERE (id_devices_end = ?1 or id_devices_first = ?1)\n;", nativeQuery = true)
    boolean delete(Integer obj);

    @Query(value = "select * from network.devices d where cast(d.id_room as varchar )= cast(?1 as varchar)", nativeQuery = true)
    Optional<DevicesEntity> findByIdRoom(Integer id);

    @Query(
            value = "select * from network.devices d ",
            nativeQuery = true
    )
    List<DevicesEntity> getInfoConnectDevice();
}

