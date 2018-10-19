/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi_beans;
import java.rmi.server.*;
import java.rmi.*;

/**
 *
 * @author Kamlesh
 */
public class CalcImplement extends UnicastRemoteObject implements CalcInterface{
    public CalcImplement() throws Exception{
        super();
    }
  
    @Override
    public float add(float x,float y){
        return 10+20;
    }
    
}
