package com.sbertech.sale.service;

import com.sbertech.sale.dao.BidDao;
import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BidService {
    @Autowired
    private BidDao bidDao;

    @Transactional
    public void addBid(Bid bid) {
        bidDao.addBid(bid);
    }

    @Transactional
    public Bid getBidById(long bidId) {
        return bidDao.getBidById(bidId);
    }

    @Transactional
    public List getAllBids() {
        return bidDao.getAllBids();
    }

    @Transactional
    public List getBidByUser(User userId) {
        return bidDao.getBidByUser(userId);
    }

    @Transactional
    public List getBidByItem(Item item) {
        return bidDao.getBidByItem(item);
    }

    @Transactional
    public void deleteBid(Bid bid) {
        bidDao.deleteBid(bid);
    }

}
