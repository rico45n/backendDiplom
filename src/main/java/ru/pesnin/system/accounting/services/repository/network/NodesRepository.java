package ru.pesnin.system.accounting.services.repository.network;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pesnin.system.accounting.services.entity.network.NodesEntity;


public interface NodesRepository extends JpaRepository<NodesEntity, Integer> {

    @Query(value = "delete from network.nodes where id_nodes = ?1",
    nativeQuery = true)
    void deleteNodes(Integer id);
}
