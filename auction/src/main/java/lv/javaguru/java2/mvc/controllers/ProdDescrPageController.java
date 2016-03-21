package lv.javaguru.java2.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.security.UserPrincipal;
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
import java.util.HashMap;

/**
 * Created by Denis on 22-Feb-15.
 */
@Controller
public class ProdDescrPageController {
    @Autowired
    @Qualifier("ORM_ProductDAO")
    private ProductDAO productDAO;

    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @Autowired
    private UserBoughtController userBoughtController;


    @RequestMapping(value = "details", params = {"prod"}, method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {

        // Map that will be attached to model!
        HashMap<String, Object> dataToSend = new HashMap<String, Object>();

        // Get product from parameter
        String prodID = request.getParameter("prod");
        if (prodID!=null){
            // Adding product to hashMap

            Product product = getProductByID(Long.parseLong(prodID));
            dataToSend.put("product", product);

            // Possibly user will be also added!

        }

        return new ModelAndView("prodDescrip", "model", dataToSend);
    }

    @RequestMapping(value = "details", params = "boughtProductID", method = {RequestMethod.POST})
    public ModelAndView processBuyRequest(HttpServletRequest request, HttpServletResponse response){

        // Getting product by attribute
        Long productId = Long.parseLong(request.getParameter("boughtProductID"));
        Product product = getProductByID(productId);

        buyProduct(product);

        return userBoughtController.processRequest(request, response);
    }


    /*  ***** ***** ***** ***** ***** *****  */
    // Methods needed for buy/sale
    private void buyProduct(Product product){

        User currentUser = getCurrentUser();
        User oldOwner = product.getUser();
        if (userCanBuyProduct(currentUser, product)){

            moveMoney(oldOwner, currentUser,  product.getPrice());
            // Setting new owner
            product.setUser(getCurrentUser());
            // Product will be bought now
            product.setStatus(false);

            // Update product in db
            updateProduct(product);
        }
    }

    private void moveMoney(User trader, User customer, BigDecimal price){
        trader.setBalance(trader.getBalance().add(price));
        customer.setBalance(customer.getBalance().subtract(price));

        try {
            userDAO.update(trader);
            userDAO.update(customer);
        } catch (DBException e) {
            e.printStackTrace();
        }
    }

    private boolean userCanBuyProduct(User user, Product product){
        return (user.getBalance().compareTo(product.getPrice())>-1);
    }

    private void updateProduct(Product product){
            try {
                productDAO.update(product);
            } catch (DBException e) {
                e.printStackTrace();
            }
    }

    /*  ***** ***** ***** ***** ***** ***** */
    // Private helper methods

    private Product getProductByID(Long id){
        Product product = null;
        try {
            product = productDAO.getWithUserById(id);
        } catch (DBException e) {
            System.out.println("Product with this Id not found!");
            e.printStackTrace();
        }
        return product;
    }

    private User getCurrentUser(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserPrincipal userPrincipal = (UserPrincipal)auth.getPrincipal();
        User user = userPrincipal.getDomainUser();
        return user;
    }

}
