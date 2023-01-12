package ru.pesnin.system.accounting.domain.controllers.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.pesnin.system.accounting.services.entity.user.UsersDomain;
import ru.pesnin.system.accounting.services.service.interfase.pac.user.IUserService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value = "/User/")
public class UserController  {
    @Autowired
    private IUserService userservice;

    @RequestMapping(value = "/AllUser", method = RequestMethod.GET)
    public List<UsersDomain> findAll() {
        return userservice.findAll();
    }

    @RequestMapping(value = "/SearchUser/{user_id}", method = RequestMethod.GET)
    public UsersDomain read(@PathVariable("user_id") UsersDomain obj) {
        return userservice.read(obj);
    }

    @RequestMapping(value = "/DeleteUser/{user_id}", method = RequestMethod.DELETE)
    public List<UsersDomain> delete(@PathVariable("user_id") Integer obj) {
        try {
            return userservice.delete(obj);
        }
        catch (Exception e){
            return  userservice.findAll();
        }
    }

    @RequestMapping(value = "/UpdateUser/{user_id}", method = RequestMethod.PUT)
    public List<UsersDomain> update(@RequestBody UsersDomain obj,
                                    @PathVariable("user_id") Integer user_id) {
        return userservice.update(obj, user_id);
    }
    @RequestMapping(value = "/AddUser", method = RequestMethod.POST)
    public List<UsersDomain> create (@RequestBody UsersDomain obj){
        try {
            return userservice.create(obj);
        }
        catch (Exception e){
            return userservice.findAll();
        }
    }

    @RequestMapping(value = "/loginUser", method = RequestMethod.GET)
    public UsersDomain loginUserSearch (@RequestParam(value = "user_login") String login, @RequestParam (value = "user_password") String password){
        return userservice.loginUserSearch(login, password);
    }
}
