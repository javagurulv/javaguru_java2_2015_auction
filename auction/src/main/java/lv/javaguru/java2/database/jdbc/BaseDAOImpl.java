package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.BaseDAO;
import lv.javaguru.java2.database.DBException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by Vladislav on 2/19/2015.
 */
public abstract class BaseDAOImpl<Type> extends DAOImpl implements BaseDAO<Type> {
    @Override
    public void create(Type type) throws DBException {
        if (type == null) return;
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(getCreationLine(), java.sql.Statement.RETURN_GENERATED_KEYS);
            setInsertArguments(statement, type);
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()){
                setId(type, rs.getLong(1));
            }
        } catch (SQLException e) {
            System.out.println("Exception while execute DAOImpl.create()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }



    @Override
    public Type getById(Long id) throws DBException {
        if (id == null) throw new NullPointerException("id can't be null!");
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(getByIdLine());
            statement.setLong(1, id);
            statement.executeQuery();
            ResultSet rs = statement.getResultSet();
            return createEntity(rs);
        } catch (SQLException e) {
            System.out.println("Exception while execute DAOImpl.getById()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public void delete(Long id) throws DBException {
        if (id == null) throw new NullPointerException("id can't be null!");
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(getDeleteLine());
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception while execute DAOImpl.delete()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }

    @Override
    public void update(Type type) throws DBException {
        if (type == null) return;
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement statement = connection.prepareStatement(getUpdateLine());
            setUpdateArguments(statement, type);
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Exception while execute DAOImpl.update()");
            e.printStackTrace();
            throw new DBException(e);
        }
        finally {
            closeConnection(connection);
        }
    }



    @Override
    public List<Type> getAll() throws DBException {
        List<Type> entities = new ArrayList<Type>();
        Connection connection = null;
        try {
            connection = getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(getSelectAllLine());

            ResultSet rs = preparedStatement.executeQuery();
            loadEntitiesToList(rs, entities);
            return entities;
        } catch (Throwable e) {
            System.out.println("Exception while getting customer list UserDAOImpl.getAll()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connection);
        }
    }

    // Abstract method declarations
    protected abstract void loadEntitiesToList(ResultSet rs, List<Type> entities) throws SQLException;

    protected abstract void setInsertArguments(PreparedStatement statement, Type type) throws SQLException;
    protected abstract void setUpdateArguments(PreparedStatement statement, Type type) throws SQLException;

    protected abstract Type createEntity(ResultSet rs) throws SQLException;

    protected abstract void setId(Type type, Long id);

    protected abstract String getSelectAllLine();
    protected abstract String getUpdateLine();
    protected abstract String getCreationLine();
    protected abstract String getByIdLine();
    protected abstract String getDeleteLine();
}
