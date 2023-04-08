import java.sql.*;

public class insertData {
     // Connection parameters
    static final String url = "jdbc:mysql://localhost/manual_501";
   static final  String username = "root";
    static final  String password = "";

  public static void main(String[] args) {
   
    // User data to be inserted
    String name = "Vandan Raval";
    String email = "vandanraval2002@gmail.com";

    // SQL query with prepared statement placeholders
    String sql = "INSERT INTO users (name, email) VALUES (?, ?)";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         PreparedStatement stmt = conn.prepareStatement(sql)) {
      // Set the values for the prepared statement parameters
      stmt.setString(1, name);
      stmt.setString(2, email);

      // Execute the query
      int rowsAffected = stmt.executeUpdate();

      if (rowsAffected > 0) {
        System.out.println("User " + name + " inserted successfully!");
      } else {
        System.out.println("Error inserting user " + name + ".");
      }
    } catch (SQLException e) {
      System.out.println("Error inserting user " + name + ": " + e.getMessage());
    }
  }
}
