package lv.javaguru.java2.database.jdbc;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.User;


public class UserDAOImplTest {

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

    private UserDAOImpl userDAO = new UserDAOImpl();


    @Before
    @After
    public void init() throws DBException {
        databaseCleaner.cleanDatabase();
    }

    @Test
    public void testCreate() throws DBException {
        User user = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");

        userDAO.create(user);

        User userFromDB = userDAO.getById(user.getUserId());
        assertNotNull(userFromDB);
        assertEquals(user.getUserId(), userFromDB.getUserId());
        assertEquals(user.getFirstName(), userFromDB.getFirstName());
        assertEquals(user.getLastName(), userFromDB.getLastName());
        assertEquals(user.getLogin(), userFromDB.getLogin());
        assertEquals(user.getPassword(), userFromDB.getPassword());
        assertEquals(user.getBalance(), userFromDB.getBalance());
        assertEquals(user.getEmail(), userFromDB.getEmail());
        assertEquals(user.getAvatar(), userFromDB.getAvatar());
    }

    @Test
    public void testMultipleUserCreation() throws DBException {
        User user1 = createUser("Login1", "password1", "test1@test.lv");
        User user2 = createUser("Login2", "password2", "test2@test.lv");

        userDAO.create(user1);
        userDAO.create(user2);
        List<User> users = userDAO.getAll();
        assertEquals(2, users.size());

    }

    @Test
    public void testGetById() throws DBException {
        User user1 = createUser("F", "L", "Login","pass", new BigDecimal("155.55"), "test@test.lv", "avatar.img");
        userDAO.create(user1);

        User returnedUser = userDAO.getById(user1.getUserId());
        assert (user1.getFirstName().equals(returnedUser.getFirstName()) );
    }

    @Test
    public void testDelete() throws DBException {
        User user = createUser("Login", "password", "test@test.lv");
        userDAO.create(user);

        userDAO.delete(user.getUserId());
        assert(userDAO.getAll().size()==0);
    }

    @Test
    public void testUpdate() throws DBException {
        User user1 = createUser("Login", "password", "test@test.lv");
        userDAO.create(user1);

        user1.setFirstName("F2");
        user1.setLastName("L2");
        user1.setLogin("Login2");
        user1.setPassword("pass2");
        user1.setBalance(new BigDecimal("99.99"));
        user1.setEmail("test2@test2.lv");
        user1.setAvatar("avatar2.img");
        userDAO.update(user1);


        User userFromDB = userDAO.getById(user1.getUserId());

        assertEquals(user1.getFirstName(), userFromDB.getFirstName());
        assertEquals(user1.getLastName(), userFromDB.getLastName());
    }

    private User createUser(String firstName, String lastName, String login, String password,
                            BigDecimal balance, String email, String avatar) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setLogin(login);
        user.setPassword(password);
        user.setBalance(balance);
        user.setEmail(email);
        user.setAvatar(avatar);

        return user;
    }
    private User createUser(String login, String password, String email){

        User user = new User();
        user.setFirstName("F1");
        user.setLastName("L1");
        user.setLogin(login);
        user.setPassword(password);
        user.setBalance(new BigDecimal(255));
        user.setEmail(email);
        user.setAvatar("/path");

        return user;
    }

}