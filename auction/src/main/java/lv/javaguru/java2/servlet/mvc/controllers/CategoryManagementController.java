package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Locale;

/**
 * Created by Marks Namavirs on 19.03.2015
 */

@Controller
public class CategoryManagementController {

    @Autowired
    @Qualifier("ORM_ProductCategoryDAO")
    private ProductCategoryDAO productCategoryDAO;


    @RequestMapping(value = "category", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");



        if (request.getMethod().equals("GET")) { return modelAndView.addObject("model", GetAllCategories());

        } else {

            try {
                ProductCategory category = new ProductCategory();
                category.setName(request.getParameter("CategoryName"));
                productCategoryDAO.create(category);          // Неоходимо будет написать ограничение на добавление катерогий с таким же название, и название не должно быть пустыи.
            } catch (DBException e) { e.printStackTrace(); }

            return modelAndView.addObject("model", GetAllCategories());

        }


    }



    private  List<ProductCategory> GetAllCategories(){

        try {
              List<ProductCategory> infoString = productCategoryDAO.getAll();
              return infoString;
        } catch (DBException e) { e.printStackTrace();}

        return null;

    }


}
