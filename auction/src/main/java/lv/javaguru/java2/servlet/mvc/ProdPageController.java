package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 2/17/2015.
 */
public class ProdPageController implements MVCController{

    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {
        String message = "Hello from MVC!";
        MVCModel model = new MVCModel("/jsp/searchRes.jsp", message);
        return model;
    }
}
