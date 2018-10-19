/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package javarmi_beans;
import java.rmi.*;
/**
 *
 * @author Kamlesh
 */
public interface CalcInterface extends Remote {
    public float add(float x,float y);
    
}
