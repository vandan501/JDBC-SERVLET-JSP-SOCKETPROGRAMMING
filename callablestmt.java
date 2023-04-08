import java.sql.*;

public class callablestmt {
  public static void main(String[] args) {
    // Connection parameters
    String url = "jdbc:mysql://localhost/manual_501";
    String username = "root";
    String password = "";

    // Stored procedure parameters
//    int param1 = ;
//    String param2 = "test";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         CallableStatement cstmt = conn.prepareCall("{CALL storedproc()}")) {
      
      int rows = cstmt.executeUpdate();
        System.out.println("Rows affected:"+rows);

    } catch (SQLException e) {
      System.out.println("Error executing stored procedure: " + e.getMessage());
    }
  }
}
