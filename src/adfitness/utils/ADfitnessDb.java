
package adfitness.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ADfitnessDb {

 private final String url="jdbc:mysql://localhost/adfitness";
 private final String login="root";
 private final String mdp="";
 private Connection cnx;
 private static ADfitnessDb instance;
 public ADfitnessDb()
 {
     try {
         cnx = DriverManager.getConnection(url, login, mdp);
         System.out.println("connection a la base de données etablie");
     } catch (SQLException ex) {
         System.out.println("connection a la base de données echouée");
     }
 }
    public static ADfitnessDb getInstance() {
        if(instance==null)
            instance=new ADfitnessDb();
        return instance;
    }
     public  Connection getCnx() {
        return cnx;
    }
}
