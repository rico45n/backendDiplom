package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.network.DhcpPoolEntity;

public interface DhcpPoolRepository extends JpaRepository<DhcpPoolEntity, Integer> {
}
