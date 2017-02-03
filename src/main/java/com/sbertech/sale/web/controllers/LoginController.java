package com.sbertech.sale.web.controllers;

import com.sbertech.sale.data.Bid;
import com.sbertech.sale.data.Item;
import com.sbertech.sale.data.User;
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

@Controller
@RequestMapping(value = "/")
public class LoginController {
    @Autowired
    private UserService userService;

    @RequestMapping
    public ModelAndView index() {

        ModelAndView model = new ModelAndView();

        model.addObject("newUser", new User());

        model.setViewName("login");

        return model;
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("newUser") User user) {
        ModelAndView model = new ModelAndView(new RedirectView("/"));

        try {
            userService.addUser(user);
        } catch (ConstraintViolationException e) {
            model.addObject("messageError", "Пользователь с таким именем уже существует");
            model.addObject("location", "/");
            model.setViewName("error");
            return model;
        }
        return model;
    }
}
