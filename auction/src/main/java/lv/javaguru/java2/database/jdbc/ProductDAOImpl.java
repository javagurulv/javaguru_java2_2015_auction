package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 2/15/2015.
 */
public class ProductDAOImpl extends DAOImpl implements ProductDAO {

    @Override
    public void create(Product product) throws DBException {
        if (product==null) return;

        Connection connection= null;
        try {
            connection = getConnection();
            PreparedStatement statement =
                    connection.prepareStatement("INSERT into products values(DEFAULT, ?, ?, ?, ?, ?, ? )", Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBoolean(3, product.getStatus());
            statement.setString(4, product.getImage());
            statement.setDouble(5, product.getPrice());
            statement.setLong(6, product.getOwnerID());
            //statement.setLong(7, product.getCategory().getCategoryId());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()) product.setProductID(rs.getLong(1));
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception while execute ProductDAOImpl.create()");
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public Product getById(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from products where ProductID=?");
            statement.setLong(1, id);
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            Product product = null;
            if (rs.next()){
                product= new Product();
                product.setProductID(rs.getLong("ProductID"));
                product.setName(rs.getString("Name"));
                product.setDescription(rs.getString("Description"));
                product.setOwnerID(rs.getLong("OwnerID"));
                //product.setCategory(new ProductCategory());
                product.setImage(rs.getString("Image"));
                product.setPrice(rs.getDouble("Price"));
                product.setStatus(rs.getBoolean("Status"));

            }
            return product;
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception while execute ProductDAOImpl.getById()");
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long id) throws DBException {
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("delete from products where ProductID=?");
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception while execute ProductDAOImpl.delete()");
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Product product) throws DBException {
        if  (product == null) return;
        Connection connection = null;
        connection = getConnection();
        try {
            PreparedStatement statement =
                    connection.prepareStatement("UPDATE products SET Name = ?, Description = ?," +
                            " Status =?, Image=?, Price=?, OwnerID=? where ProductID = ?");
            statement.setString(1, product.getName());
            statement.setString(2, product.getDescription());
            statement.setBoolean(3, product.getStatus());
            statement.setString(4, product.getImage());
            statement.setDouble(5, product.getPrice());
            statement.setLong(6, product.getOwnerID());
            //statement.setLong(7, product.getCategory().getCategoryId());
            statement.setLong(7, product.getProductID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception while execute ProductDAOImpl.update()");
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public List<Product> getAll() throws DBException {
        Connection connection = null;
        List<Product> products = new ArrayList<Product>();
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * from products");

            ResultSet rs = statement.executeQuery();
            while(rs.next()){
                Product product = new Product();
                product.setProductID(rs.getLong("ProductID"));
                product.setName(rs.getString("Name"));
                product.setDescription(rs.getString("Description"));
                product.setOwnerID(rs.getLong("OwnerID"));
                //product.setCategory(new ProductCategory());
                product.setImage(rs.getString("Image"));
                product.setPrice(rs.getDouble("Price"));
                product.setStatus(rs.getBoolean("Status"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception while execute ProducesDAOImpl.getAll");
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
        return products;
    }

}
