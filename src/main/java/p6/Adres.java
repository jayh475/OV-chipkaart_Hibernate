package p6;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "adres")

public class Adres {
    @Id
    @Column(name = "adres_id")
    private int id;
    private String postcode;
    private String huisnummer;
    private String straat;
    private String woonplaats;
    @OneToOne
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;

    public String toString() {
        return String.format("Reiziger {#%s %s.%s %s, geb. %s, Adres {#%s %s %s %s %s}}", reiziger.getId(),
                reiziger.getVoorletters(), reiziger.getTussenvoegsel(), reiziger.getAchternaam(), reiziger.getGeboortedatum(), id, postcode, straat, huisnummer, woonplaats);
    }

    public String getAdres() {
        return String.format(" Adres {#%s %s %s %s %s}", id, postcode, straat, huisnummer, woonplaats);

    }

}

