import java.sql.*;

public class StudentJDBCApp 
{

    public static void main(String[] args) 
{
        String url = "jdbc:mysql://localhost:3306/testdb?";
        String user = "testuser";
        String password = "test123"; 

        try {
            // Load MySQL JDBC Driver

            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt = con.createStatement();

            // a. Create table
            String createTable = "CREATE TABLE IF NOT EXISTS Student ("
                               + "RollNo INT PRIMARY KEY, "
                               + "Name VARCHAR(50), "
                               + "Address VARCHAR(100))";
            stmt.executeUpdate(createTable);
            System.out.println("Table created successfully.");

            // Insert few records
            stmt.executeUpdate("INSERT INTO Student VALUES (101, 'Ravi', 'Hyderabad')");
            stmt.executeUpdate("INSERT INTO Student VALUES (102, 'Sita', 'Chennai')");
            stmt.executeUpdate("INSERT INTO Student VALUES (103, 'Kiran', 'Bangalore')");
            System.out.println("Initial records inserted.");

            // b. Display records
            System.out.println("\nInitial Records:");
            displayRecords(stmt);

            // c. Insert 2 new records
            stmt.executeUpdate("INSERT INTO Student VALUES (104, 'Meena', 'Pune')");
            stmt.executeUpdate("INSERT INTO Student VALUES (105, 'Ramesh', 'Mumbai')");
            System.out.println("\nTwo new records inserted.");

            // d. Update one record
           stmt.executeUpdate("UPDATE Student SET Address = 'Delhi' WHERE RollNo = 102");
           System.out.println("One record updated.");

            // e. Delete one record
            stmt.executeUpdate("DELETE FROM Student WHERE RollNo = 103");
            System.out.println("One record deleted.");

            // f. Display updated records
            System.out.println("\nFinal Records:");
            displayRecords(stmt);

            // Close connection
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    // Function to display records
    public static void displayRecords(Statement stmt) throws SQLException {
        ResultSet rs = stmt.executeQuery("SELECT * FROM Student");
        System.out.println("RollNo\tName\tAddress");
        while (rs.next()) {
            int roll = rs.getInt("RollNo");
            String name = rs.getString("Name");
            String address = rs.getString("Address");
            System.out.println(roll + "\t" + name + "\t" + address);
        }
    }
}
