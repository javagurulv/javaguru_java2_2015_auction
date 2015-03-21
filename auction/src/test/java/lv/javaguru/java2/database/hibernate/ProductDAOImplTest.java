package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import static org.junit.Assert.*;


public class ProductDAOImplTest extends SpringIntegrationTest {

    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;
    @Autowired
    @Qualifier("ORM_ProductCategoryDAO")
    private ProductCategoryDAO productCategoryDAO;

    @Autowired
    @Qualifier("ORM_ProductDAO")
    private ProductDAO productDAO;

    @Autowired
    PlatformTransactionManager transactionManager;

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    @Before
    @After
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }


    @Test
    public void testGetByUser() throws DBException {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {

            // Creating dependent entities
            User user1 = createUser("TestedF", "TestedL", "Login1", "pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
            User user2 = createUser("F", "L", "Login2", "pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
            ProductCategory category1 = createCategory("Vehicle");

                try {
                    userDAO.create(user1);
                    userDAO.create(user2);
                    productCategoryDAO.create(category1);
                } catch (DBException e) {
                    e.printStackTrace();
                }
            // Created
            // Creating products that will be tested
            Product product1 = createProduct("TestProduct1", user1, category1);
            Product product2 = createProduct("TestProduct2", user1, category1);
            Product product3 = createProduct("TestProduct3", user1, category1);
            //(Fake products)
            Product product4 = createProduct("TestProduct4", user2, category1);
            Product product5 = createProduct("TestProduct5", user2, category1);

                try {
                    productDAO.create(product1);
                    productDAO.create(product2);
                    productDAO.create(product3);
                    productDAO.create(product4);
                    productDAO.create(product5);
                } catch (DBException e) {
                    e.printStackTrace();
                }
            // Created
            // Testing
            List<Product> products = productDAO.getByUser(user1);
            for (Product testedProduct: products){
                assertEquals(testedProduct.getUser().getFirstName(), user1.getFirstName());
            }
            assertEquals(products.size(), 3);
            }
        });


    }

    @Test
    public void testGetProductsInCategory() throws DBException {
        // Creating dependent entities
        User user = createUser("F", "L", "Login", "pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        ProductCategory category1 = createCategory("Vehicle");
        ProductCategory category2 = createCategory("Animal");

        userDAO.create(user);
        productCategoryDAO.create(category1);
        productCategoryDAO.create(category2);
        // Created
        // Creating products that will be tested in DB
        Product product1 = createProduct("TestProduct1", user, category1);
        Product product2 = createProduct("TestProduct2", user, category1);
        Product product3 = createProduct("TestProduct3", user, category2);
        Product product4 = createProduct("TestProduct4", user, category2);
        productDAO.create(product1);
        productDAO.create(product2);
        productDAO.create(product3);
        productDAO.create(product4);
        // Created
        // Getting result
        Long count= productDAO.getProductCountInCategory(category1);
        // Testing result
        assertEquals(count, new Long(2));
    }

    @Test
    public void testGetProductByCategory() throws DBException {
        User user = createUser("F", "L", "Login", "pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        ProductCategory category = createCategory("Vehicle");


        userDAO.create(user);
        productCategoryDAO.create(category);

        Product product1 = createProduct("TestProduct1", user, category);
        Product product2 = createProduct("TestProduct2", user, category);
        Product product3 = createProduct("TestProduct3", user, category);

        productDAO.create(product1);
        productDAO.create(product2);
        productDAO.create(product3);

        List<Product> products = productDAO.getProductsInCategory(category);

        assertEquals(products.size(), 3);

    }

    @Test
    public void testGetUserWithProductList() throws DBException {
        TransactionTemplate tt = new TransactionTemplate(transactionManager);

        final AtomicLong userId = new AtomicLong();
        tt.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus paramTransactionStatus) {
                User user = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
                try {
                    userDAO.create(user);
                    userId.set(user.getUserId());
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
            }
        });


        final AtomicLong categoryID = new AtomicLong();
        tt.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                ProductCategory category = createCategory("Vehicle");
                try {
                    productCategoryDAO.create(category);
                    categoryID.set(category.getCategoryId());
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }

            }
        });

        tt.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus paramTransactionStatus) {
                try {
                    User user = userDAO.getById((userId.get()));
                    ProductCategory category = productCategoryDAO.getById(categoryID.get());

                    Product product1 = createProduct("Cat1", user, category);
                    Product product2 = createProduct("Cat2", user, category);
                    Product product3 = createProduct("Cat3", user, category);

                    productDAO.create(product1);
                    productDAO.create(product2);
                    productDAO.create(product3);

                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        tt.execute(new TransactionCallbackWithoutResult() {
            protected void doInTransactionWithoutResult(TransactionStatus paramTransactionStatus) {
                try {
                    User user = userDAO.getById((userId.get()));
                    List<Product> productList = user.getProductList();

                    assertEquals(productList.size(), 3);
                } catch (DBException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }

    private User createUser(String firstName, String lastName, String login, String password,
                            BigDecimal balance, String email, String avatar) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setBalance(balance);
        user.setEmail(email);
        user.setAvatar(avatar);

        return user;
    }

    private Product createProduct(String name, String description, boolean status, String image, BigDecimal price,
                                  User owner) {

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setStatus(status);
        product.setImage(image);
        product.setPrice(price);
        product.setUser(owner);

        return product;
    }
    private Product createProduct(String name, User user, ProductCategory category){
        Product product = new Product();
        product.setName(name);
        product.setDescription("CatCatCatCatCatCatCatCatCatCat");
        product.setStatus(true);
        product.setImage("/image");
        product.setPrice(BigDecimal.valueOf(255));
        product.setUser(user);
        product.setCategory(category);

        return product;
    }

    private ProductCategory createCategory(String name){
        ProductCategory category = new ProductCategory();
        category.setName(name);

        return category;
    }

}