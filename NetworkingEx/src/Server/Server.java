package Server;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server
{
    static void show(String s)
    {
        System.out.println(s);
    }
    public static void main(String args[])
    {
        try {
            int port = 1500;
            String server = "localhost";
            String msg;
            ServerSocket ss = null;
            Socket s = null;
            BufferedReader input,input_con = null;
            PrintWriter output = null;
            ss=new ServerSocket(port);
            show("Server waiting for client");
            s=ss.accept();
            show("Client accepted");
            output=new PrintWriter(s.getOutputStream(),true);
            input=new BufferedReader(new InputStreamReader(s.getInputStream()));
            input_con=new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
                msg=input.readLine();
                if(msg.equals("bye"))
                {
                    show("Connection terminated");
                    break;
                }
                show("Client : "+msg);
                msg=input_con.readLine();
                output.println("Echoed by server : "+msg);
            }
            s.close();
            ss.close();
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
