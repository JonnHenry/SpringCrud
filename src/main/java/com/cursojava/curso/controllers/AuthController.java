package com.cursojava.curso.controllers;

import com.cursojava.curso.dao.UserDao;
import com.cursojava.curso.models.User;
import com.cursojava.curso.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "api/login",method = RequestMethod.POST)
    public String loginUser(@RequestBody User user){
        User userLogged = userDao.verifyUser(user);

        if (userLogged!=null){
            return jwtUtil.create(String.valueOf(userLogged.getId()),userLogged.getEmail());
        }else{
            return "FAIL";
        }
    }

}
