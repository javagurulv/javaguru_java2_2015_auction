package lv.javaguru.java2.mvc.controllers;

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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Marks Namavirs on 19.03.2015
 */

@Controller
public class CategoryManagementController {

    @Autowired
    @Qualifier("ORM_ProductCategoryDAO")
    private ProductCategoryDAO productCategoryDAO;




    @RequestMapping(value = "/prot/category", method = {RequestMethod.GET})
    public ModelAndView processRequestGet(HttpServletRequest request, HttpServletResponse response) {

      ModelAndView modelAndView = new ModelAndView();
      modelAndView.setViewName("category");
      modelAndView.addObject("errorMsg", "");
      return modelAndView.addObject("model", GetAllCategories());

    }



    @RequestMapping(value = "/prot/category", params = "AddBTN", method = {RequestMethod.POST})
    public ModelAndView processRequestAddBTN(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("category");
        String errorMsg = ValidateCategoryName(request.getParameter("AddCategoryName"));


        if(errorMsg != "") {
            modelAndView.addObject("errorMsg", errorMsg);
            modelAndView.addObject("model", GetAllCategories());
            return modelAndView;
        } else {
            modelAndView.addObject("errorMsg", "Категория добавлена!");
        }

            try {
                ProductCategory category = new ProductCategory();
                category.setName(request.getParameter("AddCategoryName"));
                productCategoryDAO.create(category);
            } catch (DBException e) {
                e.printStackTrace();
                }

        modelAndView.addObject("model", GetAllCategories());
        return modelAndView;

    }



    @RequestMapping(value = "category", params = "DeleteBTN", method = {RequestMethod.POST})
    public ModelAndView processRequestDeleteBTN(HttpServletRequest request, HttpServletResponse response) {

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("errorMsg", "Категория удалена!");
        modelAndView.setViewName("category");
        String category = request.getParameter("DeleteCategoryName");

        if(category != null) {
        try {
             productCategoryDAO.delete(Long.parseLong(category)); // Неоходимо будет написать ограничение на добавление катерогий с таким же название, и название не должно быть пустыи.
            } catch (DBException e) {
                e.printStackTrace();
                }
        }

        return modelAndView.addObject("model", GetAllCategories());

    }



    private  List<ProductCategory> GetAllCategories(){

        try {
              List<ProductCategory> categoryList = productCategoryDAO.getAll();
              return categoryList;
        } catch (DBException e) { e.printStackTrace();}

        return null;

    }



    private String ValidateCategoryName(String checkCategoryName){

        List<ProductCategory> categories = GetAllCategories();
        List<String> categoryNames = new ArrayList<String>();

        for (ProductCategory category: categories){
            categoryNames.add(category.getName());
        }

        if (categoryNames.contains(checkCategoryName)) {
            return "Такая категория уже существует!";
        }

        return "";

    }


}
