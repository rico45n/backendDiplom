package ru.pesnin.system.accounting.services.service.interfase.pac.user;



import ru.pesnin.system.accounting.services.entity.user.UsersDomain;

import java.util.List;

public interface IUserService {
    List<UsersDomain> findAll();
    UsersDomain read(UsersDomain obj);
    List<UsersDomain> delete(Integer obj);
    List<UsersDomain> update(UsersDomain obj, Integer user_id);
    List<UsersDomain> create(UsersDomain obj);
    UsersDomain loginUserSearch(String login, String password);
}
