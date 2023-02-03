package drapala;

import java.util.Scanner;


public class KlientMenu extends Klient  {
    private final KlientDaoIntrf dao = new KlientDaoImpl();


    public KlientMenu() {
    }

    public void KlientMenu() {
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("1. Dodaj Klienta \n" +
                    "2. Wyswietl wszystkich klientów\n" +
                    "3. Edytuj informacje o kliencie\n" +
                    "4. Usuń klienta z bazy\n"+
                    "5.Powrót do początkowego interfejsu\n"+
                    "6.Wyjście z programu\n");
                    ;

            System.out.println("Wybierz jedną z możliwośći");
            int ch = sc.nextInt();
            switch (ch) {

                    case 1:
                        Klient k = new Klient();
                        System.out.println("Wprowadź ID : ");
                        id = sc.nextInt();
                        System.out.println("Wprowadź imię : ");
                        imie = sc.next();
                        System.out.println("Wprowadź nazwisko : ");
                        nazwisko = sc.next();
                        System.out.println("Wprowadź numer telefonu : ");
                        nr_tele = sc.next();
                        System.out.println("Wprowadź Ulice : ");
                        Ulica = sc.next();
                        k.setId(id);
                        k.setImie(imie);
                        k.setNazwisko(nazwisko);
                        k.setNr_tele(nr_tele);
                        k.setUlica(Ulica);
                        dao.dodajKlient(k);
                        break;
                    case 2:
                        dao.wyswietlKlient();
                        break;
                case 3:
                    System.out.println("Wprowadź ID klienta które chcesz edytować");
                    id = sc.nextInt();
                    System.out.println("Wprowadź nowe imie:");
                    imie = sc.next();
                    System.out.println("Wprowadź nowe nazwisko:");
                    nazwisko = sc.next();
                    System.out.println("Wprowadź nowy nr telefonu:");
                    nr_tele = sc.next();
                    System.out.println("Wprowadź nową ulicę:");
                    Ulica = sc.next();
                    dao.edytujInfoKlient(id,imie,nazwisko,nr_tele,Ulica);

                    break;
                    case 4:
                        System.out.println("Wprowadź id klienta którego chcesz usunąć z bazy");
                        id = sc.nextInt();
                        dao.usunKlient(id);
                        break;

                    case 5:
                        System.out.println("Powrót do głównego interfejsu");
                        return;

                    case 6:
                        System.out.println("Dziękuje!");
                        System.exit(0);
                        default:
                        System.out.println("Wprowadz poprawne dane!");
                        break;
                        }
        } while (true);
    }
}