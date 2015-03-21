package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Denis on 18-Feb-15.
 */
public class ProductCategoryDAOImpl extends DAOImpl implements ProductCategoryDAO {

    @Override
    public void create(ProductCategory productCategory) throws DBException {
        if (productCategory == null) {
            return;
        }

        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement("insert into categories values (default, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, productCategory.getName());

            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getGeneratedKeys();
            if (rs.next()){
                productCategory.setCategoryId(rs.getLong(1));
            }
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductCategoryDAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public ProductCategory getById(Long id) throws DBException {
        Connection connection = null;

        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("select * from categories where CategoryID = ?");
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            ProductCategory productCategory = null;
            if (resultSet.next()) {
                productCategory = new ProductCategory();
                productCategory.setCategoryId(resultSet.getLong("CategoryID"));
                productCategory.setName(resultSet.getString("Name"));
            }
            return productCategory;
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductCategoryDAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("delete from categories where CategoryID = ?");
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute ProductCategoryDAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public void update(ProductCategory productCategory) throws DBException {
        if (productCategory == null) {
            return;
        }

        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection
                    .prepareStatement("update categories set Name = ?" +
                            "where CategoryID = ?");
            preparedStatement.setString(1, productCategory.getName());
            preparedStatement.setLong(2, productCategory.getCategoryId());
            preparedStatement.executeUpdate();
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }

    }

    @Override
    public List<ProductCategory> getAll() throws DBException {
        List<ProductCategory> productsCategory = new ArrayList<ProductCategory>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("select * from categories");

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                ProductCategory productCategory = new ProductCategory();
                productCategory.setCategoryId(resultSet.getLong("CategoryID"));
                productCategory.setName(resultSet.getString("Name"));
                productsCategory.add(productCategory);
            }
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list ProductCategoryDAOImpl.getList()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
        return productsCategory;

    }

    @Override
    public ProductCategory getByName(String categoryName) {
        return null;
    }
}

