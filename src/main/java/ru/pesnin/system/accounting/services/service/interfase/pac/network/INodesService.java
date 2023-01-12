package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.integration.dto.network.NodesDTO;

import java.util.List;

public interface INodesService {
    List<NodesDTO> findAll();
    NodesDTO read(NodesDTO obj);
    List<NodesDTO> delete(Integer id_nodes);
    List<NodesDTO> update(Integer id_nodes, NodesDTO new_obj);
    List<NodesDTO> create(NodesDTO obj);
}
