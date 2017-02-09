package com.sbertech.sale.web.controllers;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import com.sbertech.sale.exception.ConflictException;
import com.sbertech.sale.service.BidService;
import com.sbertech.sale.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView model = new ModelAndView();
        model.addObject("items", itemService.getAllItemsAreNotBought());
        model.addObject("newItem", new Item());
        model.addObject("newBid", new Bid());
        model.setViewName("index");
        return model;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addItem(
            @ModelAttribute("newItem") Item item,
            @ModelAttribute("loginUser") User user) {
        ModelAndView model = new ModelAndView(new RedirectView("/index"));
        item.setUser(user);
        itemService.addItem(item);
        return model;
    }

    @RequestMapping(value = "/{itemId}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addBid(
            @PathVariable String itemId,
            @ModelAttribute("loginUser") User user) {
        Item item = itemService.getItemById(Long.valueOf(itemId));
        if (bidService.getBidByItem(item).size() != 0) {
            throw new ConflictException();
        }
        Bid bid = new Bid();
        bid.setItem(item);
        bid.setUser(user);
        bidService.addBid(bid);
    }

    @RequestMapping(value = "/exit", method = RequestMethod.GET)
    public ModelAndView exit(){
        ModelAndView model = new ModelAndView(new RedirectView("/"));
        model.addObject("loginUser", new User());
        return model;
    }
}
