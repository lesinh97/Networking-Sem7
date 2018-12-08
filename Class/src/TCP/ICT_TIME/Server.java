package TCP.ICT_TIME;

import javax.script.ScriptException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;

public class Server {
    public static void main(String[] args) throws ScriptException {
        ServerSocket serverSocket;
        DataOutputStream out;
        DataInputStream in;
        Server mServer = new Server();
        try {
            System.out.println("Watting...");
            serverSocket = new ServerSocket(6969);
            while (true) {
                Socket sSocket = serverSocket.accept();
                System.out.println("A host is connected: "+sSocket.getRemoteSocketAddress());
                out = new DataOutputStream(sSocket.getOutputStream());
                String time = Instant.now().toString();
                out.writeUTF(time);
                out.flush();
                out.close();
                serverSocket.close();
            }
        } catch (IOException e ) {
            e.getMessage();
        }
    }
}

