package lv.javaguru.java2.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.security.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Vladislav on 2/25/2015.
 */

@Controller
public class AddPageController {
    @Autowired
    ProductCategoryDAO categoryDAO;

    @Autowired
    ProductDAO productDAO;

    @RequestMapping(value = "/prot/add", method = {RequestMethod.GET})
    public ModelAndView processGetRequest(HttpServletRequest request, HttpServletResponse response) {
        // This map will be send to view
        Map<String, Object> dataToSend = new HashMap<String, Object>();

        // Categories that will be displayed in options menu
        dataToSend.put("categoryNames", getCategoryNames());


        return new ModelAndView("add", "model", dataToSend);
    }


    @RequestMapping(value = "/prot/add", method = {RequestMethod.POST})
    public ModelAndView processPostRequest(HttpServletRequest request, HttpServletResponse response){
        // This map will be send to view
        Map<String, Object> dataToSend = new HashMap<String, Object>();

        // Categories that will be displayed in options menu
        dataToSend.put("categoryNames", getCategoryNames());


        // This method will be invoked when user decided to add his product
        Product product = getProductFromForm(request);
        addProductToDB(product);

        return new ModelAndView("add", "model", dataToSend);
    }

    private Product getProductFromForm(HttpServletRequest request){
        Product product = new Product();
        product.setName(request.getParameter("name"));
        product.setDescription(request.getParameter("description"));
        product.setImage(request.getParameter("image"));
        System.out.println(request.getParameter("price")+"string");

        Double price = Double.parseDouble(request.getParameter("price"));
        product.setPrice(BigDecimal.valueOf(price));

        product.setStatus(true);
        product.setCategory(categoryDAO.getByName(request.getParameter("category")));
        product.setUser(getCurrentUser());

        product.setCurrentDate();

        return product;
    }

    private void addProductToDB(Product product){
        try {
            productDAO.create(product);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    private void addDateToProduct(Product product){
        DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        Date date = new Date();
        product.setDate(dateFormat.format(date));

    }


    // Returns names of categories needed for select item in JSP
    private List<String> getCategoryNames(){
        List<String> categoryNames = new ArrayList<String>();
        try {
            List<ProductCategory> categories = categoryDAO.getAll();
            for (ProductCategory category: categories){
                categoryNames.add(category.getName());
            }

        } catch (DBException e) {
            e.printStackTrace();
        }
        return categoryNames;
    }

    private User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)auth.getPrincipal();
        User user = userPrincipal.getDomainUser();
        return user;
    }

}

