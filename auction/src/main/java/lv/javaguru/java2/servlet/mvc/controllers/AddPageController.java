package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.SecuredController;
import org.springframework.beans.factory.annotation.Autowired;
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
 * Created by Vladislav on 2/25/2015.
 */

@Controller
public class AddPageController {
    @Autowired
    ProductCategoryDAO categoryDAO;

    @RequestMapping(value = "add", method = {RequestMethod.GET, RequestMethod.PUT})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {
        // This map will be send to view
        Map<String, Object> dataToSend = new HashMap<String, Object>();

        // Categories that will be displayed in options menu
        dataToSend.put("categoryNames", getCategoryNames());


        return new ModelAndView("add", "model", dataToSend);
    }



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
}

