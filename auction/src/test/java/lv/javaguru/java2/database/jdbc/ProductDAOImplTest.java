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
        Product product = createProduct("F", "L", 1);

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
        Product product1 = createProduct("F1", "L1", 1);
        Product product2 = createProduct("F2", "L2", 2);
        productDAO.create(product1);
        productDAO.create(product2);
        List<Product> products = productDAO.getAll();
        assertEquals(2, products.size());
    }

    @Test
    public void testGetById() throws DBException {
        Product product1 = createProduct("F1", "L1", 1);
        productDAO.create(product1);

        Product returnedProduct = productDAO.getById(product1.getProductID());
        assert (product1.getName().equals(returnedProduct.getName()) );
    }

    @Test
    public void testDelete() throws DBException {
        Product product = createProduct("F4", "L4", 4);
        productDAO.create(product);

        productDAO.delete(product.getProductID());
        assert(productDAO.getAll().size()==0);
    }

    @Test
    public void testUpdate() throws DBException {
        Product product1 = createProduct("F1", "L1", 1);
        productDAO.create(product1);

        product1.setName("F2");
        product1.setDescription("L2");
        product1.setOwnerID(2);

        productDAO.update(product1);

        assert(product1.getName()=="F2");
        assert(product1.getDescription()=="L2");
        assert(product1.getOwnerID()==2);
    }
    //Feel free to write your own!

    //Customize this one as you like!
    private Product createProduct(String name, String description, long id) {
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(25.5);
        product.setImage("root/");
        product.setStatus(true);
        product.setOwnerID(id);

        return product;
    }

}

