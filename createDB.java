import java.sql.*;

public class createDB {
     // Connection parameters
    static final String url = "jdbc:mysql://localhost/";
    static final String username = "root";
    static final String password = "";

  public static void main(String[] args) {
   
    // Database name
    String dbName = "Manual_501";

    // Create a connection to the database server
    try (Connection conn = DriverManager.getConnection(url, username, password)) {
      // Create a statement object
      Statement stmt = conn.createStatement();

      // SQL query to create the database
      String sql = "CREATE DATABASE " + dbName;

      // Execute the query
      stmt.executeUpdate(sql);

      System.out.println("Database " + dbName + " created successfully!");
    } catch (SQLException e) {
      System.out.println("Error creating database " + dbName + ": " + e.getMessage());
    }
  }
}
