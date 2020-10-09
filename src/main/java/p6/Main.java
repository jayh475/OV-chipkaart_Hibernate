package p6;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.metamodel.EntityType;
import javax.persistence.metamodel.Metamodel;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * Testklasse - deze klasse test alle andere klassen in deze package.
 * <p>
 * System.out.println() is alleen in deze klasse toegestaan (behalve voor exceptions).
 *
 * @author tijmen.muller@hu.nl
 */
public class Main {
    // Creëer een factory voor Hibernate sessions.
    private static final SessionFactory factory;

    static {
        try {
            // Create a Hibernate session factory
            factory = new Configuration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * Retouneer een Hibernate session.
     *
     * @return Hibernate session
     * @throws HibernateException
     */
    private static Session getSession() throws HibernateException {
        return factory.openSession();
    }

    public static void main(String[] args) throws SQLException {
        Session session = getSession();
        ProductDaoHibernate productDaoHibernate = new ProductDaoHibernate(session);
        ReizigerDaoHibernate reizigerDaoHibernate = new ReizigerDaoHibernate(session);
        OVChipkaartDAOHibernate ovChipkaartDAOHibernate = new OVChipkaartDAOHibernate(session);
        AdresDAOHibernate adresDAOHibernate = new AdresDAOHibernate(session);
        testDAOHibernate(productDaoHibernate,reizigerDaoHibernate,ovChipkaartDAOHibernate,adresDAOHibernate);


//        testFetchAll();


    }

    /**
     * P6. Haal alle (geannoteerde) entiteiten uit de database.
     */
    private static void testFetchAll() {
        Session session = getSession();
        try {
            Metamodel metamodel = session.getSessionFactory().getMetamodel();
            for (EntityType<?> entityType : metamodel.getEntities()) {
                Query query = session.createQuery("from " + entityType.getName());

                System.out.println("[Test] Alle objecten van type " + entityType.getName() + " uit database:");
                for (Object o : query.list()) {
                    System.out.println("  " + o);
                }
                System.out.println();
            }
        } finally {
            session.close();
        }
    }

    private static void testDAOHibernate(ProductDaoHibernate productDaoHibernate, ReizigerDaoHibernate reizigerDaoHibernate,OVChipkaartDAOHibernate ovChipkaartDAOHibernate,AdresDAOHibernate adresDAOHibernate) {
        System.out.println("Test alle reizigers");
        for(Reiziger reiziger : reizigerDaoHibernate.findAll()){
            System.out.println(reiziger);
        }
        System.out.println("save reizigers");
         int id = 18;
         String voorletters = "h.k";
         String tussenvoegsel = "de";
         String achternaam = "jansen";
         String geboortedatum = "1998-11-24";

        Reiziger reiziger = new Reiziger(null ,id,voorletters,tussenvoegsel,achternaam ,Date.valueOf(geboortedatum));
        reizigerDaoHibernate.save(reiziger);
        System.out.println(reizigerDaoHibernate.findAll().size());

        System.out.println("update reiziger  and find by id ");
        reiziger.setTussenvoegsel("van");
        reizigerDaoHibernate.update(reiziger);

        System.out.println(reizigerDaoHibernate.findById(reiziger.getId()));

        System.out.println("find reiziger by geboortedatum");
        for(Reiziger reiziger1 : reizigerDaoHibernate.findByGbdatum(geboortedatum)){
            System.out.println(reiziger1);
        }

        System.out.println("delete reiziger");
        reizigerDaoHibernate.delete(reiziger);
        System.out.println(reizigerDaoHibernate.findAll().size());




        System.out.println("-----------------------------------------------------");


        System.out.println("Test alle producten ");
        System.out.println(productDaoHibernate.findAll().size());
        for (Product product : productDaoHibernate.findAll()) {
            System.out.println(product);
        }

        System.out.println("test save product");
        int product_nummer = 8;
        String naam = "vrijkaart";
        String beschrijving = "vrijkaart voor een hele week";
        double prijs = 40;
        Product product = new Product(product_nummer, naam, beschrijving, prijs);
        productDaoHibernate.save(product);
        System.out.println(productDaoHibernate.findAll().size());
        for (Product product3 : productDaoHibernate.findAll()) {
            System.out.println(product3);
        }

        System.out.println("update product");
        product.setBeschrijving("vrijkaart voor 4 weken");
        productDaoHibernate.update(product);



        System.out.println("delete product");
        productDaoHibernate.delete(product);
        System.out.println(productDaoHibernate.findAll().size());



        System.out.println("-----------------------------------------------------");
        System.out.println("Test alle ov chipkaarten ");
        System.out.println(ovChipkaartDAOHibernate.findAll().size());
        for(OVChipkaart ovChipkaart : ovChipkaartDAOHibernate.findAll()){
            System.out.println(ovChipkaart);
        }
        System.out.println("test save OV CHIPKAART");
        String geboortedatum1 = "1998-11-24";
        Reiziger sietske = new Reiziger(null, 78, "S", "", "koopman", Date.valueOf(geboortedatum1));
        OVChipkaart sietskesov = new OVChipkaart(13893, Date.valueOf("2021-11-25"), 2, 14, sietske);
        ovChipkaartDAOHibernate.save(sietskesov);
        System.out.println(ovChipkaartDAOHibernate.findAll().size());

        System.out.println("update ov chipkaart and find by reiziger");
        sietskesov.setKlasse(1);
        ovChipkaartDAOHibernate.update(sietskesov);
        System.out.println(ovChipkaartDAOHibernate.findByReiziger(sietske));

        System.out.println("delete ov chipkaaart");
        ovChipkaartDAOHibernate.delete(sietskesov);
        reizigerDaoHibernate.delete(sietske);
        System.out.println(ovChipkaartDAOHibernate.findAll().size());




        System.out.println("-------------------------------------------------");
        System.out.println("alle adressen");
        System.out.println(adresDAOHibernate.findAll().size());
        for(Adres adres: adresDAOHibernate.findAll()){
            System.out.println(adres);
        }

        System.out.println("save adres");
        String gbdatum = "1981-03-14";
        Reiziger sietske1 = new Reiziger(null, 79, "S", "", "doei", Date.valueOf(gbdatum));
        reizigerDaoHibernate.save(sietske);
        Adres a1 = new Adres(sietske1, 18, "3812HT", "8", "hoera", "Amersfoort");
        adresDAOHibernate.save(a1);
        System.out.println("aantal na save: "+ adresDAOHibernate.findAll().size());

        System.out.println("update adres and find by Reiziger");
        a1.setHuisnummer("9");
        adresDAOHibernate.update(a1);
        System.out.println(adresDAOHibernate.findByReiziger(sietske1));

        System.out.println("delete adress");
        adresDAOHibernate.delete(a1);
        reizigerDaoHibernate.delete(sietske1);
        System.out.println(adresDAOHibernate.findAll().size());



    }




}

