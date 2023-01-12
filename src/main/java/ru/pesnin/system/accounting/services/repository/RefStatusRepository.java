package ru.pesnin.system.accounting.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.RefStatusDomain;

public interface RefStatusRepository extends JpaRepository<RefStatusDomain, Integer> {
}
