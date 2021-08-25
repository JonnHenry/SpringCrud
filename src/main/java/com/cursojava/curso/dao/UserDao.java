package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;

import java.util.List;

public interface UserDao {

    List<User> getUsers();

    boolean deleteUser(Long id);

    boolean createUser(User user);

    User getUser(Long id);

    User verifyUser(User user);
}
