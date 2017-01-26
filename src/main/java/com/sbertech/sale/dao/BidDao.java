package com.sbertech.sale.dao;

import com.sbertech.sale.data.Bid;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public class BidDao {
    @Autowired
    private SessionFactory sessionFactory;

    public void addBid(Bid bid){
        sessionFactory.getCurrentSession().save(bid);
    }

    public Bid getBidById(long bidId) {
        return (Bid) sessionFactory.getCurrentSession().get(Bid.class, bidId);
    }

    public Collection getAllBids() {
        return sessionFactory.getCurrentSession().createCriteria(Bid.class).list();
    }

    public void deleteBid(Bid bid) {
        sessionFactory.getCurrentSession().delete(bid);
    }

}
