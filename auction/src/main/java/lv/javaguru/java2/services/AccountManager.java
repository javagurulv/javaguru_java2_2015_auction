package lv.javaguru.java2.services;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

/**
 * Created by Vladislav on 2/28/2015.
 */

@Component
public class AccountManager {
    @Autowired
    private UserDAOImpl userDAO;

    private User getValidatedUser(String login, String password) throws LoginException {
        try {
            User user = userDAO.getByLogin(login);
            if (user == null) throw new LoginException("incorrect login");

            if (user.getPassword().equals(password)) return user;
            else throw new LoginException("incorrect password");

        } catch (DBException e) {
            e.printStackTrace();
            throw new LoginException("db exception!");
        }

    }

    public void authorize(String login, String password, HttpSession session) throws LoginException {
            User user = getValidatedUser(login, password);
            session.setAttribute("User", user);
    }

    public boolean isAuthorized(HttpSession session){
        return (session.getAttribute("User")!=null);
    }

    public void logOffUserFromSession(HttpSession session){
        session.removeAttribute("User");
    }
}
