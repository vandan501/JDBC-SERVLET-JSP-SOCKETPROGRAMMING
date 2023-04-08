import java.sql.*;

public class createTBL {
        // Connection parameters
    static final String url = "jdbc:mysql://localhost/manual_501";
    static final  String username = "root";
    static final  String password = "";

  public static void main(String[] args) {

    // Table name and column names
    String tableName = "users";
    String column1 = "id INT NOT NULL AUTO_INCREMENT PRIMARY KEY";
    String column2 = "name VARCHAR(50) NOT NULL";
    String column3 = "email VARCHAR(50) NOT NULL";

    // Create a connection to the database server
    try (Connection conn = DriverManager.getConnection(url, username, password)) {
      // Create a statement object
      Statement stmt = conn.createStatement();

      // SQL query to create the table
      String sql = "CREATE TABLE " + tableName + "(" + column1 + ", " + column2 + ", " + column3 + ")";

      // Execute the query
      stmt.executeUpdate(sql);

      System.out.println("Table " + tableName + " created successfully!");
    } catch (SQLException e) {
      System.out.println("Error creating table " + tableName + ": " + e.getMessage());
    }
  }
}
