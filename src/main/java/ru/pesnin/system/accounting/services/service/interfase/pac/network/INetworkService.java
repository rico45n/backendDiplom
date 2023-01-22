package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.integration.dto.MapperStringToEntity;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDto;

import java.util.List;

public interface INetworkService {
    List<NetworkDto> findAll();
    NetworkDto read(NetworkDto obj);
    List<NetworkDto> delete(Integer idNetwork, NetworkDto obj);
    List<NetworkDto> update(Integer idNetwork, NetworkDto obj);
    List<NetworkDto> create(NetworkDto obj);
    Integer createNetworkDhcp(MapperStringToEntity obj);
}
