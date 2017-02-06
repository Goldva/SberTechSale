package com.sbertech.sale.web.controllers;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import com.sbertech.sale.service.BidService;
import com.sbertech.sale.service.ItemService;
import com.sbertech.sale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@SessionAttributes("loginUser")
@RequestMapping(value = "/index")
public class MainMenu {
    @Autowired
    private BidService bidService;
    @Autowired
    private ItemService itemService;

    @RequestMapping
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.addObject("items", itemService.getAllItemsAreNotBought());
        model.addObject("newItem", new Item());
        model.addObject("newBid", new Bid());
        model.setViewName("index");
        return model;
    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public ModelAndView addItem(
            @ModelAttribute("newItem") Item item,
            @ModelAttribute("loginUser") User user) {
        ModelAndView model = new ModelAndView(new RedirectView("/index"));
        item.setUser(user);
        itemService.addItem(item);
        return model;
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.PUT)
    public ModelAndView addBid(
            @PathVariable String itemId,
            @ModelAttribute("loginUser") User user) {
        ModelAndView model = new ModelAndView(new RedirectView("/index"));
        Item item = itemService.getItemById(Long.valueOf(itemId));
        Bid bid = new Bid();
        bid.setItem(item);
        bid.setUser(user);
        bidService.addBid(bid);
        return model;
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public ModelAndView exit(){
        ModelAndView model = new ModelAndView(new RedirectView("/"));
        model.addObject("loginUser", new User());
        return model;
    }
}
