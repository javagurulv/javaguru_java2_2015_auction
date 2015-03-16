package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.hibernate.ProductCategoryDAOImpl;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

/**
 * Created by Vladislav on 3/16/2015.
 */
@Component
public class DatabaseFiller {
    @Qualifier("ORM_UserDAO")
    @Autowired
    private UserDAO userDAO;

    @Qualifier("ORM_ProductDAO")
    @Autowired
    private ProductDAO productDAO;

    @Autowired
    private ProductCategoryDAO categoryDAO;
    private Random random;
    public DatabaseFiller() {
        random = new Random();
    }

    public void initCategories(){
        List<String> categoryNames = new ArrayList<String>();
        // Add your categories here
        categoryNames.add("Котята");
        categoryNames.add("Цветы");
        categoryNames.add("Конфеты");
        categoryNames.add("Ёлочные игрушки");

        addCategoriesToDB(categoryNames);
    }


    private void addCategoriesToDB(List<String> categoryNames ){
        for (String categoryName : categoryNames)
            try {
                ProductCategory category = createCategory(categoryName);
                categoryDAO.create(category);
            } catch (DBException e) {
                e.printStackTrace();
            }
    }

    public void addFakeProducts() {
        try {

            // Get categories
            List<ProductCategory> categories  = categoryDAO.getAll();
            // Create trader
            User user = userDAO.getByLogin("FakeUser");
            if (user==null) {
                user = createUser("FakeUser", "FakeUser", "FakeUser");
                userDAO.create(user);
            }

            // Create 5 product for each category
            for (ProductCategory category: categories) {
                for (int i = 1; i <= 5; i++) {
                    String name = category.getName() + ": Товар номер: " + i;
                    Product product = createProduct(name, user, category);
                    productDAO.create(product);
                }
            }

        } catch (DBException e) {
            e.printStackTrace();
        }
    }


    // Entity creation methods
    private Product createProduct(String name, User user, ProductCategory category){
        Product product = new Product();
        // wiring dependencies
        product.setName(name);
        product.setUser(user);
        product.setCategory(category);
        // Creating fields
        product.setDescription("Описание Описание Описание /n Описание Описание Описание /n Описание Описание Описание ");
        product.setImage("image");
        product.setPrice(random.nextInt(18)*100);
        product.setStatus(true);

        return product;
    }

    private ProductCategory createCategory(String name){
        ProductCategory category = new ProductCategory();
        category.setName(name);
        return  category;
    }

    private User createUser(String firstName, String lastName, String login){
        User user = new User();

        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword("Test");
        user.setBalance(new BigDecimal(255));
        user.setEmail("Test@Test.ru");
        user.setAvatar("image");

        return user;
    }
}
