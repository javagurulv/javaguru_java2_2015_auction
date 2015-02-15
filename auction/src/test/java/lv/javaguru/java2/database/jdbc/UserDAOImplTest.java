package lv.javaguru.java2.database.jdbc;

import static org.junit.Assert.*;

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
        User user = createUser("F", "L");

        userDAO.create(user);

        User userFromDB = userDAO.getById(user.getUserId());
        assertNotNull(userFromDB);
        assertEquals(user.getUserId(), userFromDB.getUserId());
        assertEquals(user.getFirstName(), userFromDB.getFirstName());
        assertEquals(user.getLastName(), userFromDB.getLastName());
    }

    @Test
    public void testMultipleUserCreation() throws DBException {
        User user1 = createUser("F1", "L1");
        User user2 = createUser("F2", "L2");
        userDAO.create(user1);
        userDAO.create(user2);
        List<User> users = userDAO.getAll();
        assertEquals(2, users.size());
    }

    @Test
    public void testGetById() throws DBException {
        User user1 = createUser("F1", "L1");
        userDAO.create(user1);

        User returnedUser = userDAO.getById(user1.getUserId());
        assert (user1.getFirstName().equals(returnedUser.getFirstName()) );
    }

    @Test
    public void testDelete() throws DBException {
        User user = createUser("F4", "L4");
        userDAO.create(user);

        userDAO.delete(user.getUserId());
        assert(userDAO.getAll().size()==0);
    }

    @Test
    public void testUpdate() throws DBException {
        User user1 = createUser("F1", "L1");
        userDAO.create(user1);

        user1.setFirstName("F2");
        user1.setLastName("L2");

        userDAO.update(user1);

        assert(user1.getFirstName()=="F2");
        assert(user1.getLastName()=="L2");
    }

    private User createUser(String firstName, String lastName) {
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return user;
    }

}
