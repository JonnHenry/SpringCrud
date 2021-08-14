package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository //Reference to access to DB
@Transactional //Form to execute SQL queries
public class UserDaoImpl implements UserDao{
    @PersistenceContext
    private EntityManager entityManager; //Conection to Database

    @Override
    public List<User> getUsers() {
        String query = "FROM User";
        return entityManager.createQuery(query).getResultList();
    }
}
