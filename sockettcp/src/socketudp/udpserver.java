/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package socketudp;
import java.net.*;

public class udpserver {
    public static void main(String args[]){
    try


    {
        int port=Integer.parseInt(args[0]);
        DatagramSocket sock = new DatagramSocket(port);
        byte[] buf=new byte[1000];
        while(true){
            DatagramPacket request=new DatagramPacket(buf, buf.length);
            sock.receive(request);
            //jo data aaya hai usiko waps bejna hai
            DatagramPacket reply=new DatagramPacket(request.getData(), request.getLength(),request.getAddress(),request.getPort());
            sock.send(reply);
        }

    }
   catch(Exception e){
        System.out.println(e);
   }
    }

}
