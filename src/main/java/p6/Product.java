package p6;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "product")
public class Product {

    @Id
    private int product_nummer;
    private String naam;
    private String beschrijving;
    private double prijs;

    //    @Transient
    @ManyToMany(cascade = {CascadeType.ALL}, mappedBy = "productenBijOv")
    private List<OVChipkaart> ovBijProduct = new ArrayList();

    public Product() {
    }

    public Product(int product_nummer, String naam, String beschrijving, double prijs) {
        this.product_nummer = product_nummer;
        this.naam = naam;
        this.beschrijving = beschrijving;
        this.prijs = prijs;
    }


    public List<OVChipkaart> getOvBijProduct() {
        return ovBijProduct;
    }

    public void setOvBijProduct(List<OVChipkaart> ovBijProduct) {
        this.ovBijProduct = ovBijProduct;
    }

    public int getProduct_nummer() {
        return product_nummer;
    }

    public void setProduct_nummer(int product_nummer) {
        this.product_nummer = product_nummer;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getBeschrijving() {
        return beschrijving;
    }

    public void addOvChipkaarten(List<OVChipkaart> ovChipkaarten) {
        ovBijProduct.addAll(ovChipkaarten);

    }

    public void setBeschrijving(String beschrijving) {
        this.beschrijving = beschrijving;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }


    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();

        for (OVChipkaart ov : ovBijProduct) {
            s.append(" ").append(ov.OvToString());
        }


        return "Product{" +
                "product_nummer=" + product_nummer +
                ", naam='" + naam + '\'' +
                ", beschrijving='" + beschrijving + '\'' +
                ", prijs=" + prijs + '\'' +
                "," + s +
                '}';

    }
}
