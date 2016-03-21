package lv.javaguru.java2.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.security.UserPrincipal;
import lv.javaguru.java2.mvc.SecuredController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;

/**
 * Created by Denis on 22-Feb-15.
 */
@Controller
public class BalancePageController extends SecuredController {
    @Autowired
    @Qualifier("ORM_UserDAO")
    UserDAO userDAO;

    @RequestMapping(value = "/prot/balance", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {

        // Get user
        User user = getCurrentUser();

        return new ModelAndView("balance", "model", user.getBalance().toString());
    }

    @RequestMapping(value = "/prot/balance", method = {RequestMethod.POST})
    public ModelAndView processReinforcementRequest(HttpServletRequest request, HttpServletResponse response){
        // Get passed sum that should be added to balance
        Double reinforcement = Double.parseDouble(request.getParameter("reinforcement"));

        // Get user
        User user = getCurrentUser();

        // Add This sum to balance
        user.addToBalance(BigDecimal.valueOf(reinforcement));
        updateUser(user);

        return new ModelAndView("balance", "model", user.getBalance().toString());
    }

    /* ***  ***  ***  ***  ***  ***  ***  *** */
    /* Helper methods */
    private User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)auth.getPrincipal();
        User user = userPrincipal.getDomainUser();
        return user;
    }

    private void updateUser(User user){
        try {
            userDAO.update(user);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

}