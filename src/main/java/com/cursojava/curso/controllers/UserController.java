package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDao;
import com.cursojava.curso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST})
public class UserController {
    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        User user = new User();
        user.setId(id);
        user.setName("Jonnathan");
        user.setLastName("Campoberde");
        user.setEmail("testing@testing.com");
        user.setPhone("593984404457");
        user.setPassword("testing");
        return user;
    }

    //Get all users
    @RequestMapping(value = "users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }


    //Update a user
    @RequestMapping(value = "user/update", method = RequestMethod.PUT)
    public User updateUser(){
        User user = new User();
        user.setName("Jonnathan");
        user.setLastName("Campoberde");
        user.setEmail("testing@testing.com");
        user.setPhone("593984404457");
        user.setPassword("testing");
        return user;
    }


    //Delete a user
    @RequestMapping(value = "user/delete", method = RequestMethod.DELETE)
    public User deleteUser(){
        User user = new User();
        user.setName("Jonnathan");
        user.setLastName("Campoberde");
        user.setEmail("testing@testing.com");
        user.setPhone("593984404457");
        user.setPassword("testing");
        return user;
    }

    //Search user
    @RequestMapping(value = "user/search", method = RequestMethod.GET)
    public User searchUser(){
        User user = new User();
        user.setName("Jonnathan");
        user.setLastName("Campoberde");
        user.setEmail("testing@testing.com");
        user.setPhone("593984404457");
        user.setPassword("testing");
        return user;
    }

}
