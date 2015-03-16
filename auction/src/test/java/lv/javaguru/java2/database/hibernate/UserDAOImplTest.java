package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DatabaseCleaner;
import lv.javaguru.java2.domain.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by papa on 15.3.3.
 */
public class UserDAOImplTest extends SpringIntegrationTest{
    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    private DatabaseCleaner databaseCleaner = new DatabaseCleaner();

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
