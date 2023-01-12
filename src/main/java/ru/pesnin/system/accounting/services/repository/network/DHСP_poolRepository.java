package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.network.Dhcp_poolDomain;

public interface DHСP_poolRepository extends JpaRepository<Dhcp_poolDomain, Integer> {
}
