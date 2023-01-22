package ru.pesnin.system.accounting.services.service.implimentation.pac.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.repository.user.UserRepository;
import ru.pesnin.system.accounting.services.service.interfase.pac.user.IUserService;


import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UsersEntity> findAll() {
        try {
            return userRepository.findAll();
        } catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    @Override
    public Optional<UsersEntity> read(UsersEntity obj) {
       var t =  userRepository.findById(obj.getUserId());
      return t;
    }

    @Override
    public List<UsersEntity> delete(Integer obj) {
        try {
            userRepository.delete(obj);
            return userRepository.findAll();
        }catch (Exception e){
            System.out.println(e.getMessage());
            return userRepository.findAll();
        }
    }@Override
    public List<UsersEntity> update(UsersEntity obj, Integer userId) {
        try {

            userRepository.findById(userId).map(employee -> {
                employee.setEmail(obj.getEmail());
                employee.setPhone(obj.getPhone());
                employee.setFirstName(obj.getFirstName());
                employee.setLastName(obj.getLastName());
                employee.setMiddleName(obj.getMiddleName());
                employee.setUserLogin(obj.getUserLogin());
                employee.setUserRole(obj.getUserRole());
                return userRepository.save(employee);
            }).orElseGet(() -> {
                        obj.setUserId(userId);
                        return userRepository.save(obj);
                    });
            return userRepository.findAll();
        }
        catch (Exception e){
            return userRepository.findAll();
        }
    }

    @Override
    public List<UsersEntity> create(UsersEntity obj) {
        try {
            if(obj.getFioUser().length() > 0 && obj.getUserLogin().length()>0
                && obj.getUserPassword().length()>3 && obj.getPhone().length()>0 && obj.getEmail().length()>0) {
                userRepository.save(obj);
                return userRepository.findAll();
            }
            else {
                return userRepository.findAll();
            }
        }
        catch (Exception e) {
             System.out.println(e.getMessage());
             return null;
        }
    }
    @Override
    public UsersEntity loginUserSearch(String login, String password) {
        try {
            return userRepository.findAllByLogin(login, password);
        }catch (Exception e){
            return null;
        }

    }
}
