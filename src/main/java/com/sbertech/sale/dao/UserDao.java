package com.sbertech.sale.dao;

import com.sbertech.sale.data.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addUser(User user) {
        sessionFactory.getCurrentSession().persist(user);
    }

    public User getUserById(long userId) {
        return (User) sessionFactory.getCurrentSession().get(User.class, userId);
    }

    public List getUserByLogin(String login) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class)
                .add(Restrictions.like("userName", login));
        return criteria.list();
    }

    public List getAllUsers() {
        return sessionFactory.getCurrentSession().createCriteria(User.class).list();
    }

    public void deleteUser(User user) {
        sessionFactory.getCurrentSession().delete(user);
    }

}
