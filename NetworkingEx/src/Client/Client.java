
package Client;

import Server.Server;
import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client
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
            Socket s = null;
            BufferedReader input_sock = null;
            BufferedReader input_con = null;
            PrintWriter output = null;
            s = new Socket(server, port);
            show("Connected with server");
            output=new PrintWriter(s.getOutputStream(),true);
            input_sock=new BufferedReader(new InputStreamReader(s.getInputStream()));
            input_con=new BufferedReader(new InputStreamReader(System.in));
            while(true)
            {
                msg=input_con.readLine();
                output.println(msg);
                msg=input_sock.readLine();
                if(msg==null)
                    System.exit(0);
                show(msg);
            }
        } catch (Exception ex) {
            Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
