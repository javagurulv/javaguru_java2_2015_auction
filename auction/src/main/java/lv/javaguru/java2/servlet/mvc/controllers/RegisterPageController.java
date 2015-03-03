package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.MVCController;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import java.math.BigDecimal;

/**
 * Created by Denis on 18-Feb-15.
 */
@Component
public class RegisterPageController implements MVCController {
    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @Override
    public MVCModel processRequest(HttpServletRequest request, HttpServletResponse response) {




        if (request.getMethod().equals("POST")) {

            User user = createUser(request.getParameter("firstName"),
                                   request.getParameter("lastName"),
                                   request.getParameter("login"),
                                   request.getParameter("password"),
                                   new BigDecimal("0.00"),
                                   request.getParameter("email"),
                                   request.getParameter("avatar"));

            if(checkFields(user)) return new MVCModel("/jsp/register.jsp", "Заполните все поля!");


            if (checkIfUserExists(user)) {
                    try {
                        userDAO.create(user);
                    } catch (DBException e) {
                        e.printStackTrace();
                        return new MVCModel("/register.jsp", "Something gone wrong with DB.");
                    }

                } else {
                    return new MVCModel("/jsp/register.jsp", "Такой пользователь уже есть!");
                }

        }


        return new MVCModel("/jsp/register.jsp", null);
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


    private boolean checkFields(User user) {
        return (user.getFirstName().isEmpty()
                || user.getLastName().isEmpty()
                || user.getLogin().isEmpty()
                || user.getPassword().isEmpty()
                || user.getEmail().isEmpty());
    }


    private boolean checkIfUserExists(User user) {

        User testUser = null;
        try {
            testUser = userDAO.getByLogin(user.getLogin());
        } catch (DBException e) {
            e.printStackTrace();
        }

        if (testUser == null) return true; else return false;
    }

}