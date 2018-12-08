package UDP.ICT_TIME;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Client {
    public static void main(String[] args) throws Exception {
        DatagramSocket clientSocket = new DatagramSocket(); // gan cong
        InetAddress IPAddress = InetAddress.getByName("localhost");
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        sendData = "getDate".getBytes();
        // tao datagram co noi dung yeu cau loai du lieu de gui di cho server
        DatagramPacket sendPacket = new DatagramPacket(sendData,sendData.length,IPAddress,9876);
        clientSocket.send(sendPacket); // gui du lieu cho server
        // tao datagram trong de nhan du lieu
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        // nhan du lieu tu server
        clientSocket.receive(receivePacket);
        // lay du lieu tu packet nhan duoc
        String str = new String(receivePacket.getData());
        System.out.println(str);
        clientSocket.close();
    }
}
