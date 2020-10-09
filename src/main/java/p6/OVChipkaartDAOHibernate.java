package p6;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;


import java.util.List;

public class OVChipkaartDAOHibernate implements OVChipkaartDAO {
    private Session session;

    public OVChipkaartDAOHibernate(Session session){
        this.session = session;

    }



    @Override
    @SuppressWarnings("unchecked")
    public List<OVChipkaart> findAll() {
            return (List<OVChipkaart>) session.createQuery("from OVChipkaart ").list();
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<OVChipkaart> findByReiziger(Reiziger reiziger) {
        Criteria criteria = session.createCriteria(OVChipkaart.class);
        return criteria.add(Restrictions.eq("reiziger_id", reiziger.getId())).list();
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

    @Override
    @SuppressWarnings("unchecked")
    public List<OVChipkaart> findByProduct(Product product) {
        Criteria criteria = session.createCriteria(OVChipkaart.class);
        return criteria.add(Restrictions.eq("", product.getProduct_nummer())).list();
return null

    }
}
