package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
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
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }


    @Test
    public void testGetCompanyesWithUsers() throws DBException {
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
                    Product product2 = createProduct("Cat1", user, category);
                    Product product3 = createProduct("Cat1", user, category);

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

    private Product createProduct(String name, String description, boolean status, String image, double price,
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
        product.setPrice(255);
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