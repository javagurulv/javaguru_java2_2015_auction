package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.services.SearchEngine;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.MVCController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Vladislav on 2/17/2015.
 */
@Controller
public class SearchResController {
    @Autowired
    SearchEngine searchEngine;

    @RequestMapping(value = "prod", method = {RequestMethod.GET})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("searchRes");

        String searchQuery = request.getParameter("searchQuery");
        // This 4 must be changed somehow because controller shouldn't be aware of view
        List<Product> productList = searchEngine.searchForProductsBy(searchQuery, 1, 4);
        modelAndView.addObject("model", productList);

        return modelAndView;
    }
}
