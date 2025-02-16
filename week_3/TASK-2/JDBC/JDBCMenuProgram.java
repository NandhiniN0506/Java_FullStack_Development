import java.sql.*;
import java.util.*;

public class JDBCMenuProgram {
    private static final String URL = "jdbc:mysql://localhost:3306/yourDatabase";
    private static final String USER = "yourUsername";
    private static final String PASSWORD = "yourPassword";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert a new Row");
            System.out.println("2. Update a Row");
            System.out.println("3. Delete a Row");
            System.out.println("4. Select a row");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    insertRows();
                    break;
                case 2:
                    updateRow(scanner);
                    break;
                case 3:
                    deleteRow(scanner);
                    break;
                case 4:
                    selectRow(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Task 1: Recursively insert multiple rows using PreparedStatement
    public static void insertRows() {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("INSERT INTO yourTable (column1, column2) VALUES (?, ?)");
             Scanner scanner = new Scanner(System.in)) {

            while (true) {
                System.out.print("Enter column1 value (or 'exit' to stop): ");
                String col1 = scanner.nextLine();
                if (col1.equalsIgnoreCase("exit")) break;

                System.out.print("Enter column2 value: ");
                String col2 = scanner.nextLine();

                pstmt.setString(1, col1);
                pstmt.setString(2, col2);
                pstmt.executeUpdate();
                System.out.println("Row inserted successfully.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Task 2: Update a row dynamically using Scanner
    public static void updateRow(Scanner scanner) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("UPDATE yourTable SET column2 = ? WHERE column1 = ?")) {

            System.out.print("Enter column1 value to update: ");
            String col1 = scanner.nextLine();
            System.out.print("Enter new column2 value: ");
            String col2 = scanner.nextLine();

            pstmt.setString(1, col2);
            pstmt.setString(2, col1);
            int rowsUpdated = pstmt.executeUpdate();

            if (rowsUpdated > 0) {
                System.out.println("Row updated successfully.");
            } else {
                System.out.println("No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Task 3: Delete a row using Scanner
    public static void deleteRow(Scanner scanner) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("DELETE FROM yourTable WHERE column1 = ?")) {

            System.out.print("Enter column1 value to delete: ");
            String col1 = scanner.nextLine();

            pstmt.setString(1, col1);
            int rowsDeleted = pstmt.executeUpdate();

            if (rowsDeleted > 0) {
                System.out.println("Row deleted successfully.");
            } else {
                System.out.println("No matching record found.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Task 4: Select a row using Scanner
    public static void selectRow(Scanner scanner) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM yourTable WHERE column1 = ?")) {

            System.out.print("Enter column1 value to search: ");
            String col1 = scanner.nextLine();
            pstmt.setString(1, col1);

            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                System.out.println("column1: " + rs.getString("column1") + ", column2: " + rs.getString("column2"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
