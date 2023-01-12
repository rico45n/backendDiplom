package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.network.NodesDTO;
import ru.pesnin.system.accounting.services.entity.network.NodesDomain;
import ru.pesnin.system.accounting.services.repository.network.NodesRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.INodesService;

import java.util.ArrayList;
import java.util.List;

@Service
public class NodesService implements INodesService {
    @Autowired
    private NodesRepository nodesRepository;
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<NodesDTO> findAll() {
        return mapperEntityToDTO();
    }

    @Override
    public NodesDTO read(NodesDTO obj) {
        return null;
    }

    @Override
    public List<NodesDTO> delete(Integer id_nodes) {
        nodesRepository.deleteNodes(id_nodes);
        return mapperEntityToDTO();
    }

    @Override
    public List<NodesDTO> update(Integer id_nodes, NodesDTO new_obj) {
        try{
            nodesRepository.findById(id_nodes).map(nodesDomain -> {
                    nodesDomain.setName_nodes(new_obj.getName_nodes());
                    nodesDomain.setUser_otv(userRepository.findById(new_obj.getId_user_otv()).get());
                    return nodesRepository.save(nodesDomain);
            });
            return mapperEntityToDTO();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return mapperEntityToDTO();
        }
    }

    @Override
    public List<NodesDTO> create(NodesDTO obj) {
       NodesDomain nodesDomain = new NodesDomain();
       nodesDomain.setName_nodes(obj.getName_nodes());
       nodesDomain.setUser_otv(userRepository.findById(obj.getId_user_otv()).get());
       nodesRepository.save(nodesDomain);
       return mapperEntityToDTO();
    }

    private List<NodesDTO> mapperEntityToDTO()
    {
        List<NodesDTO> listDTO = new ArrayList<>();
        List<NodesDomain> listDom = nodesRepository.findAll();
        for(int i = 0; i<listDom.size(); i++) {
            NodesDomain obj_dom = listDom.get(i);
            listDTO.add(new NodesDTO(obj_dom));
        }
        return listDTO;
    }
}
