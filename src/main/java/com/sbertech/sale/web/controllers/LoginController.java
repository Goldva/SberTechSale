package com.sbertech.sale.web.controllers;

import com.sbertech.sale.data.User;
import com.sbertech.sale.exception.ConflictException;
import com.sbertech.sale.exception.NotFoundExeption;
import com.sbertech.sale.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@SessionAttributes("loginUser")
@RequestMapping(value = "/sale")
public class LoginController {
    @Autowired
    private UserService userService;

    @ModelAttribute("loginUser")
    public User createUser() {
        return new User();
    }

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView loginMenu(@ModelAttribute("loginUser") User user) {
        ModelAndView model = new ModelAndView();
        if (user.getId() == null) {
            model.addObject("loginUser", user);
            model.setViewName("loginMenu");
        }else {
            model.setView(new RedirectView("/sale/index"));
        }
        return model;
    }

    @RequestMapping(value = "/userCheck")
    public ModelAndView userCheck(@ModelAttribute("loginUser") User user) {
        ModelAndView model = new ModelAndView(new RedirectView("/sale/index"));
        List users = userService.getUserByLogin(user.getUserName());
        if (users.size() == 0) {
            throw new NotFoundExeption();
        }
        model.addObject("loginUser", users.get(0));
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.GET)
    public ModelAndView registrationMenu() {
        ModelAndView model = new ModelAndView(new RedirectView("/sale/"));
        model.addObject("newUser", new User());
        model.setViewName("registrationMenu");
        return model;
    }

    @RequestMapping(value = "/registration", method = RequestMethod.POST)
    public ModelAndView addUser(@ModelAttribute("newUser") User user) {
        ModelAndView model = new ModelAndView();
        List users = userService.getUserByLogin(user.getUserName());
        if (users.size() != 0) {
            throw new ConflictException();
        }
        userService.addUser(user);
        model.setView(new RedirectView("/sale/"));
        return model;
    }
}
