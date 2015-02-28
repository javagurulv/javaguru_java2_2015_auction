package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;
import org.junit.*;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vladislav on 2/15/2015.
 * Updated by Mark on 28.02.2015.
 */

public class ProductDAOImplTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();


    @Before
    @After
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();

    }


    @Test
    public void testCreate() throws DBException {

        User user = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        userDAO.create(user);

        Product product = createProduct("Car1", "Very heavy car!", true, "car.jpg", 999.99, user.getUserId());
        productDAO.create(product);

        Product productFromDB = productDAO.getById(product.getProductID());
        assertNotNull(productFromDB);
        assertEquals(product.getProductID(), productFromDB.getProductID());
        assertEquals(product.getName(), productFromDB.getName());
        assertEquals(product.getDescription(), productFromDB.getDescription());
        assertEquals(product.getStatus(), productFromDB.getStatus());
        assertEquals(product.getImage(), productFromDB.getImage());
        assertEquals(product.getPrice(), productFromDB.getPrice(), 0.001);
        assertEquals(product.getOwnerID(), productFromDB.getOwnerID());

    }

    @Test
    public void testMultipleProductCreation() throws DBException {

        User user = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        userDAO.create(user);

        Product product1 = createProduct("Car1", "Very heavy car!", true, "car.jpg", 999.99, user.getUserId());
        Product product2 = createProduct("Car2", "Very heavy car!", true, "car.jpg", 666.66, user.getUserId());

        productDAO.create(product1);
        productDAO.create(product2);

        List<Product> products = productDAO.getAll();
        assertEquals(2, products.size());
    }

    @Test
    public void testGetById() throws DBException {

        User user = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        userDAO.create(user);

        Product product = createProduct("Car1", "Very heavy car!", true, "car.jpg", 999.99, user.getUserId());
        productDAO.create(product);

        Product productFromDB = productDAO.getById(product.getProductID());
        assert (product.getName().equals(productFromDB.getName()) );
    }

    @Test
    public void testDelete() throws DBException {

        User user = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        userDAO.create(user);

        Product product = createProduct("Car1", "Very heavy car!", true, "car.jpg", 999.99, user.getUserId());
        productDAO.create(product);

        productDAO.delete(product.getProductID());
        assert(productDAO.getAll().size()==0);
    }

    @Test
    public void testUpdate() throws DBException {

        User user = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        userDAO.create(user);

        Product product = createProduct("Car1", "Very heavy car!", true, "car.jpg", 999.99, user.getUserId());
        productDAO.create(product);

        product.setName("Bentley");
        product.setDescription("Very expensive car!");
        productDAO.update(product);

        Product productFromDB = productDAO.getById(product.getProductID());

        assertEquals(product.getName(), productFromDB.getName());
        assertEquals(product.getDescription(), productFromDB.getDescription());
        assertEquals(product.getOwnerID(), productFromDB.getOwnerID());
    }



    private Product createProduct(String name, String description, boolean status, String image, double price, long ownerID) {

        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setStatus(status);
        product.setImage(image);
        product.setPrice(price);
        product.setOwnerID(ownerID);

        return product;
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

}

