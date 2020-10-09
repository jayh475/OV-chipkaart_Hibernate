package p6;

import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.transaction.Transactional;
import java.util.List;

public class ProductDaoHibernate implements ProductDAO<Product>{
     private Session session;


    public ProductDaoHibernate(Session session){
        this.session = session;


    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Product> findAll() {
        List<Product> producten = (List<Product>) session.createQuery("from Product").list();
        return producten;

    }

    @Override
    public void save(Product product) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(product);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void update(Product product){
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.update(product);

                tx.commit();
            } catch (RuntimeException e) {
                if (tx != null) tx.rollback();
                throw e;
            }
        }

    @Override
    public void delete(Product product) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(product);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }



}


