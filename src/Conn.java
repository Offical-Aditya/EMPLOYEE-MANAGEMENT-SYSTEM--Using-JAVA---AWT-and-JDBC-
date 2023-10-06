import java.sql.*;

public class Conn {
    Connection c = null;
    Statement s = null;

    public Conn() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Creating the Connection String
            String databasepath = "jdbc:mysql://localhost/employeemanagementsystem";
            c = DriverManager.getConnection(databasepath, "root", "Admin");

            s = c.createStatement();// Creating Statement;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
