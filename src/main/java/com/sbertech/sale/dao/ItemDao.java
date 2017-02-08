package com.sbertech.sale.dao;

import com.sbertech.sale.data.Item;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ItemDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addItem(Item item) {
        sessionFactory.getCurrentSession().persist(item);
    }

    public Item getItemById(long itemId) {
        return (Item) sessionFactory.getCurrentSession().get(Item.class, itemId);
    }

    public List getAllItems() {
        return sessionFactory.getCurrentSession().createCriteria(Item.class).list();
    }

    public List getAllItemsAreNotBought() {
        return sessionFactory.getCurrentSession()
                .createQuery("From Item Where id NOT IN(SELECT id From Bid)").list();
    }

    public void deleteItem(Item item) {
        sessionFactory.getCurrentSession().delete(item);
    }

}
