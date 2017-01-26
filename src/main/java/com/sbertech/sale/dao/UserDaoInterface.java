package com.sbertech.sale.dao;

import com.sbertech.sale.data.User;

import java.util.Collection;

public interface UserDaoInterface {
     void addUser(User user);

     User getUserById(long userId);

     Collection getAllUsers();

     void deleteUser(User user);
}
