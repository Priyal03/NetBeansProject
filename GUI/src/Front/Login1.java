package Front;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
/**
 *
 * @author Priyal
 */
 
public class Login1
{
    JLabel label1 = new JLabel("", JLabel.CENTER);
    JLabel label  = new JLabel("", JLabel.CENTER);        
    JLabel label3  = new JLabel("", JLabel.CENTER); 
    JLabel label2  = new JLabel("", JLabel.CENTER);  
    JButton x=new JButton();  
    JButton b1=new JButton();  
    JPasswordField p=new JPasswordField(30);
    handler handle;   
    handler hand;
    JFrame f=new JFrame();
    database db;
    String id;
    Send s;
    Page2_1 ad;
    public static JTextField t=new JTextField(40);
    
    public void log() 
    {
       f.setTitle("GClient");
       handle=new handler();
       hand=new handler();
       db=new database();
       
      label1.setText("Welcome to the GClient...");
      label1.setOpaque(false);
      label1.setBounds(20,20,150,60);
      label1.setBackground(Color.GRAY);
      label1.setForeground(Color.GRAY);
      f.add(label1);
  
      label.setText("User Id");
      label.setOpaque(true);
      label.setBounds(370,180,100,40);
      label.setBackground(Color.GRAY);
      label.setForeground(Color.GREEN);
      f.add(label);
      
      label2.setText("Password");
      label2.setOpaque(true);
      label2.setBounds(370,260,100,40);
      label2.setBackground(Color.GRAY);
      label2.setForeground(Color.GREEN);
      f.add(label2);
         
      label3.setText("or");
      label3.setOpaque(false);
      label3.setBounds(470,420,50,20);
      label3.setBackground(Color.GRAY);
      label3.setForeground(Color.BLACK);
      f.add(label3);
          
      x.setBounds(450,370,100, 40); 
      x.setText("Sign in");
      x.addActionListener(handle);
      f.add(x); 
      
      b1.setBounds(450,450,100,40); 
      b1.setText("Add Details");      
      b1.addActionListener(hand);
      f.add(b1);
         
      t.setBounds(500,180,200,40);      
      p.setBounds(500,260,200,40);
      f.add(p);
      f.add(t);
  
      f.setSize(800,600);
      f.setLayout(null);
      f.setVisible(true);  
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String args[])
    {
        Login1 sample=new Login1();
        sample.log();    
    }

    public static String getid()
    {
        return t.getText();
    }
    class handler implements ActionListener
    {
        //must implement method
        //This is triggered whenever the user clicks the login button
        public void actionPerformed(ActionEvent ae)
        {
            //checks if the button clicked
            if(ae.getSource()==x)
            {
                char[] temp_pwd=p.getPassword();
                String pwd=String.valueOf(temp_pwd);
                id=t.getText();                               
                System.out.println("Username,Pwd:"+t.getText()+","+pwd);
 
                //The entered username and password are sent via "checkLogin()" which return boolean
                if(db.checkLogin(t.getText(), pwd))
                {
                    JOptionPane.showMessageDialog(null, "You have logged in successfully","Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                    s=new Send();
                }
                else  
                {
                    JOptionPane.showMessageDialog(null, "Incorrect Id or Password","Failed!!",
                                        JOptionPane.ERROR_MESSAGE);                    
                }
            }
            else 
                 if(ae.getSource()==b1)
            {
                  JOptionPane.showMessageDialog(null, "EnterDetails","Success",
                                      JOptionPane.INFORMATION_MESSAGE);
                  ad=new Page2_1();
                  try 
                  {
                    ad.Add();
                  } 
                  catch (        ClassNotFoundException | SQLException ex) 
                  {
                    Logger.getLogger(Login1.class.getName()).log(Level.SEVERE, null, ex);
                  }
            }
        }
     }    
}