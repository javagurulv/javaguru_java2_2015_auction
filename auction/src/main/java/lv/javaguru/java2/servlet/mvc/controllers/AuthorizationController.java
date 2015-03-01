package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.services.AccountManager;
import lv.javaguru.java2.services.LoginException;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 3/1/2015.
 */
@Component
public class AuthorizationController implements MVCController {
    AccountManager accountManager = new AccountManager(); //Add it with spring
    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {

        String login = request.getParameter("login");
        String password = request.getParameter("password");

        try {
            accountManager.authorize(login, password, request.getSession());
            return new MVCModel("/jsp/index.jsp", null);
        } catch (LoginException e) {
            return new MVCModel("/jsp/index.jsp", "Неверный логин или пароль!");
        }
    }
}
