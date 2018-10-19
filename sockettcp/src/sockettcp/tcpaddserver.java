package sockettcp;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.net.ServerSocket;
import java.net.Socket;
import java.io.*;

/**
 *
 * @author Administrator
 */
public class tcpaddserver {
public static void main(String args[]){
        try{
            ServerSocket ss=new ServerSocket(5000);
            Socket s;
            s=ss.accept();
           // while(true){




            DataInputStream in=new DataInputStream(s.getInputStream());
            //String str=in.readUTF();

            float a=Float.parseFloat(in.readUTF());
            float b=Float.parseFloat(in.readUTF());
            //System.out.println("Client::"+str);

            //Socket send=new Socket("localhost",6000);
            //System.out.println("Server(You)::");
            //BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
            //String str2=br.readLine();
            DataOutputStream out=new DataOutputStream(s.getOutputStream());
            //int c=(int) (a + b);
            //String ans="Addition of"+a+" and "+b+" is::"+c;
            String ch="Please Enter Your Choice:\n1.Addition\n2.Subtraction\n3.Multiply\n4.Division";
            out.writeUTF(ch);

            int choice=Integer.parseInt(in.readUTF());
            //String ch
            //Character choice =new Character(in.readUTF());
            float c;
            String ans;
            switch(choice)
            {
                case 1:
                    c=a+b;
                    ans="Addition of"+a+" and "+b+" is::"+c;
                    break;
                case 2:
                    c=a-b;
                    ans="Subtraction of"+a+" and "+b+" is::"+c;
                    break;
                case 3:
                    c=a*b;
                    ans="Multiplication of"+a+" and "+b+" is::"+c;
                    break;

                case 4:
                    c=a/b;
                    ans="Division of"+a+" and "+b+" is::"+c;
                    break;
                default:
                    ans="Invalid Choice";
                    break;

            }
            out.writeUTF(ans);
                    out.close();
ss.close();
           // }


        }
        catch(Exception ex){
            System.out.println("Error:"+ex.getMessage());
        }
    }

}
