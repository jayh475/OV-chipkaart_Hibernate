package p6;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Queue;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO {
    private Session session;

    public OVChipkaartDAOHibernate(Session session){
        this.session = session;

    }



    @Override
    @SuppressWarnings("unchecked")
    public List<OVChipkaart> findAll() {
            return (List<OVChipkaart>) session.createQuery("from ov_chipkaart ").list();
    }

    @Override

    public List<OVChipkaart> findByReiziger(Reiziger reizigers) {
        return  (List<OVChipkaart>) session.createQuery( "FROM ov_chipkaart WHERE reiziger = ?1").setParameter(1,reizigers).list();
    }



    @Override
    public void save(OVChipkaart ovChipkaart) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.save(ovChipkaart);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }
    }

    @Override
    public void update(OVChipkaart ovChipkaart) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.update(ovChipkaart);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

    }

    @Override
    public void delete(OVChipkaart ovChipkaart) {
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            session.delete(ovChipkaart);

            tx.commit();
        } catch (RuntimeException e) {
            if (tx != null) tx.rollback();
            throw e;
        }

    }

}
