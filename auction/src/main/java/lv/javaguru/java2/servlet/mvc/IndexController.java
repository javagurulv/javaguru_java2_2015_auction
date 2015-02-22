package lv.javaguru.java2.servlet.mvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 2/22/2015.
 */
public class IndexController implements MVCController {
    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {
        MVCModel model = new MVCModel("/jsp/index.jsp", null);
        return model;
    }
}
