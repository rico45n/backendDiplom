package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.pesnin.system.accounting.services.entity.network.CrossesDomain;


public interface CrossesRepository extends JpaRepository<CrossesDomain,Integer> {
}
