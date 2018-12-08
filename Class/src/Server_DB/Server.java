package Server_DB;

import JDBC_Connect.Connect;

import javax.script.ScriptException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;


public class Server {
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
    public static void main(String[] args) throws SQLException {
        ServerSocket serverSocket;
        DataOutputStream out;
        DataInputStream in;
        Statement stmt = null;
        Server mServer = new Server();
        try {
            System.out.println("Watting...");
            serverSocket = new ServerSocket(1997);
            while (true) {
                Socket sSocket = serverSocket.accept();
                System.out.println("A host is connected: "+sSocket.getRemoteSocketAddress());
                out = new DataOutputStream(sSocket.getOutputStream());
                in = new DataInputStream(sSocket.getInputStream());
                //mServer.connect().setAutoCommit(false);
                stmt = mServer.connect().createStatement();
                System.out.println("Successfully open database");
                String query = in.readUTF();
                ResultSet rs = stmt.executeQuery(query);
                /*
                if (rs.next()) {
                    ResultSetMetaData metaData = rs.getMetaData();
                    int numberOfColumns = metaData.getColumnCount();
                    System.out.println("Database Records Listing");

                    for (int i = 1; i <= numberOfColumns; i++) {
                        out.writeUTF(metaData.getColumnLabel(i) + "\t\t");
                    }
                    System.out.println();

                    do {
                        for (int i = 1; i <= numberOfColumns; i++) {
                            out.writeUTF((String) rs.getObject(i));
                        }
                        System.out.println();
                    } while (rs.next());

                    System.out.println();

                } else {
                    System.out.println("No database records foundn");
                } */
                while (rs.next()) {
                    String id = rs.getString("id");
                    String tenkh = rs.getString("tenkh");
                    String diachi =rs.getString("diachi");
                    String luong = rs.getString("luong");
                    out.writeUTF(id);
                    out.writeUTF(tenkh);
                    out.writeUTF(diachi);
                    out.writeUTF(luong);
                }
                out.flush();
                out.close();
                sSocket.close();
            }
        } catch (IOException e ) {
            e.getMessage();
        }
    }
}
