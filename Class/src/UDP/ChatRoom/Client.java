package UDP.ChatRoom;
import java.io.*;
import java.net.*;

public class Client {

    public static void main(String args[]) throws Exception {

        //default port
        int clientport = 7777;
        String host = "localhost";

        if (args.length < 1) {
            System.out.println("Port: " + clientport);
        }
        // giong nhu ben server
        else {
            //host = args[0];
            clientport = Integer.valueOf(args[0]).intValue();
            System.out.println("Port: " + clientport);
        }

        // lay dia chi ip cua localhost
        InetAddress ia = InetAddress.getByName(host);

        SenderThread sender = new SenderThread(ia, clientport);
        sender.start();
        ReceiverThread receiver = new ReceiverThread(sender.getSocket());
        receiver.start();
    }
}

class SenderThread extends Thread {

    private InetAddress serverIPAddress;
    private DatagramSocket udpClientSocket;
    private boolean stopped = false;
    private int serverport;

    public SenderThread(InetAddress address, int serverport) throws SocketException {
        this.serverIPAddress = address;
        this.serverport = serverport;
        // Create client DatagramSocket
        this.udpClientSocket = new DatagramSocket();
        this.udpClientSocket.connect(serverIPAddress, serverport);
    }
    public void halt() {
        this.stopped = true;
    }
    public DatagramSocket getSocket() {
        return this.udpClientSocket;
    }

    public void run() {
        try {
            //send blank message
            byte[] data = new byte[1024];
            data = "Hello cac ban".getBytes();
            DatagramPacket blankPacket = new DatagramPacket(data,data.length , serverIPAddress, serverport);
            udpClientSocket.send(blankPacket);

            // luong input vao
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
            while (true)
            {
                if (stopped)
                    return;

                // Message
                String clientMessage = inFromUser.readLine();

                if (clientMessage.equals("."))
                    break;

                byte[] sendData = new byte[1024];

                sendData = clientMessage.getBytes();

                DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, serverIPAddress, serverport);

                System.out.println("自分: "+clientMessage);
                udpClientSocket.send(sendPacket);

                Thread.yield();
            }
        }
        catch (IOException ex) {
            System.err.println(ex);
        }
    }
}

class ReceiverThread extends Thread {

    private DatagramSocket udpClientSocket;
    private boolean stopped = false;

    public ReceiverThread(DatagramSocket ds) throws SocketException {
        this.udpClientSocket = ds;
    }

    public void halt() {
        this.stopped = true;
    }

    public void run() {

        byte[] receiveData = new byte[1024];

        while (true) {
            if (stopped)
                return;

            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            try {
                udpClientSocket.receive(receivePacket);
                String serverReply =  new String(receivePacket.getData(), 0, receivePacket.getLength());
                System.out.println("Recieved: \"" + serverReply + "\"\n");

                Thread.yield();
            }
            catch (IOException ex) {
                System.err.println(ex);
            }
        }
    }
}