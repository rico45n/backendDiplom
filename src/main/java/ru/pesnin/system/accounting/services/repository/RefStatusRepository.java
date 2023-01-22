package ru.pesnin.system.accounting.services.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.RefStatusEntity;

public interface RefStatusRepository extends JpaRepository<RefStatusEntity, Integer> {
}
