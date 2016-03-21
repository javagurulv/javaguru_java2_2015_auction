package lv.javaguru.java2.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Marks Namavirs on 15.22.3.
 */


@Controller
public class AboutController {

    @RequestMapping(value = "about", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView("about", "model", null);
        return modelAndView;

    }

}