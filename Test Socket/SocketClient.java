
import java.net.*;
import java.io.*;

public class SocketClient
{
    public static void main(String [] args)
    {
        String tenServer = args[0];
        int port = Integer.parseInt(args[1]);
        try
        {
            System.out.println("Ket noi toi " + tenServer
                    + " on port " + port);
            Socket client = new Socket(tenServer, port);
            System.out.println("Just connected to "
                    + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out =
                    new DataOutputStream(outToServer);

            out.writeUTF("Hello from "
                    + client.getLocalSocketAddress());
            InputStream inFromServer = client.getInputStream();
            DataInputStream in =
                    new DataInputStream(inFromServer);
            System.out.println("Server says " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
