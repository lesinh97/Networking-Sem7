package UDP.ICT_TIME;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Date;

public class Server {
    public static void main(String[] args) throws Exception {
        DatagramSocket serverSocket = new DatagramSocket(9876);
        System.out.println("Server is started");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true) {
            DatagramPacket receivePacket;
            receivePacket = new DatagramPacket(receiveData, receiveData.length);
            // Nhan du lieu tu Client
            serverSocket.receive(receivePacket);
            // Lay dia chi IP cua Client
            InetAddress IPAddress = receivePacket.getAddress();
            // Lay port cua Client
            int port = receivePacket.getPort();
            // Lay ngay gio de gui nguoc lai Client
            String request = new String(receivePacket.getData());
            System.out.println(request);
            if (request.trim().equals("getDate")) {
                sendData = new Date().toString().getBytes();
            }
            else sendData = "Server dun no what u want!".getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length, IPAddress, port            );
            // Gui lai cho client
            serverSocket.send(sendPacket);
        }
    }
}
