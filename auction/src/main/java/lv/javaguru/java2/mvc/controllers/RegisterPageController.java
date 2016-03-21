package lv.javaguru.java2.mvc.controllers;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.math.BigDecimal;

/**
 * Created by Denis on 18-Feb-15.
 */
@Controller
public class RegisterPageController {
    @Autowired
    @Qualifier("ORM_UserDAO")
    private UserDAO userDAO;

    @RequestMapping(value = "register", method = {RequestMethod.GET, RequestMethod.POST})
    public ModelAndView processRequest(HttpServletRequest request, HttpServletResponse response) {


        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");


        if (request.getMethod().equals("POST")) {

            User user = createUser(request.getParameter("firstName"),
                                   request.getParameter("lastName"),
                                   request.getParameter("login"),
                                   request.getParameter("password"),
                                   new BigDecimal("0.00"),
                                   request.getParameter("email"),
                                   request.getParameter("avatar"));

            if(checkFields(user)) return modelAndView.addObject("model", "Заполните все поля!");


            if (checkIfUserExists(user)) {
                    try {
                        userDAO.create(user);
                    } catch (DBException e) {
                        e.printStackTrace();
                        return modelAndView.addObject("model","Something gone wrong with DB.");
                    }

                } else {
                    return modelAndView.addObject("model", "Такой пользователь уже есть!");
                }

        }

        modelAndView.addObject("model", null);
        return modelAndView;
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