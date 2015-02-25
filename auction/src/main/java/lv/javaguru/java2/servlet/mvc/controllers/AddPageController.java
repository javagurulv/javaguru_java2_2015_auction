package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.servlet.mvc.MVCModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 2/25/2015.
 */
public class AddPageController implements MVCController{
    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {
        MVCModel model = new MVCModel("/jsp/add.jsp", null);
        return model;
    }
}

