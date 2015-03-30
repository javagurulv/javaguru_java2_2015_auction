package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Vladislav on 2/15/2015.
 */
public interface ProductDAO extends BaseDAO<Product> {
//Unique User class method signatures
    public Long getProductCountInCategory(ProductCategory category);
    public Long getActiveProductCountInCategory(ProductCategory category);
    public List<Product> getProductsInCategory(ProductCategory category);
    public List<Product> getByUser(User user);

    public Product getWithUserById(Long id) throws DBException;

}
