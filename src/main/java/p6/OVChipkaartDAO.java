package p6;

import java.util.List;

public interface OVChipkaartDAO {

    List<OVChipkaart> findAll();
    List<OVChipkaart> findByReiziger(Reiziger reiziger);
    boolean save(OVChipkaart ovChipkaart);
    boolean update(OVChipkaart ovChipkaart);
    boolean delete(OVChipkaart ovChipkaart);
    List<OVChipkaart>findByProduct(Product product);

}
