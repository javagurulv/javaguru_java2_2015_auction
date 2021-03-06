package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ProductCategory;
import lv.javaguru.java2.domain.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vladislav on 3/10/2015.
 */
@Component("ORM_ProductDAO")
@Transactional
public class ProductDAOImpl implements ProductDAO {

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public void create(Product product) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(product);
    }

    @Override
    public Product getWithUserById(Long id) throws DBException{
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product) session.get(Product.class, id);
        product.getUser().getLogin();
        return product;
    }

    @Override
    public Product getById(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return (Product) session.get(Product.class, id);

    }

    @Override
    public void delete(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        Product product = (Product)session.get(Product.class, id);
        session.delete(product);
    }

    @Override
    public void update(Product product) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(product);
    }

    @Override
    public List<Product> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Product.class).list();
    }

    @Override
    public List<Product> getProductsInCategory(ProductCategory category) {
        Session session = sessionFactory.getCurrentSession();

        return  session.createCriteria(Product.class)
                .add(Restrictions.eq("category", category)).list();
    }

    @Override
    public Long getProductCountInCategory(ProductCategory category) {
        Session session = sessionFactory.getCurrentSession();
        return (Long)session.createCriteria(Product.class)
                .add(Restrictions.eq("category", category))
                .setProjection(Projections.rowCount()).uniqueResult();

    }


    @Override
    public Long getActiveProductCountInCategory(ProductCategory category) {
        Session session = sessionFactory.getCurrentSession();
        return (Long)session.createCriteria(Product.class)
                .add(Restrictions.eq("category", category))
                .add(Restrictions.eq("status", true))
                .setProjection(Projections.rowCount()).uniqueResult();
    }

    @Override
    public List<Product> getByUser(User user) {
        Session session = sessionFactory.getCurrentSession();

        return session.createCriteria(Product.class).add(Restrictions.eq("user", user)).list();
    }
}
