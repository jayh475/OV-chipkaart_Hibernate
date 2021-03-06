package p6;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.sql.Date;
import java.util.List;

public class ReizigerDaoHibernate implements ReizigerDAO<Reiziger> {
    Session session;

    ReizigerDaoHibernate(Session session) {
        this.session = session;

    }

    @Override
    public void save(Reiziger reiziger)  {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(reiziger);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void update(Reiziger reiziger) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(reiziger);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }


    @Override
    public void delete(Reiziger reiziger) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(reiziger);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public Reiziger findById(int id) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Reiziger reiziger = session.get(Reiziger.class, id);
            Hibernate.initialize(reiziger);
            tx.commit();
            return reiziger;

        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }


    @Override
    @SuppressWarnings("unchecked")
    public List<Reiziger> findByGbdatum(String datum) {
        Criteria criteria = session.createCriteria(Reiziger.class);
        return criteria.add(Restrictions.eq("geboortedatum", Date.valueOf(datum))).list();

    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Reiziger> findAll() {
        return (List<Reiziger>) session.createQuery("from Reiziger ").list();
    }


}
