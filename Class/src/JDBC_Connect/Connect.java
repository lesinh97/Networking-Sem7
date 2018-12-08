package JDBC_Connect;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class Connect{

    private final String url = "jdbc:postgresql://localhost/khachhang";
    private final String user = "postgres";
    private final String password = "lesinh";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    public static void main(String[] args) {
        Connect app = new Connect();
        app.connect();
    }
}