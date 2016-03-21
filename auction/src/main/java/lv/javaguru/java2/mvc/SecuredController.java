package lv.javaguru.java2.mvc;

import lv.javaguru.java2.services.security.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;

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
