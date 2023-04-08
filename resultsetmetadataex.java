import java.sql.*;

public class resultsetmetadataex {
  public static void main(String[] args) {
    // Connection parameters
    String url = "jdbc:mysql://localhost/manual_501";
    String username = "root";
    String password = "";

    // SQL query to retrieve user data
    String sql = "SELECT * FROM users";

    try (Connection conn = DriverManager.getConnection(url, username, password);
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

      // Get the ResultSet metadata
      ResultSetMetaData rsmd = rs.getMetaData();

      // Print the number of columns in the ResultSet
      int numColumns = rsmd.getColumnCount();
      System.out.println("Number of columns: " + numColumns);

      // Print information about each column
      for (int i = 1; i <= numColumns; i++) {
        String columnName = rsmd.getColumnName(i);
        String columnType = rsmd.getColumnTypeName(i);
        int columnSize = rsmd.getColumnDisplaySize(i);
        boolean isNullable = (rsmd.isNullable(i) == ResultSetMetaData.columnNullable);

        System.out.println("Column " + i + ": " + columnName + " (" + columnType + ") " +
                           "[" + columnSize + "]" + (isNullable ? " Nullable" : " Not nullable"));
      }
    } catch (SQLException e) {
      System.out.println("Error getting ResultSet metadata: " + e.getMessage());
    }
  }
}
