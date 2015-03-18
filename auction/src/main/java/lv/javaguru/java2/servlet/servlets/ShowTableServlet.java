package lv.javaguru.java2.servlet.servlets;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Vladislav on 2/10/2015.
 */
public class ShowTableServlet extends HttpServlet {
    // This is my example of using servlet to show some stuff in browser!
    // By Vladislav
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set response content type
        resp.setContentType("text/html");

        UserDAOImpl userDao = new UserDAOImpl();
        try {
            List<User> users = userDao.getAll();
            PrintWriter out = resp.getWriter();
            out.println("<h1> Users </h1>");
            for (User user: users){
                 // Prepare output html
                out.println("<p>" + user.getFirstName()+' '+user.getLastName() + "</p>");
            }
        } catch (DBException e) {
            e.printStackTrace();
        }

    }
}
