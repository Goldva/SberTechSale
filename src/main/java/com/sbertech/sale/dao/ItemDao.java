package com.sbertech.sale.dao;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
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

//    public List getAllItemsAreNotBought() {
//        List<Item> items = (List<Item>) sessionFactory.getCurrentSession().createQuery("SELECT * From item Where id NOT IN(SELECT id From bid)");
//        return items;
////        return sessionFactory.getCurrentSession().createCriteria(Item.class)
////                .add(Restrictions.not(Restrictions.in(Restrictions.)))
////                .add(Restrictions.sqlRestriction("SELECT * From item Where id NOT IN(SELECT id From bid)"))
////                .list();
//    }

    public void deleteItem(Item item) {
        sessionFactory.getCurrentSession().delete(item);
    }

}
