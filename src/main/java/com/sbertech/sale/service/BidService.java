package com.sbertech.sale.service;

import com.sbertech.sale.dao.BidDao;
import com.sbertech.sale.data.Bid;
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
    public void deleteBid(Bid bid) {
        bidDao.deleteBid(bid);
    }

}
