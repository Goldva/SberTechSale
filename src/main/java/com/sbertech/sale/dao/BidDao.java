package com.sbertech.sale.dao;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BidDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addBid(Bid bid) {
        sessionFactory.getCurrentSession().persist(bid);
    }

    public Bid getBidById(long bidId) {
        return (Bid) sessionFactory.getCurrentSession().get(Bid.class, bidId);
    }

    public List getAllBids() {
        return sessionFactory.getCurrentSession().createCriteria(Bid.class).list();
    }

    public List getBidByUser(User user) {
        return sessionFactory.getCurrentSession().createCriteria(Bid.class)
                .add(Restrictions.eq("user", user))
                .list();
    }

    public List getBidByItem(Item item) {
        return sessionFactory.getCurrentSession().createCriteria(Bid.class)
                .add(Restrictions.eq("item", item))
                .list();
    }

    public void deleteBid(Bid bid) {
        sessionFactory.getCurrentSession().delete(bid);
    }

}
