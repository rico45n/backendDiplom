package ru.pesnin.system.accounting.services.service.implimentation.pac.room;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.integration.dto.room.RoomDto;
import ru.pesnin.system.accounting.services.entity.network.NodesEntity;
import ru.pesnin.system.accounting.services.entity.room.RoomEntity;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.repository.devices.DevicesRepository;
import ru.pesnin.system.accounting.services.repository.network.NodesRepository;
import ru.pesnin.system.accounting.services.repository.room.RoomRepository;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.room.IRoomService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomService implements IRoomService {

    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private NodesRepository nodesRepository;
    @Autowired
    private DevicesRepository devicesRepository;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<RoomDto> findAll() {
        return mapperEntityToDto();
    }

    @Override
    public RoomDto read(Integer id) {
        return mapperEntityToDto(id);
    }

    @Override
    public List<RoomDto> delete(Integer idRoom) {
            try {
                 devicesRepository.findByIdRoom(idRoom).map(
                         element->{
                             element.setIdRoom(roomRepository.findById(0).get());
                             return devicesRepository.save(element);
                         }
                 );
                 roomRepository.delete(idRoom);


                return mapperEntityToDto();
            }catch (Exception e){
                System.out.println(e.getMessage());
                return mapperEntityToDto();
            }
    }

    @Override
    public List<RoomDto> update(Integer idRoom, RoomDto newRoom) {

        Optional<UsersEntity> usersDomain = userRepository.findById(newRoom.getIdUserOtv());
        Optional<NodesEntity> nodesDomain = nodesRepository.findById(newRoom.getIdNodes());

        roomRepository.findById(idRoom).map(element->{
            element.setIdNodes(nodesDomain.get());
            element.setNameRoom(newRoom.getNameRoom());
            element.setTypeRoom(newRoom.getTypeRoom());
            element.setUserOtv(usersDomain.get());
            return roomRepository.save(element);
        });

        return mapperEntityToDto();
    }

    @Override
    public List<RoomDto> create(RoomDto obj) {
        Optional<UsersEntity> usersEntity = userRepository.findById(obj.getIdUserOtv());
        Optional<NodesEntity> nodesEntity = nodesRepository.findById(obj.getIdNodes());

        roomRepository.save(new RoomEntity(obj.getNameRoom(), usersEntity.get(), obj.getTypeRoom(), nodesEntity.get()));
        return mapperEntityToDto();
    }

    private List<RoomDto> mapperEntityToDto()
    {
        List<RoomDto> listDto = new ArrayList<>();
        List<RoomEntity> listEntity = roomRepository.findAll();
        for(int i = 0; i < listEntity.size(); i++) {
            RoomEntity obj_dom = listEntity.get(i);
            listDto.add(new RoomDto(obj_dom));
        }
        return listDto;
    }

    private RoomDto mapperEntityToDto(Integer id)
    {
        Optional<RoomEntity> listEntity = roomRepository.findById(id);
        return new RoomDto(listEntity.get());
    }


}
