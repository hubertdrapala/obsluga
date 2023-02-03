package drapala;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public   class KlientDaoImpl implements KlientDaoIntrf {
        Connection con;

    @Override
    public void dodajKlient(Klient k) {
         con=DatabaseCon.createDatabaseCon();
         String query="insert into klienci values(?,?,?,?,?)";
        try{
            PreparedStatement pstm=con.prepareStatement(query);
            pstm.setInt(1,k.getId());
            pstm.setString(2,k.getImie());
            pstm.setString(3,k.getNazwisko());
            pstm.setString(4,k.getNr_tele());
            pstm.setString(5,k.getUlica());
           int cnt= pstm.executeUpdate();
           if(cnt!=0)
               System.out.println("Klient dodany poprawnie");


        }catch(Exception ex){
            ex.printStackTrace();
        }

    }

    @Override
    public void wyswietlKlient() {

        con=DatabaseCon.createDatabaseCon();
        String query="select * from klienci";
        System.out.println("Informacje o klientach: ");
        System.out.println("----------------------------------------------------------------");
        System.out.format("%s\t%-13s\t%-13s\t%-13s\t%-13s\n","ID","Imię","Nazwisko","Numer telefonu","Ulica");
        System.out.println("----------------------------------------------------------------");
        try{
            Statement stmt=con.createStatement();
            ResultSet result= stmt.executeQuery(query);
            while(result.next()){
                System.out.format("%d\t%-13s\t%-13s\t%-13s\t%-13s\n",
                        result.getInt(1),
                        result.getString(2),
                        result.getString(3),
                        result.getString(4),
                        result.getString(5));
                System.out.println("----------------------------------------------------------------");

            }


        }catch(Exception ex){
            ex.printStackTrace();

        }

    }

    @Override
    public void edytujInfoKlient(int id, String imie, String nazwisko, String nr_tele, String Ulica) {
        con=DatabaseCon.createDatabaseCon();
        String query="update klienci set Imie=?, Nazwisko=?, Nr_tele=?, Ulica=? where id=? ";
        try{PreparedStatement ptsm=con.prepareStatement(query);
            ptsm.setString(1,imie);
            ptsm.setString(2,nazwisko);
            ptsm.setString(3,nr_tele);
            ptsm.setString(4,Ulica);
            ptsm.setInt(5,id);
            int cnt=ptsm.executeUpdate();
            if(cnt!=0)
                System.out.println("Informacje o kliencie edytowane");

        }
        catch(Exception ex){ex.printStackTrace();
        }

    }

    @Override
    public void usunKlient(int id) {
        con=DatabaseCon.createDatabaseCon();
        String query="delete from klienci where id=?";
        try{
            PreparedStatement ptsm=con.prepareStatement(query);
            ptsm.setInt(1,id);
            int cnt=ptsm.executeUpdate();
            if(cnt!=0)
                System.out.println("Klient skutecznie usunięty z bazy danych: "+id);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
