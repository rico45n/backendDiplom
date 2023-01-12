package ru.pesnin.system.accounting.services.repository.devices;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.devices.TypeDeviceDomain;


public interface TypeDeviceRepository extends JpaRepository<TypeDeviceDomain, Integer> {
}
