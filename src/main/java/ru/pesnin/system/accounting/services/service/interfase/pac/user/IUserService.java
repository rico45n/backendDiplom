package ru.pesnin.system.accounting.services.service.interfase.pac.user;



import ru.pesnin.system.accounting.services.entity.user.UsersEntity;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<UsersEntity> findAll();
    Optional<UsersEntity> read(UsersEntity obj);
    List<UsersEntity> delete(Integer obj);
    List<UsersEntity> update(UsersEntity obj, Integer userId);
    List<UsersEntity> create(UsersEntity obj);
    UsersEntity loginUserSearch(String login, String password);
}
