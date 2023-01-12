package ru.pesnin.system.accounting.services.service.implimentation.pac.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.user.IUserService;


import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userrepository;

    @Override
    public List<UsersDomain> findAll() {
        try {
            return userrepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public UsersDomain read(UsersDomain obj) {
       try {
           return obj;
       }catch (Exception e) {
           System.out.println(e.getMessage());
           return null;
       }
    }

    @Override
    public List<UsersDomain> delete(Integer obj) {
        try {
            userrepository.delete(obj);
            return userrepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return userrepository.findAll();
        }
    }@Override
    public List<UsersDomain> update(UsersDomain obj, Integer user_id) {
        try {

            userrepository.findById(user_id).map(employee -> {
                employee.setEmail(obj.getEmail());
                employee.setPhone(obj.getPhone());
                employee.setFirst_name(obj.getFirst_name());
                employee.setLast_name(obj.getLast_name());
                employee.setMiddle_name(obj.getMiddle_name());
                employee.setUser_login(obj.getUser_login());
                employee.setUser_role(obj.getUser_role());
                return userrepository.save(employee);
            }).orElseGet(() -> {
                        obj.setUser_id(user_id);
                        return userrepository.save(obj);
                    });
            return userrepository.findAll();
        }
        catch (Exception e){
            return userrepository.findAll();
        }
    }

    @Override
    public List<UsersDomain> create(UsersDomain obj) {
        try {
            if(obj.getFioUser().length() > 0 && obj.getUser_login().length()>0
                && obj.getUser_password().length()>3 && obj.getPhone().length()>0 && obj.getEmail().length()>0) {
                userrepository.save(obj);
                return userrepository.findAll();
            }
            else {
                return userrepository.findAll();
            }
        }
        catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
    }
    @Override
    public UsersDomain loginUserSearch(String login,String password) {
        try {
            return userrepository.findAllByLogin(login, password);
        }catch (Exception e){
            return null;
        }

    }
}
