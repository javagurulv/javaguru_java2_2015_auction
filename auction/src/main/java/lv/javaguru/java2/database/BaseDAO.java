package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.User;

import java.util.List;

/**
 * Created by Vladislav on 2/16/2015.
 */
public interface BaseDAO<Type> {

    void create(Type type) throws DBException;

    Type getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(Type type) throws DBException;

    List<Type> getAll() throws DBException;

}
