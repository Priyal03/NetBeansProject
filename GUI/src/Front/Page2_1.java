package Front;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Priyal
 */
public class Page2_1 extends javax.swing.JFrame implements ActionListener
{
    Connection conn = null;
    Statement stmt = null;

    JFrame mainframe=new JFrame("Add Details");
    JPanel mainpanel=new JPanel();
    JLabel uidlabel=new JLabel("uid",JLabel.CENTER);
    public static JTextField uidtext=new JTextField(30);
    JLabel unamelabel=new JLabel("Username",JLabel.CENTER);
    JTextField other=new JTextField(30);
    JTextField unametext=new JTextField(30);
    JLabel passlabel=new JLabel("pass",JLabel.CENTER);
    JPasswordField passtext=new JPasswordField(30);
    JLabel otherids=new JLabel("Additional Ids",JLabel.CENTER);
    JButton insertsubmit=new JButton("Submit");
    int n=2;
    
    public void Add() throws ClassNotFoundException, SQLException
    {
         mainwindow();
    }    
    public void mainwindow() throws ClassNotFoundException, SQLException 
    {
           mainpanel.setLayout(null);
           mainframe.add(mainpanel);
           mainframe.setSize(800,600);
           
           uidlabel.setForeground(Color.GREEN);
           unamelabel.setForeground(Color.GREEN);
           otherids.setForeground(Color.GREEN);
           passlabel.setForeground(Color.GREEN);
           
           uidlabel.setBackground(Color.GRAY);
           unamelabel.setBackground(Color.GRAY);
           otherids.setBackground(Color.GRAY);
           passlabel.setBackground(Color.GRAY);
           
                unamelabel.setOpaque(true);
                uidlabel.setOpaque(true);
                passlabel.setOpaque(true);
                otherids.setOpaque(true);  
                
                uidlabel.setBounds(80, 50, 100, 40);
                passlabel.setBounds(80, 130, 100,40);
                unamelabel.setBounds(80, 210, 100,40);
                otherids.setBounds(80,290,100,40);
                
                uidtext.setBounds(200, 50, 200,40);
                passtext.setBounds(200, 130, 200,40);
                unametext.setBounds(200, 210, 200,40);                
                other.setBounds(200,290,200,40);                                   
                insertsubmit.setBounds(120, 450, 100, 30);
                
                mainpanel.add(other);
                mainpanel.add(uidlabel);
                mainpanel.add(uidtext);
                mainpanel.add(passlabel);
                mainpanel.add(passtext);
                mainpanel.add(unamelabel);
                mainpanel.add(unametext);
                mainpanel.add(otherids);
                mainpanel.add(insertsubmit);                     
                mainframe.add(mainpanel);
                
                insertsubmit.addActionListener((ActionListener) this);
                 mainframe.setVisible(true);
                 mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
}
    /**
     *
     * @param uid
     * @param pass*
     * @param un
     * @param oth
     * @throws java.lang.ClassNotFoundException*/
public void insertdata(String uid, String pass, String un,String oth) throws ClassNotFoundException
{
    try
    {
        Statement st=conn.createStatement();                                                        
        st.executeUpdate("insert into page1 values('"+uid+"','"+pass+"','"+un+"','"+oth+"')");
        JOptionPane.showConfirmDialog(null, "Details has been Inserted ", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
    } 
    catch(HeadlessException | SQLException e)
    {
        JOptionPane.showConfirmDialog(null, e.getMessage(), "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
    }
}
public void OpenDatabase()
{
    try
    {
        Class.forName("com.mysql.jdbc.Driver");
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gc","root","");
    }
    catch(ClassNotFoundException | SQLException e)
    {
        System.out.println(e);
    }
}
public void CloseDatabase()
{
    try 
    {
        conn.close();
    }
    catch (SQLException e) 
    {
        System.out.println(e);
    }
}
public void actionPerformed(ActionEvent arg0) 
{
    if(arg0.getSource()==insertsubmit)
    {
        String uid=uidtext.getText();
        String pass;
        String un=unametext.getText();
        String oth=other.getText();
        char[] p=passtext.getPassword();
        pass = String.valueOf(p);
        try
        {
            OpenDatabase();
            insertdata(uid,pass,un,oth);
            CloseDatabase();
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        try 
        {                           
            Profile pro=new Profile();
            try 
            {
                pro.add();
            } 
            catch (ClassNotFoundException | SQLException ex) 
            {
                Logger.getLogger(Page2_1.class.getName()).log(Level.SEVERE, null, ex);
            }           
        } 
        catch (               ClassNotFoundException | SQLException ex) 
        {
            Logger.getLogger(Page2_1.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                   
    uidtext.setText("");
    passtext.setText("");
    unametext.setText("");
    other.setText("");                       
    
    mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    mainframe.setVisible(true);                               
}    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Page2_1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
               Page2_1 pg=new Page2_1();
                try 
                {
                    pg.Add();
                } 
                catch (        ClassNotFoundException | SQLException ex) 
                {
                    Logger.getLogger(Page2_1.class.getName()).log(Level.SEVERE, null, ex);
                }
               
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

   
}
