package Front;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Priyal
 */
public class Page1 extends javax.swing.JFrame implements ActionListener
{

     database db;
     Connection con;
    PreparedStatement pst;
    ResultSet rs;       
  //   Connection con;
    //PreparedStatement pst;
    //ResultSet rs;  
    JLabel label1 = new JLabel("", JLabel.CENTER);
    JLabel label  = new JLabel("", JLabel.CENTER);        
    JLabel label3  = new JLabel("", JLabel.CENTER); 
    JLabel label2  = new JLabel("", JLabel.CENTER);  
    JButton x=new JButton();  
    JButton b1=new JButton();  
    JTextField t=new JTextField(40);
    JPasswordField p=new JPasswordField(30);
    Handler handle;         
        

    public Page1()
    {
        JFrame f=new JFrame();
        f.setTitle("GClient");
        initComponents();
       handle=new Handler();
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
      f.add(b1);
         
      t.setBounds(500,180,200,40);
      t.addActionListener((ActionListener)this);
      p.setBounds(500,260,200,40);
      p.addActionListener((ActionListener) this);
      f.add(p);
      f.add(t);
  
      f.setSize(800,600);
      f.setLayout(null);
      f.setVisible(true);  
      f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gc","root","");
            pst=con.prepareStatement("select uid,pass from page1 where 'uid'=? and 'pass'=?");
              
       
      ActionListener actionListener;

         actionListener = new ActionListener() {
             public void actionPerformed(ActionEvent ae)
             {
                 //checks if the button clicked
                 if(ae.getSource()==x)
                 {
                     char[] temp_pwd;
                     temp_pwd = p.getPassword();
                     String pa;
                     pa=String.copyValueOf(temp_pwd);
                     String u=t.getText();
                     System.out.println("Username,Pwd:"+u+"     "+pa);
                     public Boolean checkLogin(String u,String pa)
                     {
                         try
                         {
                             pst.setString(1, u); //this replaces the 1st  "?" in the query for username
                             pst.setString(2, pa);    //this replaces the 2st  "?" in the query for password
                             //executes the prepared statement
                             rs=pst.executeQuery();
                             return rs.next();
                         }
                         catch (SQLException e)
                         {
                             // TODO Auto-generated catch block
                             System.out.println("error while validating"+e);
                             return false;
                         }
                     }
         };
      {
              }
    }

    private void initComponents() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Page1 page1;
                
                    page1 = new Page1();
                   });
        }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


    
