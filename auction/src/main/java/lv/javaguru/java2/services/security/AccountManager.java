package lv.javaguru.java2.services.security;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.LoginException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by Vladislav on 2/28/2015.
 */

@Component
public class AccountManager {
    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    private User getUserFromDB(String login) {
        User user = null;
        try {
            user = userDAO.getByLogin(login);
        } catch (DBException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void authorize(String login, String password, HttpSession session) throws LoginException {
        User user = getUserFromDB(login);
        if (user == null) throw new LoginException("incorrect login");

        if (user.getPassword().equals(password)) {
            session.setAttribute("User", user);
        } else throw new LoginException("incorrect password");
    }

    public boolean isAuthorized(HttpSession session) {
        return (session.getAttribute("User") != null);
    }

    public void logOffUserFromSession(HttpSession session) {
        session.removeAttribute("User");
    }
}
