package drapala;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Witaj!");
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Wybierz opcje:");
            System.out.println("1.Zarządzanie klientami");
            System.out.println("2.Zarządzenie Menu");
            System.out.println("3.Wyjście z programu");

            int option = sc.nextInt();
            switch (option) {
                case 1 -> {
                    KlientMenu klientMenu = new KlientMenu();
                    klientMenu.KlientMenu();
                }
                case 2 -> {
                    menuMenu m1 = new menuMenu();
                    m1.menuMenu();
                }
                case 3 -> {
                    System.out.println("Zamykanie programu");
                    System.exit(0);
                }
                default -> {
                }
            }

        }while(true);
    }
}
