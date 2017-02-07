package com.sbertech.sale.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ErrorController {
    @RequestMapping(name = "/error")
    public ModelAndView error(@RequestParam("location") String location,
                              @RequestParam("messageError") String messageError) {
        ModelAndView model = new ModelAndView(new RedirectView("/index"));
        model.addObject("messageError", messageError);
        model.addObject("location", location);
        model.setViewName("error");
        return model;

    }
}
