package ru.pesnin.system.accounting.domain.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.user.UsersEntity;
import ru.pesnin.system.accounting.services.service.interfase.pac.user.IUserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/User")
public class UserController  {
    @Autowired
    private IUserService userservice;

    @RequestMapping(value = "/AllUser", method = RequestMethod.GET)
    public List<UsersEntity> findAll() {
        return userservice.findAll();
    }

    @RequestMapping(value = "{userId}" ,method = RequestMethod.GET)
    public Optional<UsersEntity> read(@PathVariable(value = "userId") UsersEntity obj) {
        return userservice.read(obj);
    }

    @RequestMapping(value = "/DeleteUser/{userId}", method = RequestMethod.DELETE)
    public List<UsersEntity> delete(@PathVariable("userId") Integer obj) {
        try {
            return userservice.delete(obj);
        }
        catch (Exception e){
            return  userservice.findAll();
        }
    }

    @RequestMapping(value = "/UpdateUser/{userId}", method = RequestMethod.PUT)
    public List<UsersEntity> update(@RequestBody UsersEntity obj,
                                    @PathVariable("userId") Integer user_id) {
        return userservice.update(obj, user_id);
    }
    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public List<UsersEntity> create (@RequestBody UsersEntity obj){
        try {
            return userservice.create(obj);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            return userservice.findAll();
        }
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public UsersEntity loginUserSearch (@RequestParam(value = "userLogin") String login, @RequestParam (value = "userPassword") String password){
        return userservice.loginUserSearch(login, password);
    }
}
