package com.sbertech.sale.service;

import com.sbertech.sale.dao.UserDao;
import com.sbertech.sale.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    @Transactional
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Transactional
    public User getUserById(long userId) {
        return userDao.getUserById(userId);
    }

    @Transactional
    public List getAllUsers() {
        return userDao.getAllUsers();
    }

    @Transactional
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

}
