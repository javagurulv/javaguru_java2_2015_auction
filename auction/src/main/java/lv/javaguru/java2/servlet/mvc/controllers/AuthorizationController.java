package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.services.AccountManager;
import lv.javaguru.java2.services.LoginException;
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
public class AuthorizationController {
    @Autowired
    AccountManager accountManager;

    @RequestMapping(value = "auth", method = {RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            accountManager.authorize(login, password, request.getSession());
            return modelAndView.addObject("model", null);
        } catch (LoginException e) {
            return modelAndView.addObject("model", "Неверный логин или пароль!");

        }
    }




}
