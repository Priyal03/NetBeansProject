/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


package sockettcp;
import java.io.*;
import java.net.*;



/**
 *
 * @author Administrator
 */
public class clienttcp {
    public static void main(String args[]){
   try{
       


   Socket s=new Socket("localhost",5000);
   BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
   DataOutputStream out=new DataOutputStream(s.getOutputStream());
   while(true){
   //ServerSocket cc=new ServerSocket(6000);
   System.out.println("Client(You):");
   
   String str=b.readLine();

   
   out.writeUTF(str);
   //out.close();

   //Socket c=cc.accept();

   DataInputStream in=new DataInputStream(s.getInputStream());
   String str1=in.readUTF();
   System.out.println("Server::"+str1);

   
}
//out.close();
   }
   catch(Exception ex){
       System.out.println("error"+ex.getMessage());
   }


    }

}
