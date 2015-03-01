package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.services.AccountManager;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 3/1/2015.
 */
@Component
public class LogoffController implements MVCController {
    @Autowired
    AccountManager accountManager;

    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {
        accountManager.logOffUserFromSession(request.getSession());
        return new MVCModel("/jsp/index.jsp", null);
    }
}
