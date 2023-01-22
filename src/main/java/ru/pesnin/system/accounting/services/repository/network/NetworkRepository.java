package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pesnin.system.accounting.services.entity.network.NetworkEntity;


import java.util.List;

public interface NetworkRepository extends JpaRepository<NetworkEntity, Integer> {
    @Query(value = "select \n" +
            "\tnj.ip_address\n" +
            "from network.network_journal nj \n" +
            "\tjoin network.network n on n.id_network = nj.id_network \n" +
            "where nj.is_status = 1 and n.ip_address_network = ?1 ", nativeQuery = true)
    List<String> getInitIp_inNetwork(String network);

    @Query(
            value = "select * from network.network n where n.id_pool_address = ?1",
            nativeQuery = true
    )
    List<NetworkEntity> findByAndIdPoolAddress(Integer id_pool);
}
