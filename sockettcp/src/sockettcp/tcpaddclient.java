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
public class tcpaddclient {
    public static void main(String args[]){
   try{



   Socket s=new Socket("localhost",5000);
   BufferedReader b=new BufferedReader(new InputStreamReader(System.in));
   DataOutputStream out=new DataOutputStream(s.getOutputStream());
   //while(true){
   //ServerSocket cc=new ServerSocket(6000);
   System.out.println("Enter 1st number:");

   String str=b.readLine();

   System.out.println("Enter 2nd number:");

   String str1=b.readLine();

   out.writeUTF(str);
   out.writeUTF(str1);
   //out.close();

   //Socket c=cc.accept();

   DataInputStream in=new DataInputStream(s.getInputStream());
   System.out.println(in.readUTF());
   String chdisp=b.readLine();
   out.writeUTF(chdisp);
   System.out.println(in.readUTF());
   //String ch=


}
//out.close();

   catch(Exception ex){
       System.out.println("error"+ex.getMessage());
   }

    }
    }


