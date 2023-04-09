package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.integration.dto.network.NodesDto;

import java.util.List;

public interface INodesService {
    List<NodesDto> findAll();
    NodesDto read(int obj);
    List<NodesDto> delete(Integer idNodes);
    List<NodesDto> update(Integer idNodes, NodesDto newObj);
    List<NodesDto> create(NodesDto obj);
}
