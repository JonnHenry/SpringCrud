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

    @RequestMapping(value = "api/user/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable Long id){
        return userDao.getUser(id);
    }

    //Get all users
    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    //Create a user
    @RequestMapping(value = "api/users",method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userDao.createUser(user);
    }


    //Update a user
    @RequestMapping(value = "api/user/update", method = RequestMethod.PUT)
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
    @RequestMapping(value = "/api/users/delete/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable Long id){
        boolean result = userDao.deleteUser(id);

    }


}
