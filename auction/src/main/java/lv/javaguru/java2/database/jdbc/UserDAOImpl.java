package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    private String INSERT_LINE ="insert into users values (default, ?, ?)";
    private String SELECT_LINE ="select * from users";
    private String UPDATE_LINE ="update users set FirstName = ?, LastName = ? where UserID = ?";
    private String DELETE_LINE ="delete from users where UserID = ?";
    private String SELECT_BY_ID_LINE ="select * from users where UserID = ?";

    @Override
    public void create(User user) throws DBException {
        super.create(user);
    }

    @Override
    public User getById(Long id) throws DBException {
        return super.getById(id);
    }

    @Override
    public void delete(Long id) throws DBException {
        super.delete(id);
    }


    @Override
    public void update(User user) throws DBException {
        super.update(user);
    }

    @Override
    public List<User> getAll() throws DBException {
        return super.getAll();
    }

    @Override
    protected void loadEntitiesToList(ResultSet rs, List<User> entities) throws SQLException {
        while(rs.next()){
            User user = new User();
            user.setUserId(rs.getLong("UserID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            entities.add(user);
        }
    }

    @Override
    protected void setInsertArguments(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
    }

    @Override
    protected void setUpdateArguments(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setLong(3, user.getUserId());
    }

    @Override
    protected User createEntity(ResultSet rs) throws SQLException {
        User user = new User();
        while (rs.next()){
            user.setUserId(rs.getLong("UserID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
        }
        return user;
    }

    @Override
    protected void setId(User user, Long id) {
        user.setUserId(id);
    }

    @Override
    protected String getSelectAllLine() {
        return SELECT_LINE;
    }
    @Override
    protected String getUpdateLine() {
        return UPDATE_LINE;
    }

    @Override
    protected String getCreationLine() {
        return INSERT_LINE;
    }

    @Override
    protected String getByIdLine() {
        return SELECT_BY_ID_LINE;
    }

    @Override
    protected String getDeleteLine() {
        return DELETE_LINE;
    }
}
