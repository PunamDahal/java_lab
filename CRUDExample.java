import java.sql.*;

public class CRUDExample {
    public static void main(String[] args) {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "user", "password");
            
            // Create operation
            String createQuery = "INSERT INTO students (name, age) VALUES ('John', 22)";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(createQuery);
            
            // Read operation
            String selectQuery = "SELECT * FROM students";
            ResultSet rs = stmt.executeQuery(selectQuery);
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " " + rs.getString("name"));
            }
            
            // Update operation
            String updateQuery = "UPDATE students SET age = 23 WHERE name = 'John'";
            stmt.executeUpdate(updateQuery);
            
            // Delete operation
            String deleteQuery = "DELETE FROM students WHERE name = 'John'";
            stmt.executeUpdate(deleteQuery);
            
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
