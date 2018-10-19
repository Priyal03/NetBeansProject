package Front;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 *
 * @author Priyal
 */
public class swing_sample 
{
    JLabel l_name,l_pass;
    JTextField t_name;
    JPasswordField t_pass;     //A special JTextField but hides input text
    JButton button;
    JFrame f=new JFrame("GClient");
 
    //a <span class="w2hjz5r742" id="w2hjz5r742_1">inner class</span> to handling ActionEvents
    handler handle;
 
    //a separate class for processing database connection and authentication
    database db;
 
    swing_sample()
    {
       // c = getContentPane();
        f.setLayout(new FlowLayout());
     //   f.setSize(800,600);
        //extra classes
        db=new database();
        handle =new handler();
 
                //swing components
        l_name=new JLabel("Username");
        l_pass=new JLabel("Password");
        t_name=new JTextField(10);
        t_pass=new JPasswordField(10);
        button=new JButton("Login");
 
        //adding actionlistener to the button
        button.addActionListener(handle);
       // JFrame j=new JFrame();
        //j.setTitle("Login form");
        f.setVisible(true);
        //add to contaienr
        f.add(l_name);
        f.add(t_name);
        f.add(l_pass);
        f.add(t_pass);
        f.add(button);
        //visual
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(200,130);
 
    }
   
 
    //an inner class .You can also write as a separate class
    class handler implements ActionListener
    {
        //must implement method
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
            //checks if the button clicked
            if(ae.getSource()==button)
            {
                char[] temp_pwd=t_pass.getPassword();
                String pwd=null;
                pwd=String.copyValueOf(temp_pwd);
                System.out.println("Username,Pwd:"+t_name.getText()+","+pwd);
 
                //The entered username and password are sent via "checkLogin()" which return boolean
                if(db.checkLogin(t_name.getText(), pwd))
                {
                    //a pop-up box
                    JOptionPane.showMessageDialog(null, "You have logged in successfully","Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    //a pop-up box
                    JOptionPane.showMessageDialog(null, "Login failed!","Failed!!",
                                        JOptionPane.ERROR_MESSAGE);
                }
            }//if
        }//method
 
    }//inner cla
     public static void main(String args[])
    {
        swing_sample sample=new swing_sample();
    }
}
