package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.domain.ProductCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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

    ModelAndView modelAndView = new ModelAndView();


    @RequestMapping(value = "category", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request, HttpServletResponse response) {

      modelAndView.setViewName("category");
      return modelAndView.addObject("model", GetAllCategories());

    }



    @RequestMapping(value = "category", params = "AddBTN", method = {RequestMethod.POST})
    public ModelAndView processRequestAddBTN(HttpServletRequest request, HttpServletResponse response) {

            try {
                ProductCategory category = new ProductCategory();
                category.setName(request.getParameter("AddCategoryName"));
                productCategoryDAO.create(category);   // Неоходимо будет написать ограничение на добавление катерогий с таким же название, и название не должно быть пустыи.
            } catch (DBException e) {
                e.printStackTrace();
                }

        modelAndView.setViewName("category");
        return modelAndView.addObject("model", GetAllCategories());

    }



    @RequestMapping(value = "category", params = "DeleteBTN", method = {RequestMethod.POST})
    public ModelAndView processRequestDeleteBTN(HttpServletRequest request, HttpServletResponse response) {

        String category = request.getParameter("DeleteCategoryName");

        if(category != null) {
        try {
             productCategoryDAO.delete(Long.parseLong(category)); // Неоходимо будет написать ограничение на добавление катерогий с таким же название, и название не должно быть пустыи.
            } catch (DBException e) {
                e.printStackTrace();
                }
        }

        modelAndView.setViewName("category");
        return modelAndView.addObject("model", GetAllCategories());

    }



    private  List<ProductCategory> GetAllCategories(){

        try {
              List<ProductCategory> categoryList = productCategoryDAO.getAll();
              return categoryList;
        } catch (DBException e) { e.printStackTrace();}

        return null;

    }


}
