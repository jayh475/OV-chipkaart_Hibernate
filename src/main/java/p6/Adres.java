package p6;





import javax.persistence.*;




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

    public Adres(){}

    public Adres(Reiziger reiziger,int id, String postcode,String huisnummer,String straat,String woonplaats){
        this.reiziger =reiziger;
        this.id = id;
        this.postcode =postcode;
        this.huisnummer =huisnummer;
        this.straat= straat;
        this.woonplaats = woonplaats;
    }



    public String toString() {
        return String.format("Reiziger {#%s %s.%s %s, geb. %s, Adres {#%s %s %s %s %s}}", reiziger.getId(),
                reiziger.getVoorletters(), reiziger.getTussenvoegsel(), reiziger.getAchternaam(), reiziger.getGeboortedatum(), id, postcode, straat, huisnummer, woonplaats);
    }

    public String getAdres() {
        return String.format(" Adres {#%s %s %s %s %s}", id, postcode, straat, huisnummer, woonplaats);

    }


    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public void setHuisnummer(String huisnummer) {
        this.huisnummer = huisnummer;
    }

    public void setStraat(String straat) {
        this.straat = straat;
    }

    public void setWoonplaats(String woonplaats) {
        this.woonplaats = woonplaats;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }
}

