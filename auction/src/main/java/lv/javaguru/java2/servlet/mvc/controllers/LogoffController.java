package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.services.AccountManager;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 3/1/2015.
 */
@Controller
public class LogoffController {
    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "logoff", method = {RequestMethod.PUT, RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {
        // Login off user from session
        accountManager.logOffUserFromSession(request.getSession());

        return new ModelAndView("index", "model", null);
    }
}
