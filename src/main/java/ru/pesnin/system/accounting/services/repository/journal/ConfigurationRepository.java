package ru.pesnin.system.accounting.services.repository.journal;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.journal.ConfigurationDomain;


public interface ConfigurationRepository extends JpaRepository<ConfigurationDomain,Integer> {
}
