package drapala;

public interface KlientDaoIntrf {
        //dodaj nowego klienta
        void dodajKlient(Klient k);
        //wyswietl wszystkich klientów
         void wyswietlKlient();
        // edytuj informacje o kliencie
         void edytujInfoKlient(int id,String imie,String nazwisko, String nr_tele, String Ulica);
        // usuń klienta z bazy
         void usunKlient(int id);


}
