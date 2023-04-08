import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;
public class Jdbc_demo {
    
   static final String DB_URL = "jdbc:mysql://localhost/smart";
   static final String USER = "root";
   static final String PASS = "";
   
   public static void main(String[] args) {
       

        try {
            Connection conn = DriverManager.getConnection(DB_URL,USER,PASS);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM admin"); // replace "yourtable" with your table name
            
            while (rs.next()) {
                int a_id = rs.getInt("a_id"); // replace "id" with your column name
                String a_username = rs.getString("a_username"); // replace "name" with your column name
                String a_password = rs.getString("a_password"); // replace "name" with your column name
                String a_email = rs.getString("a_email"); // replace "name" with your column name

                System.out.println(a_id + ", " + a_username + ", " + a_password+" , " +a_email);
            }
            
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

  

   