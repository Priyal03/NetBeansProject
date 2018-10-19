/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockettcp;

import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author Administrator
 */
public class servertcp {
    public static void main(String args[]){
        try{
            ServerSocket ss=new ServerSocket(5000);
            Socket s;
            s=ss.accept();
            while(true){


            
            
            DataInputStream in=new DataInputStream(s.getInputStream());
            String str=in.readUTF();

            System.out.println("Client::"+str);
            
            //Socket send=new Socket("localhost",6000);
            System.out.println("Server(You)::");
            BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            String str2=br.readLine();
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            out.writeUTF(str2);
            //out.close();
            
            }


        }
        catch (Exception ex){
            System.out.println("Error:"+ex.getMessage());
        }
    }

}
