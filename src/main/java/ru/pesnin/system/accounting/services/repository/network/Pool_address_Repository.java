package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pesnin.system.accounting.services.entity.network.Pool_address_Domain;


@Repository
public interface Pool_address_Repository extends JpaRepository<Pool_address_Domain,Integer> {

}
