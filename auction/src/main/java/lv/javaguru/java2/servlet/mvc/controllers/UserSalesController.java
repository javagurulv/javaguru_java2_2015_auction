package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.SecuredController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

        return new ModelAndView("userSales", "model", dataToSend);
    }

    private List<Product> getOnSaleProducts(){
        List<Product> boughtProducts = new ArrayList<Product>();
        try {
            List<Product> products = productDAO.getAll();
            for (Product product : products){
                if (product.getStatus()==true) boughtProducts.add(product);
            }
        } catch (DBException e) {
            e.printStackTrace();
        }
        return boughtProducts;
    }
}