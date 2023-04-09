package ru.pesnin.system.accounting.services.repository.devices;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceEntity;


public interface TypeDeviceRepository extends JpaRepository<TypeDeviceEntity, Integer> {
    @Query(value = "DELETE FROM network.type_device\n" +
            "WHERE id_type_dev=?1\n", nativeQuery = true)
    boolean delete(Integer obj);
}
