package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDao;
import com.cursojava.curso.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String registerUser(@RequestBody User user){
        if (userDao.verifyUser(user)){
            return "OK";
        }else{
            return "FAIL";
        }
    }

}
