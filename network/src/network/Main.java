/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package network;
import java.io.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int port = 3700;
            String server = "localhost";
            String data;
            ServerSocket ss = null;
            Socket s = null;
            BufferedReader con_in = null;
            BufferedReader input = null;
            PrintWriter output = null;
            ss = new ServerSocket(port);
            output.println("Server is waiting");
            s = ss.accept();
            output.println("Connected");
            output = new PrintWriter(s.getOutputStream(), true);
            input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            con_in = new BufferedReader(new InputStreamReader(System.in));
            data = input.readLine();
            output.println("a : " + data);
            int a = Integer.parseInt(data);
            data = input.readLine();
            output.println("b : " + data);
            int b = Integer.parseInt(data);
            data = con_in.readLine();
            s.close();
            ss.close();
            // TODO code application logic here
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
       // TODO code application logic here
    }

}
