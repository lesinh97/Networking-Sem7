package LTM;

import javax.script.ScriptException;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import javax.script.ScriptEngineManager;
import javax.script.ScriptEngine;
import javax.script.ScriptException;
public class Server {

    public static void main(String[] args) throws ScriptException {
        ServerSocket server;
        DataInputStream in;
        DataOutputStream out;
        Server myServer = new Server();
        try {
            System.out.println("Wait client connect ....");
            server = new ServerSocket(1069);
            while (true) {
                Socket socket = server.accept();
                System.out.println("Just connect to .." + socket.getRemoteSocketAddress());
                in = new DataInputStream(socket.getInputStream());
                out = new DataOutputStream(socket.getOutputStream());
                String str = in.readUTF();
                String str1 = myServer.myUpperCase(str);
                String str2 = myServer.myLowerCase(str);
                String str3 = myServer.calExpression(str);
                str = str1 + " - " + str2 + " - " + myServer.myCount(str) + str3;
                out.writeUTF(str);
                out.flush();
                out.close();
                in.close();
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String myUpperCase(String str) {
        char ch[] = str.toCharArray();
        String result = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 97 && ch[i] <= 122) {
                ch[i] -= 32;
            }
            result += ch[i];
        }

        return result;
    }

    public String myLowerCase(String str) {
        char ch[] = str.toCharArray();
        String result = "";
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] >= 65 && ch[i] <= 90) {
                ch[i] += 32;
            }
            result += ch[i];
        }

        return result;
    }

    public int myCount(String str) {
        char ch[] = str.toCharArray();
        int dem = 0;
        for (int i = 0; i < ch.length; i++) {
            dem++;
        }

        return dem;
    }

    public String  calExpression(String str) throws ScriptException {
        ScriptEngineManager mgr = new ScriptEngineManager();
        ScriptEngine engine = mgr.getEngineByName("JavaScript");
        return engine.eval(str).toString();
    }
 }

