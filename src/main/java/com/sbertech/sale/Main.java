package com.sbertech.sale;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import com.sbertech.sale.service.BidService;
import com.sbertech.sale.service.ItemService;
import com.sbertech.sale.service.UserService;

/**
 * Created by ermakov on 26.01.2017.
 */
public class Main {
    public static void main(String[] args) {
        BidService bidService = new BidService();
        ItemService itemService = new ItemService();
        UserService userService = new UserService();

        User user = new User();
        user.setName("name1");

        Item item = new Item();
        item.setName("ItemName1");
        item.setUser(user);
        item.setDescription("blablablabla");

        Bid bid = new Bid();
        bid.setUser(user);
        bid.setItem(item);

        userService.addUser(user);
        itemService.addItem(item);
        bidService.addBid(bid);

    }
}
