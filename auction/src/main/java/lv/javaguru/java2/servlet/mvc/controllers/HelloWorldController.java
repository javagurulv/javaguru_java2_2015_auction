package lv.javaguru.java2.servlet.mvc.controllers;
import lv.javaguru.java2.servlet.mvc.MVCModel;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class HelloWorldController implements MVCController {
    @Override
    public MVCModel processRequest(HttpServletRequest request,
                                   HttpServletResponse response) {
        String message = "Hello from MVC!";
        MVCModel model = new MVCModel("/jsp/helloWorld.jsp", message);
        return model;
    }
}