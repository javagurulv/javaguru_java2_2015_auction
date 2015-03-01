package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Viktor on 01/07/2014.
 */

public interface UserDAO {

    public void create(User user) throws DBException;

    public User getById(Long id) throws DBException;

    public void delete(Long id) throws DBException;

    public void update(User user) throws DBException;

    public List<User> getAll() throws DBException;

    public User getByLogin(String login) throws DBException;

}
