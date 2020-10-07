package p6;

import java.util.List;

public interface ProductDAO {
   List<Product> findAll();
   boolean save(Product product);
   boolean update(Product product);
   boolean delete(Product product);
   List<Product> findByOVChipkaart(OVChipkaart ovChipkaart);

}
