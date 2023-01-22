package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.pesnin.system.accounting.services.entity.network.PoolAddressEntity;


@Repository
public interface PoolAddressRepository extends JpaRepository<PoolAddressEntity,Integer> {

}
