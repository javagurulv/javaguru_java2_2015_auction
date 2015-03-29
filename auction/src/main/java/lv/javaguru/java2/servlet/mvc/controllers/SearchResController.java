package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.services.SearchEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
 * Created by Vladislav on 2/17/2015.
 */
@Controller
public class SearchResController {
    @Autowired
    SearchEngine searchEngine;

    @Autowired
    ProductCategoryDAO categoryDAO;

    @Qualifier("ORM_ProductDAO")
    @Autowired
    ProductDAO productDAO;


    @RequestMapping(value = "prod", method = {RequestMethod.GET})
    public ModelAndView processSearchRequest(HttpServletRequest request, HttpServletResponse response) {

        //This map will be added to model
        Map<String, Object> dataToSend = new HashMap<String, Object>();


        //Getting search results if needed
        String searchQuery = request.getParameter("searchQuery");
        if (searchQuery!=null){
            dataToSend.put("query", searchQuery);
            addQueryResults(dataToSend, searchQuery);
        }

        //Getting category results if needed
        String category = request.getParameter("categ");
        if (category!=null){
            dataToSend.put("query", category);
            addCategoryResults(dataToSend, category);
        }

        //Getting left menu content
        addLeftMenuContent(dataToSend);

        //Passing data to model
        return new ModelAndView("searchRes", "model", dataToSend);
    }


    //**************************************
    // Controller actions
    private void addQueryResults(Map<String, Object> dataToSend, String searchQuery){
        // Adds list of search results to hash map!
        dataToSend.put("searchResult", getQueryResults(searchQuery));
        dataToSend.put("resultCount", getResultCount(searchQuery));
    }

    private void addCategoryResults(Map<String, Object> dataToSend, String category){

        ProductCategory productCategory = categoryDAO.getByName(category);
        List<Product> products = productDAO.getProductsInCategory(productCategory);


        dataToSend.put("resultCount", products.size());

        // Getting only 4 needed results
        if (products.size()>4) products = products.subList(0, 4);
        dataToSend.put("searchResult", products);
    }


    private void addLeftMenuContent(Map<String, Object> dataToSend){
        //Getting data needed for left menu
        List<ProductCategory> categories = getProductCategories();

        List<String> categoryNames = new ArrayList<String>();
        List<Long> productsInCategory = new ArrayList<Long>();

        for (ProductCategory category: categories){
            categoryNames.add(category.getName());
            productsInCategory.add(productDAO.getProductCountInCategory(category));
        }

        dataToSend.put("categoryNames", categoryNames);
        dataToSend.put("productsInCategory", productsInCategory);
    }


    // *************************************
    // Private helper functions
    private Integer getResultCount(String keyWord) {
        return searchEngine.getResultCountFor(keyWord);
    }

    private List<ProductCategory> getProductCategories(){
        try {
            return categoryDAO.getAll();
        } catch (DBException e) {
            e.printStackTrace();
            return new ArrayList<ProductCategory>();
        }
    };

    private List<Product> getQueryResults(String searchQuery){
        // This 4 must be changed somehow because controller shouldn't be aware of view
        return searchEngine.searchForProductsBy(searchQuery, 0, 4);
    }


}
