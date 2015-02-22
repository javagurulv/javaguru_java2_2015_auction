package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Denis on 22-Feb-15.
 */
public class ProdDescripPageController implements MVCController{

    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {
        String message = "Hello from MVC!";
        MVCModel model = new MVCModel("/jsp/prodDescrip.jsp", message);
        return model;
    }
}
