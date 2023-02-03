package drapala;

import java.math.BigDecimal;

public class Menu {
    public int id;
    public String nazwa;
    public BigDecimal cena;

    public BigDecimal kalorycznosc;

    public String kategoria;

    public Menu(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public BigDecimal getCena() {
        return cena;
    }

    public void setCena(BigDecimal cena) {
        this.cena = cena;
    }

    public BigDecimal getKalorycznosc() {
        return kalorycznosc;
    }

    public void setKalorycznosc(BigDecimal kalorycznosc) {
        this.kalorycznosc = kalorycznosc;
    }

    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", nazwa='" + nazwa + '\'' +
                ", cena=" + cena +
                ", kalorycznosc='" + kalorycznosc + '\'' +
                ", kategoria='" + kategoria + '\'' +
                '}';
    }

}
