package com.sbertech.sale.dao;

import com.sbertech.sale.data.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class UserDao implements UserDaoInterface{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user){
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        session.persist(user);
        session.flush();
        tx.commit();
        session.close();
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
