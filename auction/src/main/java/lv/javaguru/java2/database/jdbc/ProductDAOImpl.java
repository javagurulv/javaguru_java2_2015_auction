package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Vladislav on 2/15/2015.
 */
public class ProductDAOImpl extends DAOImpl implements ProductDAO {

    @Override
    public void create(Product product) throws DBException {

    }

    @Override
    public Product getById(Long id) throws DBException {
        return null;
    }

    @Override
    public void delete(Long id) throws DBException {

    }

    @Override
    public void update(Product product) throws DBException {

    }

    @Override
    public List<Product> getAll() throws DBException {
        return null;
    }
}
