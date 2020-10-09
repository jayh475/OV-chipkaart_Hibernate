package p6;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "reiziger")
public class Reiziger {
    @Id
    @Column(name = "reiziger_id")
    private int id;
    private String voorletters;
    private String tussenvoegsel;
    private String achternaam;
    private Date geboortedatum;
//    @Transient

//cascade = CascadeType.ALL
    @OneToMany(mappedBy = "reiziger")
    private List<OVChipkaart> mijnOVChipkaarten = new ArrayList();

    @OneToOne(mappedBy = "reiziger")
    private Adres adres;

    public Reiziger(){}
    public Reiziger(Adres adres, int id, String voorletters, String tussenvoegsel, String achternaam, Date geboortedatum) {
        this.adres = adres;
        this.id = id;
        this.voorletters = voorletters;
        this.tussenvoegsel = tussenvoegsel;
        this.achternaam = achternaam;
        this.geboortedatum = geboortedatum;

    }

    public Adres getAdres() {
        return adres;
    }

    public void setAdres(Adres adres) {
        this.adres = adres;

    }


    public void setVoorletters(String voorletters) {
        this.voorletters = voorletters;
    }

    public void setTussenvoegsel(String tussenvoegsel) {
        this.tussenvoegsel = tussenvoegsel;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public void setGeboortedatum(Date geboortedatum) {
        this.geboortedatum = geboortedatum;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVoorletters() {
        return voorletters;
    }

    public String getTussenvoegsel() {
        return tussenvoegsel;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public Date getGeboortedatum() {
        return geboortedatum;
    }

    public String getNaam() {
        return String.format("%s. %s %s", voorletters, tussenvoegsel, achternaam);
    }


    public List<OVChipkaart> getMijnOVChipkaarten() {
        return mijnOVChipkaarten;
    }

    public void setMijnOVChipkaarten(List<OVChipkaart> mijnOVChipkaarten) {
        this.mijnOVChipkaarten = mijnOVChipkaarten;
    }


    public String toString() {
        String s = String.format("{#%s. %s %s, geb. %s,%s} %s", id,
                voorletters, tussenvoegsel, achternaam, geboortedatum, (this.adres == null) ? "" : adres.getAdres());


        for (OVChipkaart ov : mijnOVChipkaarten) {
            s += ov;

        }
        return s;

    }
}




