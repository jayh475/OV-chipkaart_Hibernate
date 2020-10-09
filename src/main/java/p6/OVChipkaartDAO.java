package p6;

import java.util.List;

public interface OVChipkaartDAO {

    List<OVChipkaart> findAll();

    List<OVChipkaart> findByReiziger(Reiziger reiziger);

    void save(OVChipkaart ovChipkaart);

    void update(OVChipkaart ovChipkaart);

    void delete(OVChipkaart ovChipkaart);

    List<OVChipkaart> findByProduct(Product product);

}
