package p6;

import javax.persistence.*;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "ov_chipkaart")
//@Table()
public class OVChipkaart {

    @Id
    private int kaart_nummer;
    private Date geldig_tot;
    //    @Transient

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name = "ov_chipkaart_product",
            joinColumns = {@JoinColumn(name = "kaart_nummer")},
            inverseJoinColumns = {@JoinColumn(name = "product_nummer")}
    )
    private List<Product> productenBijOv = new ArrayList();


    private int klasse;
    private double saldo;

    @ManyToOne
    @JoinColumn(name = "reiziger_id")
    private Reiziger reiziger;

    public OVChipkaart() {
    }

    public OVChipkaart(int kaart_nummer, Date geldig_tot, int klasse, double saldo, Reiziger reiziger) {
        this.kaart_nummer = kaart_nummer;
        this.geldig_tot = geldig_tot;
        this.klasse = klasse;
        this.saldo = saldo;
        this.reiziger = reiziger;
    }


    public List<Product> getProductenBijOv() {
        return productenBijOv;
    }


    public void addProductenBijOv(List<Product> producten) {
        productenBijOv.addAll(producten);
    }


    public int getKaart_nummer() {
        return kaart_nummer;
    }

    public void setKaart_nummer(int kaart_nummer) {
        this.kaart_nummer = kaart_nummer;
    }

    public Date getGeldig_tot() {
        return geldig_tot;
    }

    public void setGeldig_tot(Date geldig_tot) {
        this.geldig_tot = geldig_tot;
    }

    public int getKlasse() {
        return klasse;
    }

    public void setKlasse(int klasse) {
        this.klasse = klasse;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public Reiziger getReiziger() {
        return reiziger;
    }

    public void setReiziger(Reiziger reiziger) {
        this.reiziger = reiziger;
    }


    public String OvToString() {
        return "OVChipkaart{" +
                "kaart_nummer=" + kaart_nummer +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo + "}";

    }


    @Override
    public String toString() {
        String s = "";


        for (Product product : productenBijOv) {
            s += product;

        }

        return "OVChipkaart{" +
                "kaart_nummer=" + kaart_nummer +
                ", geldig_tot=" + geldig_tot +
                ", klasse=" + klasse +
                ", saldo=" + saldo +
                ", reiziger=" + reiziger.getNaam() +
                ",  " + s +
                '}';
    }


}
