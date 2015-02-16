package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vladislav on 2/15/2015.
 */
public class ProductDAOImplTest {
    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private ProductDAOImpl productDAO = new ProductDAOImpl();


    @Before
    @After
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        Product product = createProduct("F", "L");

        productDAO.create(product);

        Product productFromDB = productDAO.getById(product.getProductID());
        assertNotNull(productFromDB);
        assertEquals(product.getProductID(), productFromDB.getProductID());
        assertEquals(product.getName(), productFromDB.getName());
        assertEquals(product.getDescription(), productFromDB.getDescription());

    }

    @Test
    public void testMultipleProductCreation() throws DBException {
    }

    @Test
    public void testGetById() throws DBException {
    }

    @Test
    public void testDelete() throws DBException {
    }

    @Test
    public void testUpdate() throws DBException {
    }
    //Feel free to write your own!

    //Customize this one as you like!
    private Product createProduct(String name, String description) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        return product;
    }

}

