package com.sbertech.sale.web.controllers;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
import com.sbertech.sale.service.BidService;
import com.sbertech.sale.service.ItemService;
import com.sbertech.sale.service.UserService;
import org.hibernate.exception.ConstraintViolationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.io.UnsupportedEncodingException;
import java.util.List;

@Controller
@RequestMapping(value = "/index")
public class MainMenu {
    @Autowired
    private BidService bidService;
    @Autowired
    private ItemService itemService;
    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView index() {

        ModelAndView model = new ModelAndView();

//        model.addObject("users", userService.getAllUsers());
        model.addObject("items", itemService.getAllItems());
//        model.addObject("bids", bidService.getAllBids());
//        model.addObject("newUser", new User());
        model.addObject("newItem", new Item());
        model.addObject("newBid", new Bid());
//        model.addObject("error", error);
//        model.addObject("messageError", messageError);

        model.setViewName("index");

        return model;

    }

//    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
//    public ModelAndView addUser(@ModelAttribute("newUser") User user) {
//        ModelAndView model = new ModelAndView(new RedirectView("/"));
//
//        try {
//            userService.addUser(user);
//        } catch (ConstraintViolationException e) {
//            model.addObject("error", "true");
//            model.addObject("messageError", "Пользователь с таким именем уже существует");
//            return model;
//        }
//        return model;
//    }

    @RequestMapping(value = "/addItem", method = RequestMethod.POST)
    public ModelAndView addItem(@ModelAttribute("newItem") Item item) throws UnsupportedEncodingException {
        ModelAndView model = new ModelAndView(new RedirectView("/"));
        List users = userService.getAllUsers();
        if (users.indexOf(item.getUser()) != -1) {
            int i = users.indexOf(item.getUser());
            item.setUser((User) users.get(i));
            itemService.addItem(item);
        } else {
            model.addObject("error", "true");
            model.addObject("messageError", "Пользователя с таким именем не существует");
        }
        return model;
    }

    @RequestMapping(value = "/addBid", method = RequestMethod.POST)
    public ModelAndView addBid(@ModelAttribute("newBid") Bid bid) {
        ModelAndView model = new ModelAndView(new RedirectView("/"));
        try {
            bidService.addBid(bid);
        } catch (ConstraintViolationException e) {
            model.addObject("error", "true");
            model.addObject("messageError", "Пользователя или предмета с таким именем не существует");
            return model;
        }
        return model;
    }

}
