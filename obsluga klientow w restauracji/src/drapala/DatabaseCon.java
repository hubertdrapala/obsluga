package drapala;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseCon {
        static Connection con;
    public static Connection createDatabaseCon(){

       try
       {
           Class.forName("com.mysql.cj.jdbc.Driver");
           String url="jdbc:mysql://localhost:3306/obsługaklientów";
           String username="root";
           String password= "toor";
          con= DriverManager.getConnection(url,username,password);


       }
       catch (Exception ex){
           ex.printStackTrace();
       }

        return con;
        }

}
