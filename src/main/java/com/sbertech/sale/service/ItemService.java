package com.sbertech.sale.service;

import com.sbertech.sale.dao.ItemDao;
import com.sbertech.sale.data.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemDao itemDao;

    @Transactional
    public void addItem(Item item) {
        itemDao.addItem(item);
    }

    @Transactional
    public Item getItemById(long itemId) {
        return itemDao.getItemById(itemId);
    }

    @Transactional
    public List getAllItems() {
        return itemDao.getAllItems();
    }

    @Transactional
    public void deleteItem(Item item) {
        itemDao.deleteItem(item);
    }

}
