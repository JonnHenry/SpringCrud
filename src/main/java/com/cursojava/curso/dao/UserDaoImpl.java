package com.cursojava.curso.dao;

import com.cursojava.curso.models.User;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
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

    @Override
    public boolean deleteUser(Long id) {
        try {
            User user = entityManager.find(User.class,id);
            entityManager.remove(user);
            return true;
        }catch (NullPointerException e){
            return false;
        }
    }

    @Override
    public boolean createUser(User user) {
        if (entityManager.merge(user)!=null){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public User getUser(Long id) {
        User user = entityManager.find(User.class,id);
        return user;
    }

    @Override
    public User verifyUser(User user) {
        String query = "FROM User WHERE email = :email";
        List<User> users = entityManager.createQuery(query)
                .setParameter("email", user.getEmail())
                .getResultList();
        if (users.isEmpty()){
            return null;
        }
        String password = users.get(0).getPassword();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        if(argon2.verify(password,user.getPassword())){
            return users.get(0);
        }
        return null;
    }


}
