/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socketudp;

import java.net.*;


public class udpclient {
public static void main(String[] args){
    try


    {
        
        DatagramSocket sock=new DatagramSocket();
        byte[] data=args[0].getBytes();
        InetAddress ip=InetAddress.getByName(args[1]);
        int port=Integer.parseInt(args[2]);
        DatagramPacket sendreq=new DatagramPacket(data,data.length,ip,port );
        sock.send(sendreq);
        byte[] recvbuf=new byte[1000];
        DatagramPacket reply=new DatagramPacket(recvbuf,recvbuf.length);
        sock.receive(reply);
        System.out.println("Server Reply::"+new String(reply.getData()));



    }
   catch(Exception e){
        System.out.println(e);
   }
}







    }

