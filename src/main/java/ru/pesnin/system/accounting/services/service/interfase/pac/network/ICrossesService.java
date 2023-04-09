package ru.pesnin.system.accounting.services.service.interfase.pac.network;


import ru.pesnin.system.accounting.services.entity.network.CrossesEntity;

import java.util.List;
import java.util.Optional;

public interface ICrossesService {
    List<CrossesEntity> findAll();
    Optional<CrossesEntity> read(CrossesEntity obj);
    List<CrossesEntity> delete(Integer id);
    List<CrossesEntity> update(Integer id, CrossesEntity newObj);
    List<CrossesEntity> create(CrossesEntity obj);
}
