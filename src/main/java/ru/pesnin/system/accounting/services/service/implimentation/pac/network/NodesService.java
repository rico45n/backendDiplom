package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.network.NodesDto;
import ru.pesnin.system.accounting.services.entity.network.NodesEntity;
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
    public List<NodesDto> findAll() {
        return mapperEntityToDto();
    }

    @Override
    public NodesDto read(int obj) {
        var e = nodesRepository.findById(obj).get();
        return NodesDto.builder()
                .idNodes(e.getIdNodes())
                .nameNodes(e.getNameNodes())
                .idUserOtv(e.getUserOtv().getUserId())
                .userOtv(e.getUserOtv().getFioUser())
                .build();
    }

    @Override
    public List<NodesDto> delete(Integer idNodes) {
        try {
            nodesRepository.deleteNodes(idNodes);
            return findAll();
        }catch (Exception e){
            return findAll();
        }

    }

    @Override
    public List<NodesDto> update(Integer idNodes, NodesDto newNodes) {
        try{
            nodesRepository.findById(idNodes).map(nodesEntity -> {
                    nodesEntity.setNameNodes(newNodes.getNameNodes());
                    nodesEntity.setUserOtv(userRepository.findById(newNodes.getIdUserOtv()).get());
                    return nodesRepository.save(nodesEntity);
            });
            return mapperEntityToDto();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return mapperEntityToDto();
        }
    }

    @Override
    public List<NodesDto> create(NodesDto obj) {
       NodesEntity nodesEntity = new NodesEntity();
       nodesEntity.setNameNodes(obj.getNameNodes());
       nodesEntity.setUserOtv(userRepository.findById(obj.getIdUserOtv()).get());
       nodesRepository.save(nodesEntity);
       return mapperEntityToDto();
    }

    private List<NodesDto> mapperEntityToDto()
    {
        List<NodesDto> listDto = new ArrayList<>();
        List<NodesEntity> listEntity = nodesRepository.findAll();
        for (NodesEntity objEnt : listEntity) {
            listDto.add(new NodesDto(objEnt));
        }
        return listDto;
    }
}
