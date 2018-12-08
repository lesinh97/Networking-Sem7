package LTM;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DataInputStream in;
        DataOutputStream out;
        try {
            while (true) {
                Socket socket = new Socket("localhost", 1069);
                System.out.print("Nhap du lieu: ");
                String str = scanner.nextLine();
                out = new DataOutputStream(socket.getOutputStream());
                in = new DataInputStream(socket.getInputStream());
                out.writeUTF(str);
                out.flush();
                String strRS = in.readUTF();
                System.out.print("Du lieu tra ve: " + strRS);
                System.out.println();
                out.close();
                in.close();
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
