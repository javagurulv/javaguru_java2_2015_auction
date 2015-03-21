package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductCategoryDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 3/6/2015.
 */
@Component("ORM_ProductCategoryDAO")
@Transactional
public class ProductCategoryDAOImpl implements ProductCategoryDAO {
    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void create(ProductCategory productCategory) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(productCategory);
    }

    @Override
    public ProductCategory getById(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (ProductCategory) session.get(ProductCategory.class, id);
    }

    @Override
    public void delete(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        ProductCategory productCategory = (ProductCategory) session.get(ProductCategory.class, id);
        session.delete(productCategory);
    }

    @Override
    public void update(ProductCategory productCategory) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(productCategory);
    }

    @Override
    public List<ProductCategory> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(ProductCategory.class).list();
    }

    @Override
    public ProductCategory getByName(String categoryName) {
        Session session = sessionFactory.getCurrentSession();
        return (ProductCategory)session
                .createCriteria(ProductCategory.class)
                .add(Restrictions.eq("name", categoryName)).uniqueResult();
    }
}