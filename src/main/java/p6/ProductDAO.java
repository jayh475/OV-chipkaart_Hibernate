package p6;

import java.util.List;

public interface ProductDAO<T> {
   List<Product> findAll();
   void save(Product product);
   void update(Product product);
   void delete(Product product);
//   List<Product> findByOVChipkaart(OVChipkaart ovChipkaart);

}
