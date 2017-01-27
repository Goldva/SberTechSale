package com.sbertech.sale.web.controllers;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import com.sbertech.sale.service.BidService;
import com.sbertech.sale.service.ItemService;
import com.sbertech.sale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Main {
    @Autowired
    private BidService bidService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/")
    public ModelAndView index(){
        User user = new User();
        user.setName("name12");

        Item item = new Item();
        item.setName("ItemName12");
        item.setUser(user);
        item.setDescription("blablablabla2");

        Bid bid = new Bid();
        bid.setUser(user);
        bid.setItem(item);

        userService.addUser(user);
        itemService.addItem(item);
        bidService.addBid(bid);

        ModelAndView model = new ModelAndView();
        model.addObject("users", userService.getAllUsers());
        model.addObject("items", itemService.getAllItems());
        model.addObject("bids", bidService.getAllBids());
        model.addObject("newUser", new User());
        model.addObject("newItem", new Item());
        model.addObject("newBid", new Bid());


        model.setViewName("index");

        return model;

    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public ModelAndView index(@ModelAttribute("newUser") User user){
        userService.addUser(user);
        ModelAndView model = new ModelAndView();

        model.setViewName("index");

        return model;
    }

}
