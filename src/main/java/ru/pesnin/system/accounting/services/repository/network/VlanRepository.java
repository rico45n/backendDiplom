package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.network.VlanEntity;


public interface VlanRepository extends JpaRepository<VlanEntity,Integer> {
}
