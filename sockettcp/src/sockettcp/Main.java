/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sockettcp;
import java.net.*;
/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws Exception {
        // TODO code application logic here
        String str=InetAddress.getLocalHost().getHostName();
        System.out.println(str);
        
    }

}
