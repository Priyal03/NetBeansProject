/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi_beans;

import java.rmi.registry.LocateRegistry;
import java.rmi.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Kamlesh
 */
public class JavaRMI_beans {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            
            CalcImplement ci=new CalcImplement();
            CalcInterface cii=(CalcInterface) UnicastRemoteObject.exportObject(ci);
            LocateRegistry.createRegistry(8701);
            Registry re=LocateRegistry.getRegistry();
            re.rebind("Hello", cii);
            System.out.println("Server Ready");
        }
        catch(Exception e){
            System.out.println("Exception:"+e.getMessage());
        }
    }
}
