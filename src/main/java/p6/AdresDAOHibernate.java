package p6;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class AdresDAOHibernate implements AdresDAO {
    private Session session;

    public AdresDAOHibernate(Session session) {
        this.session = session;
    }

    @Override
    public void save(Adres adres) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(adres);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

    }

    @Override
    public void update(Adres adres) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(adres);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void delete(Adres adres) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(adres);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Adres findByReiziger(Reiziger reiziger) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Adres adres = session.get(Adres.class,reiziger.getId() );
            Hibernate.initialize(adres);
            tx.commit();
            return adres;

        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
        }


    @Override
    public List<Adres> findAll() {
        return null;
    }
}
