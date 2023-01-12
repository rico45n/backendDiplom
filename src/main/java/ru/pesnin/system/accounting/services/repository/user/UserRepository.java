package ru.pesnin.system.accounting.services.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;

public interface UserRepository extends JpaRepository<UsersDomain, Integer> {
    @Query(value = "select * from auth.users u where cast(u.user_login as varchar)= cast(?1 as varchar) " +
            "           and cast(u.user_password as varchar ) = cast(?2 as varchar)  ",nativeQuery = true)
    UsersDomain findAllByLogin(String user_login,String user_password);


    @Query(value = "DELETE FROM auth.users\n" +
            "WHERE user_id=?1\n", nativeQuery = true)
    boolean delete(Integer obj);
}
