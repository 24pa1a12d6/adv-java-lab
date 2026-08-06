import java.sql.*;

public class JDBCStoredProcDemo {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String user = "testuser";
        String password = "test123";

        try (Connection conn = DriverManager.getConnection(url, user, password)) {

            System.out.println("Database connected.");

            CallableStatement insertStmt =
                    conn.prepareCall("{call insert_employee(?, ?, ?)}");

            insertStmt.setInt(1, 101);
            insertStmt.setString(2, "John Doe");
            insertStmt.setDouble(3, 55000);

            insertStmt.execute();
            System.out.println("Record inserted successfully.");

            CallableStatement getSalaryStmt =
                    conn.prepareCall("{call get_salary_by_id(?, ?)}");

            getSalaryStmt.setInt(1, 101);
            getSalaryStmt.registerOutParameter(2, Types.DECIMAL);

            getSalaryStmt.execute();

            System.out.println("Salary = " + getSalaryStmt.getDouble(2));

            insertStmt.close();
            getSalaryStmt.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
