package TCP.ICT_TIME;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DataInputStream in ;
        try {
            while (true) {
                Socket cSocket = new Socket("localhost", 6969);
                in = new DataInputStream(cSocket.getInputStream());
                String strRS = in.readUTF();
                System.out.println("Nhan tu server: "+strRS);
                System.out.println();
                in.close();
                cSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
