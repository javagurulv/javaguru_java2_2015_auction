package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.SecuredController;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 2/25/2015.
 */

@Controller
public class AddPageController {

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.PUT})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {
        return new ModelAndView("add", "model", null);
    }
}

