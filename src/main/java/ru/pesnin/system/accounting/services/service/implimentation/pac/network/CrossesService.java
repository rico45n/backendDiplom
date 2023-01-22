package ru.pesnin.system.accounting.services.service.implimentation.pac.network;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.network.CrossesEntity;
import ru.pesnin.system.accounting.services.repository.network.CrossesRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.network.ICrossesService;

import java.util.List;

@Service
public class CrossesService implements ICrossesService {
    @Autowired
    private CrossesRepository crossesRepository;

    @Override
    public List<CrossesEntity> findAll() {
        try {
            return crossesRepository.findAll();
        }catch (RuntimeException e){
            System.out.println(e.hashCode());
            return null;
        }

    }

    @Override
    public CrossesEntity read(CrossesEntity crosses) {
       return null;
    }

    @Override
    public List<CrossesEntity>  delete(Integer crosses) {
        try {
            crossesRepository.delete(crossesRepository.findById(crosses).get());
            return crossesRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return crossesRepository.findAll();
        }
    }

    @Override
    public List<CrossesEntity> update(Integer idCrosses, CrossesEntity newCrossEntity) {
        try {
            crossesRepository.findById(idCrosses).map(crossesDomain -> {
                crossesDomain.setIdCrossesEnd(newCrossEntity.getIdCrossesEnd());
                crossesDomain.setPort(newCrossEntity.getPort());
                crossesDomain.setSlot(newCrossEntity.getSlot());
                crossesDomain.setShkaf(newCrossEntity.getShkaf());
                return crossesRepository.save(crossesDomain);
            });
            return crossesRepository.findAll();
        }catch (RuntimeException e){
            System.out.println(e.hashCode());
            return null;
        }

    }

    @Override
    public List<CrossesEntity> create(CrossesEntity crossesEntity) {

        try {
            crossesRepository.save(crossesEntity);
            return crossesRepository.findAll();
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
