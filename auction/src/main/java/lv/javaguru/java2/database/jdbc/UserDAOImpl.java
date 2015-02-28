package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */
@Component
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {
    private String INSERT_LINE ="insert into users values (default, ?, ?, ?, ?, ?, ?, ?)";
    private String SELECT_LINE ="select * from users";
    private String UPDATE_LINE ="update users set FirstName = ?, LastName = ?, Login = ?, Password = ?, Balance = ?, Email = ?, Avatar = ? where UserID = ?";
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
    public User getByLogin(String login) throws DBException {
        Connection connect = null;

        try {
            connect = getConnection();
            PreparedStatement prepStat = connect.prepareStatement("select * from users where Login = ?");
            prepStat.setString(1, login);
            ResultSet rs = prepStat.executeQuery();
            User user = null;
            if (rs.next()) {
                user = new User();
                user.setUserId(rs.getLong("UserID"));
                user.setFirstName(rs.getString("FirstName"));
                user.setLastName(rs.getString("LastName"));
                user.setLogin(rs.getString("Login"));
                user.setPassword(rs.getString("Password"));
                user.setBalance(rs.getBigDecimal("Balance"));
                user.setEmail(rs.getString("Email"));
                user.setAvatar(rs.getString("Avatar"));
            }
            return user;
        } catch (Throwable e) {
            System.out.println("Exception while execute UserDAOImpl.getByLogin()");
            e.printStackTrace();
            throw new DBException(e);
        } finally {
            closeConnection(connect);
        }
    }



    @Override
    protected void loadEntitiesToList(ResultSet rs, List<User> entities) throws SQLException {
        while(rs.next()){
            User user = new User();
            user.setUserId(rs.getLong("UserID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            user.setLogin(rs.getString("Login"));
            user.setPassword(rs.getString("Password"));
            user.setBalance(rs.getBigDecimal("Balance"));
            user.setEmail(rs.getString("Email"));
            user.setAvatar(rs.getString("Avatar"));
            entities.add(user);
        }
    }

    @Override
    protected void setInsertArguments(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getLogin());
        statement.setString(4, user.getPassword());
        statement.setBigDecimal(5, user.getBalance());
        statement.setString(6, user.getEmail());
        statement.setString(7, user.getAvatar());
    }

    @Override
    protected void setUpdateArguments(PreparedStatement statement, User user) throws SQLException {
        statement.setString(1, user.getFirstName());
        statement.setString(2, user.getLastName());
        statement.setString(3, user.getLogin());
        statement.setString(4, user.getPassword());
        statement.setBigDecimal(5, user.getBalance());
        statement.setString(6, user.getEmail());
        statement.setString(7, user.getAvatar());
        statement.setLong(8, user.getUserId());

    }

    @Override
    protected User createEntity(ResultSet rs) throws SQLException {
        User user = new User();
        while (rs.next()){
            user.setUserId(rs.getLong("UserID"));
            user.setFirstName(rs.getString("FirstName"));
            user.setLastName(rs.getString("LastName"));
            user.setLogin(rs.getString("Login"));
            user.setPassword(rs.getString("Password"));
            user.setBalance(rs.getBigDecimal("Balance"));
            user.setEmail(rs.getString("Email"));
            user.setAvatar(rs.getString("Avatar"));

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
