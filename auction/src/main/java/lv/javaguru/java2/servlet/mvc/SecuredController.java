package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.services.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Vladislav on 3/1/2015.
 */
public abstract class SecuredController {
    @Autowired
    AccountManager accountManager;

    private boolean isAuthorized(HttpServletRequest req){
        return accountManager.isAuthorized(req.getSession());
    }
    protected MVCModel getSecuredModel(String view, Object object, HttpServletRequest request){
        if (isAuthorized(request)){
            return new MVCModel(view, object);
        }
        else return new MVCModel("/jsp/mustlogin.jsp", null);
    }
}
