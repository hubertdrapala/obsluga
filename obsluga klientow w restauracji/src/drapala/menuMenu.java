package drapala;

import java.util.Scanner;

public class menuMenu extends Menu {
    private final MenuDaoIntrf dao = new MenuDaoImpl();

    public menuMenu(){

    }

    public void  menuMenu(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println ("1.Wyświetl Menu\n"+
                                "2.Dodaj zamówienie klienta\n"+
                                "3.Usun pozycje z menu\n"+
                                "4.Dodaj pozycje do menu\n"+
                                "5.Powrót do początkowego interfejsu\n");
            System.out.println("Wybierz jedną z możliwośći");
            int ch = sc.nextInt();
            switch (ch) {
                case 1:
                    dao.wyswietlMenu();
                    break;
                case 2:

                    dao.wybierzPozycje();
                    break;
                case 3:
                    System.out.println("Wprowadź id pozycji z menu która chcesz usunać");
                    id = sc.nextInt();
                    dao.usunMenu(id);

                    break;
                case 4:
                    Menu m = new Menu();
                    System.out.println("Wprowadź ID : ");
                    id = sc.nextInt();
                    System.out.println("Wprowadź danie : ");
                    nazwa= sc.next();
                    System.out.println("Wprowadź cene : ");
                    cena = sc.nextBigDecimal();
                    System.out.println("Wprowadź kalorycznosc : ");
                    kalorycznosc = sc.nextBigDecimal();
                    System.out.println("Wprowadź kategorie dania: ");
                    kategoria = sc.next();
                    m.setId(id);
                    m.setNazwa(nazwa);
                    m.setCena(cena);
                    m.setKalorycznosc(kalorycznosc);
                    m.setKategoria(kategoria);
                    dao.dodajMenu(m);
                    break;


                case 5:
                    System.out.println("Powrót do menu głównego");
                    return;


            }





        }while(true);





    }

}
