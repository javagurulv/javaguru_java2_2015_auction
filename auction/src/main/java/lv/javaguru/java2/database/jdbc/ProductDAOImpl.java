package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ObjectDAO;
import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Vladislav on 2/15/2015.
 */
public class ProductDAOImpl extends DAOImpl implements ObjectDAO {
    @Override
    public void create(User user) throws DBException {

    }

    @Override
    public User getById(Long id) throws DBException {
        return null;
    }

    @Override
    public void delete(Long id) throws DBException {

    }

    @Override
    public void update(User user) throws DBException {

    }

    @Override
    public List<User> getAll() throws DBException {
        return null;
    }
}
