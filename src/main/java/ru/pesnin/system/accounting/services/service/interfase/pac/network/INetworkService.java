package ru.pesnin.system.accounting.services.service.interfase.pac.network;



import ru.pesnin.system.accounting.integration.dto.MapperStringToEntity;
import ru.pesnin.system.accounting.integration.dto.network.NetworkDTO;

import java.util.List;

public interface INetworkService {
    List<NetworkDTO> findAll();
    NetworkDTO read(NetworkDTO obj);
    List<NetworkDTO> delete(Integer id_network, NetworkDTO obj);
    List<NetworkDTO> update(Integer id_network, NetworkDTO obj);
    List<NetworkDTO> create(NetworkDTO obj);
    Integer createNetworkDhcp(MapperStringToEntity obj);
}
