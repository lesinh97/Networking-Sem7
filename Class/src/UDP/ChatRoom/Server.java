package UDP.ChatRoom;

import java.net.*;
import java.util.HashSet;

public class Server {

    private static HashSet<Integer> portSet = new HashSet<Integer>();

    public static void main(String args[]) throws Exception {
        int serverport = 7777;

        // cai th serverport ở trên là default
        if (args.length < 1) {
            System.out.println("Using port: " + serverport);
        }
        // nguoi dung tu dinh nghia , bat use-case quá chuẩn :)))
        else {
            serverport = Integer.valueOf(args[0]).intValue();
            System.out.println("Using user custom port: " + serverport);
        }

        // tạo DG
        DatagramSocket udpServerSocket = new DatagramSocket(serverport);

        System.out.println("Server started...\n");

        while(true)
        {
            // mảng byte lưu trữ message
            byte[] receiveData = new byte[1024];

            // tạo packet rỗng dung lam packet nhan
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            udpServerSocket.receive(receivePacket);

            // nhan message, ep kieu thanh string va trim cm no di :))
            String clientMessage = (new String(receivePacket.getData())).trim();

            System.out.println("Client Connected - Socket Address: " + receivePacket.getSocketAddress());
            System.out.println("Client message: \"" + clientMessage + "\"");


            InetAddress clientIP = receivePacket.getAddress();
            System.out.println("Client IP Address & Hostname: " + clientIP + ", " + clientIP.getHostName() + "\n");

            // lay port cua connection hien tai, add vao Hashset
            int clientport = receivePacket.getPort();
            System.out.println("Adding "+clientport);
            portSet.add(clientport);

            // Response message
            String returnMessage = clientMessage.toUpperCase();
            System.out.println(returnMessage);
            // tao mang byte empty chuan bi cho viec send back data
            byte[] sendData  = new byte[1024];

            // in in in in byte vao nao
            sendData = returnMessage.getBytes();

            // gui het den tat ca client
            for(Integer port : portSet)
            {
                System.out.println(port != clientport);
                if(port != clientport)
                {
                    // Mot cai contructor
                    DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, clientIP, port);
                    System.out.println("Sending");
                    // send send send send
                    udpServerSocket.send(sendPacket);
                }
            }
        }
    }
}