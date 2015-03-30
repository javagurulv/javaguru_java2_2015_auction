package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.security.UserPrincipal;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.SecuredController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Vladislav on 2/22/2015.
 */
@Controller
public class UserSalesController {
    @Autowired
    @Qualifier("ORM_ProductDAO")
    ProductDAO productDAO;


    @RequestMapping(value = "/prot/userSale", method = {RequestMethod.PUT, RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {
        // This map will be passed to JSP
        Map<String, Object> dataToSend = new HashMap<String, Object>();

        dataToSend.put("products", getOnSaleProducts());
        dataToSend.put("heading", "Размещённые лоты");

        return new ModelAndView("userSales", "model", dataToSend);
    }

    private List<Product> getOnSaleProducts(){
        List<Product> OnSaleProducts = new ArrayList<Product>();

        User user = getCurrentUser();
        if (user!=null){
            List<Product> products = productDAO.getByUser(user);
            for (Product product : products){
                if (product.getStatus()==true) OnSaleProducts.add(product);
            }
        }
        return OnSaleProducts;
    }


    private User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = null;
        if (!(auth instanceof AnonymousAuthenticationToken)){
            UserPrincipal userPrincipal = (UserPrincipal)auth.getPrincipal();
            user = userPrincipal.getDomainUser();
        }
        return user;
    }
}