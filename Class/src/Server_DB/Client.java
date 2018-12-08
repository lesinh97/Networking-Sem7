package Server_DB;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.sql.ResultSet;


public class Client {

    private void connect() throws EOFException {
        ResultSet rs = null;
        try {
            Socket socket = new Socket("localhost", 1997);
            DataInputStream in = new DataInputStream(socket.getInputStream());
            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF("Select * from table1");
            String ID = null;
            String tenkh = null;
            String diachi = null;
            String luong = null;
            System.out.print("ID\t"+"tenkh\t"+"diachi\t"+"luong\t");
            while (true) {
                System.out.println();
                ID = in.readUTF();
                System.out.print(ID + "\t");
                tenkh = in.readUTF();
                System.out.print(tenkh + "\t");
                diachi = in.readUTF();
                System.out.print(diachi + "\t");
                luong = in.readUTF();
                System.out.print(luong + "\t");

            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, EOFException {
        Client cl = new Client();
        cl.connect();
    }
}