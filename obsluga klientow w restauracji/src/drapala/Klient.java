package drapala;

public class Klient {
            public int id;
            public String imie;
            public String nazwisko;
            public String nr_tele;
            public String Ulica;

   public Klient(){
   }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNr_tele() {
        return nr_tele;
    }

    public void setNr_tele(String nr_tele) {
        this.nr_tele = nr_tele;
    }

    public String getUlica() {
        return Ulica;
    }

    public void setUlica(String ulica) {
        Ulica = ulica;
    }

    @Override
    public String toString() {
        return "Klient{" +
                "id=" + id +
                ", imie='" + imie + '\'' +
                ", nazwisko='" + nazwisko + '\'' +
                ", nr_tele='" + nr_tele + '\'' +
                ", Ulica='" + Ulica + '\'' +
                '}';
    }
}
