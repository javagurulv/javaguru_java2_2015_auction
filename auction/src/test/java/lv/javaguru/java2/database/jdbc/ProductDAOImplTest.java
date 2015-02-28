package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;
import org.junit.*;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vladislav on 2/15/2015.
 */
public class ProductDAOImplTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();
    private ProductDAOImpl productDAO = new ProductDAOImpl();
    private UserDAOImpl userDAO = new UserDAOImpl();



    public static void cleanUp() throws DBException {
        DatabaseCleaner databaseCleaner1 = new DatabaseCleaner();
        databaseCleaner1.cleanDatabase();
    }

    @Before
    @After
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();

    }


    @Test
    public void testCreate() throws DBException {
        User user1 = createUser();
        userDAO.create(user1);
        Product product = createProduct("F", "L", user1.getUserId());

        productDAO.create(product);

        Product productFromDB = productDAO.getById(product.getProductID());
        assertNotNull(productFromDB);
        assertEquals(product.getProductID(), productFromDB.getProductID());
        assertEquals(product.getName(), productFromDB.getName());
        assertEquals(product.getDescription(), productFromDB.getDescription());
        assertEquals(product.getOwnerID(), productFromDB.getOwnerID());

    }

    @Test
    public void testMultipleProductCreation() throws DBException {
        User user1 = createUser();
        userDAO.create(user1);
        Product product1 = createProduct("F1", "L1", user1.getUserId());
        Product product2 = createProduct("F2", "L2", user1.getUserId());
        productDAO.create(product1);
        productDAO.create(product2);
        List<Product> products = productDAO.getAll();
        assertEquals(2, products.size());
    }

    @Test
    public void testGetById() throws DBException {
        User user1 = createUser();
        userDAO.create(user1);
        Product product1 = createProduct("F1", "L1", user1.getUserId());
        productDAO.create(product1);

        Product returnedProduct = productDAO.getById(product1.getProductID());
        assert (product1.getName().equals(returnedProduct.getName()) );
    }

    @Test
    public void testDelete() throws DBException {
        User user1 = createUser();
        userDAO.create(user1);
        Product product = createProduct("F4", "L4", user1.getUserId());
        productDAO.create(product);

        productDAO.delete(product.getProductID());
        assert(productDAO.getAll().size()==0);
    }

    @Test
    public void testUpdate() throws DBException {
        User user1 = createUser();
        userDAO.create(user1);
        Product product1 = createProduct("F1", "L1", user1.getUserId());
        productDAO.create(product1);

        product1.setName("F2");
        product1.setDescription("L2");
        product1.setOwnerID(user1.getUserId());

        productDAO.update(product1);

        assert(product1.getName()=="F2");
        assert(product1.getDescription()=="L2");
        assert(product1.getOwnerID()==user1.getUserId());
    }
    //Feel free to write your own!

    //Customize this one as you like!
    private Product createProduct(String name, String description, long ownerID) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(0);
        product.setImage("root/");
        product.setStatus(true);
        product.setOwnerID(ownerID);

        return product;
    }

    private User createUser() {
        User user = new User();
        user.setFirstName("TestUser");
        user.setLastName("TestUser");
        return user;
    }

}

