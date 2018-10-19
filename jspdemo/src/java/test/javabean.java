package test;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Kamlesh
 */
public class javabean implements java.io.Serializable{
    String uname;
    String pass;
    
    public void setName(String uname){
        this.uname=uname;
        
        
    }
    public String getName(){
        return uname;
    }
    
}
