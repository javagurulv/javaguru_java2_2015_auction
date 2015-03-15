package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.services.SearchEngine;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.MVCController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Vladislav on 2/17/2015.
 */
@Component
public class SearchResController implements MVCController {
    @Autowired
    SearchEngine searchEngine;

    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {
        String message = "Hello from MVC!";
        MVCModel model = new MVCModel("/jsp/searchRes.jsp", message);


        List<Product> productList = searchEngine.searchForProductsBy("car", 1, 5);
        System.out.println("Results found: "+productList.size());
        for (Product product: productList){
            System.out.println(product.getName());
        }

        return model;
    }
}
