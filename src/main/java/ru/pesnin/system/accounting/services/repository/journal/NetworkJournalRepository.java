package ru.pesnin.system.accounting.services.repository.journal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pesnin.system.accounting.services.entity.journal.NetworkJournalDomain;

import java.util.List;

public interface NetworkJournalRepository extends JpaRepository<NetworkJournalDomain, Integer> {
    @Query(
            value = "select *  from network.network_journal n where n.id_network = ?1",
            nativeQuery = true
    )
    List<NetworkJournalDomain> CascadeDelNet(Integer id_network);

    @Query(
        value = "select nj.ip_address from network.network_journal nj where nj.is_status = 1",
            nativeQuery = true
    )
    List<String> findBy_ipAddress();

    @Query(
            value = "select * from network.network_journal nj where nj.id_devices = ?1",
            nativeQuery = true
    )
    List<NetworkJournalDomain> findBy_AndId_devices(Integer id_devices);
}
