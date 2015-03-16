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
    List<Product> getByCategory(ProductCategory category);
    List<Product> getByUser(User user);
}
