package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.network.VlanDomain;


public interface VlanRepository extends JpaRepository<VlanDomain,Integer> {
}
