import java.sql.*;
import java.util.Scanner;

public class CrudDemoSQLite {
    // SQLite database file
    private static final String DB_URL = "jdbc:sqlite:StudentDB.db";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL)) {
            System.out.println("Connected to SQLite database!");

            // Create table if it doesn't exist
            createTable(connection);

            Scanner scanner = new Scanner(System.in);
            while (true) {
                System.out.println("\n--- CRUD Menu ---");
                System.out.println("1. Create");
                System.out.println("2. Read");
                System.out.println("3. Update");
                System.out.println("4. Delete");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> createStudent(connection, scanner);
                    case 2 -> readStudents(connection);
                    case 3 -> updateStudent(connection, scanner);
                    case 4 -> deleteStudent(connection, scanner);
                    case 5 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice!");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create Table
    private static void createTable(Connection connection) throws SQLException {
        String query = """
                CREATE TABLE IF NOT EXISTS Students (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    age INTEGER NOT NULL,
                    course TEXT NOT NULL
                );
                """;
        try (Statement stmt = connection.createStatement()) {
            stmt.execute(query);
            System.out.println("Table created (if not exists).");
        }
    }

    // CREATE operation
    private static void createStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter name: ");
        String name = scanner.next();
        System.out.print("Enter age: ");
        int age = scanner.nextInt();
        System.out.print("Enter course: ");
        String course = scanner.next();

        String query = "INSERT INTO Students (name, age, course) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);

            int rowsInserted = stmt.executeUpdate();
            System.out.println(rowsInserted + " student(s) added.");
        }
    }

    // READ operation
    private static void readStudents(Connection connection) throws SQLException {
        String query = "SELECT * FROM Students";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            System.out.println("\n--- Students ---");
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Age: " + rs.getInt("age"));
                System.out.println("Course: " + rs.getString("course"));
                System.out.println("-------------------");
            }
        }
    }

    // UPDATE operation
    private static void updateStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to update: ");
        int id = scanner.nextInt();
        System.out.print("Enter new name: ");
        String name = scanner.next();
        System.out.print("Enter new age: ");
        int age = scanner.nextInt();
        System.out.print("Enter new course: ");
        String course = scanner.next();

        String query = "UPDATE Students SET name = ?, age = ?, course = ? WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setInt(2, age);
            stmt.setString(3, course);
            stmt.setInt(4, id);

            int rowsUpdated = stmt.executeUpdate();
            System.out.println(rowsUpdated + " student(s) updated.");
        }
    }

    // DELETE operation
    private static void deleteStudent(Connection connection, Scanner scanner) throws SQLException {
        System.out.print("Enter student ID to delete: ");
        int id = scanner.nextInt();

        String query = "DELETE FROM Students WHERE id = ?";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setInt(1, id);

            int rowsDeleted = stmt.executeUpdate();
            System.out.println(rowsDeleted + " student(s) deleted.");
        }
    }
}
