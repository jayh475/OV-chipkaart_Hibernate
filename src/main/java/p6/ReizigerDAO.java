package p6;

import java.sql.SQLException;
import java.util.List;

public interface ReizigerDAO<T> {

    void save(Reiziger reiziger) throws SQLException;
   void update(Reiziger reiziger);
   void delete(Reiziger reiziger);
   Reiziger findById(int id);
   List<Reiziger> findByGbdatum(String datum);
   List<Reiziger> findAll();





}
