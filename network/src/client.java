/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Administrator
 */

import java.net.*;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class client {
    public static void main(String[] args)
    {
        try {
            int port = 3700;
            String server = "localhost";
            String data=null;
            Socket s = null;
            BufferedReader in = null;
            BufferedReader cons_in = null;
            PrintWriter output = null;
            s = new Socket(server, port);
            output.println("Connected with server");
            output = new PrintWriter(s.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(s.getInputStream()));
            cons_in = new BufferedReader(new InputStreamReader(System.in));
           data = in.readLine();
            output.println("a : " + data);
            int a = Integer.parseInt(data);
            data = in.readLine();
            output.println("b : " + data);
            int b = Integer.parseInt(data);
            data = cons_in.readLine();
            s.close();

           /* int a = Integer.parseInt("0");
            output.println("a" + a);
           int b = Integer.parseInt("1");
            output.println("b" + b);
*/
        } catch (UnknownHostException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(client.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
