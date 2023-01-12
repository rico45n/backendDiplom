package ru.pesnin.system.accounting.services.service.interfase.pac.network;


import ru.pesnin.system.accounting.services.entity.network.CrossesDomain;

import java.util.List;

public interface ICrossesService {
    List<CrossesDomain> findAll();
    CrossesDomain read(CrossesDomain obj);
    List<CrossesDomain> delete(Integer id);
    List<CrossesDomain> update(Integer id, CrossesDomain new_obj);
    List<CrossesDomain> create(CrossesDomain obj);
}
