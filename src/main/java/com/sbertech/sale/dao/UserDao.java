package com.sbertech.sale.dao;

import com.sbertech.sale.data.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserDao implements UserDaoInterface{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user){
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public User getUserById(long userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    @Override
    public Collection getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    @Override
    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
