package drapala;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuDaoImpl implements MenuDaoIntrf {

    Connection con;

    @Override
    public void wyswietlMenu() {

        con = DatabaseCon.createDatabaseCon();
        String query = "select * from menu";
        System.out.println("Menu: ");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.format("%s\t%-10s\t%-22s\t%-10s\t%s\t%s\n", "ID", "", "Nazwa", "cena", "kaloryczność", "kategoria");
        System.out.println("-----------------------------------------------------------------------------");
        try {
            Statement stmt = con.createStatement();
            ResultSet result = stmt.executeQuery(query);
            while (result.next()) {
                System.out.format("%-10d\t%-25s\t%-10s\t%-15s\t%-60s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getBigDecimal(3),
                        result.getBigDecimal(4),
                        result.getString(5));
                System.out.println("-----------------------------------------------------------------------------");

            }


        } catch (Exception ex) {
            ex.printStackTrace();

        }


    }




        @Override
        public void wybierzPozycje() {
            wyswietlMenu();
            Scanner sc = new Scanner(System.in);
            System.out.println("Wybierz ID pozycji z menu, aby zakończyć wybieranie wpisz 0: ");
            int id = sc.nextInt();
            BigDecimal sumaCeny = BigDecimal.ZERO;
            BigDecimal sumaKalorycznosci = BigDecimal.ZERO;
            List<String> nazwy = new ArrayList<>();

            while (id != 0) {
                String query = "select * from menu where id=" + id;
                try {
                    Statement stmt = con.createStatement();
                    ResultSet result = stmt.executeQuery(query);
                    if (result.next()) {
                        nazwy.add(result.getString(2));
                        sumaCeny = sumaCeny.add(result.getBigDecimal(3));
                        sumaKalorycznosci = sumaKalorycznosci.add(new BigDecimal(result.getString(4)));
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                System.out.println("Wybierz ID pozycji z menu, aby zakończyć wybieranie wpisz 0: ");
                id = sc.nextInt();
            }

            System.out.println("Wybrane nazwy: " + nazwy);
            System.out.println("Suma ceny: " + sumaCeny);
            System.out.println("Suma kaloryczności: " + sumaKalorycznosci);
        }

        public void usunMenu(int id){
            con=DatabaseCon.createDatabaseCon();
            String query="delete from menu where id=?";
            try{
                PreparedStatement ptsm=con.prepareStatement(query);
                ptsm.setInt(1,id);
                int cnt=ptsm.executeUpdate();
                if(cnt!=0)
                    System.out.println("Pozycja skutecznie usunięta z bazy danych: "+id);
            }
            catch (Exception ex){
                ex.printStackTrace();
            }

        }

        public void dodajMenu(Menu m){
        con=DatabaseCon.createDatabaseCon();
            String query="insert into menu values(?,?,?,?,?)";
            try{
                PreparedStatement pstm=con.prepareStatement(query);
                pstm.setInt(1,m.getId());
                pstm.setString(2,m.getNazwa());
                pstm.setBigDecimal(3,m.getCena());
                pstm.setBigDecimal(4,m.getKalorycznosc());
                pstm.setString(5,m.getKategoria());
                int cnt= pstm.executeUpdate();
                if(cnt!=0)
                    System.out.println("Danie dodane poprawnie");


            }catch(Exception ex){
                ex.printStackTrace();
            }

        }

        }













