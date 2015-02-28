package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */

public interface UserDAO {
//Unique User class method signatures


    public void create(User user) throws DBException;

    User getByLogin(String login) throws DBException;
}
