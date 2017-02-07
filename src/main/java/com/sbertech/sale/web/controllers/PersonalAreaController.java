package com.sbertech.sale.web.controllers;

import com.sbertech.sale.data.User;
import com.sbertech.sale.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

@Controller
@SessionAttributes("loginUser")
@RequestMapping(value = "/personalArea")
public class PersonalAreaController {
    @Autowired
    private BidService bidService;

    @RequestMapping()
    public ModelAndView personalArea(@ModelAttribute("loginUser") User user){
        ModelAndView model = new ModelAndView();
        model.addObject("bids", bidService.getBidByUser(user));
        model.setViewName("PersonalArea");
        return model;

    }
}
