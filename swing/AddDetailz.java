

package Front;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Priyal
 */
public class AddDetailz extends javax.swing.JFrame implements ActionListener
{
    Connection conn = null;
    Statement stmt = null;

    JFrame mainframe=new JFrame("Database Operation");
    JPanel mainpanel=new JPanel();
   
    JButton insertbtn=new JButton("Insert");
 
    JFrame insertframe=new JFrame("Insert into Database");
    
    JPanel insertpanel=new JPanel();
    
    JLabel uidlabel=new JLabel(" uid");
    JTextField uidtext=new JTextField(30);
    
    JLabel passlabel=new JLabel(" pass");
    JPasswordField passtext=new JPasswordField(30);
    
    JButton insertsubmit=new JButton("Submit");
    public void Add()
    {
            mainwindow();
    }
    public void mainwindow()
    {
                mainpanel.setBackground(Color.GRAY);
                mainpanel.setLayout(null);
                insertbtn.setBounds(300, 300, 100, 30);
               
                mainpanel.add(insertbtn);
              
                mainframe.add(mainpanel);
                mainframe.setSize(1300, 700);
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setVisible(true);
                insertbtn.addActionListener((ActionListener) this); 
    }  
    public void insertwindow()
    {
            insertpanel.setBackground(Color.GRAY);
            uidlabel.setForeground(Color.WHITE);
            passlabel.setForeground(Color.WHITE);
            insertpanel.setLayout(null);
            uidlabel.setBounds(400, 150, 100, 20);
            uidtext.setBounds(550, 150, 150, 30);
            passlabel.setBounds(400, 200, 100, 20);
            passtext.setBounds(550, 200, 150, 30);

            insertsubmit.setBounds(490, 300, 100, 30);
            insertpanel.add(uidlabel);

            insertpanel.add(uidtext);
            insertpanel.add(passlabel);
            insertpanel.add(passtext);

            insertpanel.add(insertsubmit);
        
            insertframe.add(insertpanel);

            insertframe.setSize(1350, 700);
            insertframe.setVisible(true);
            insertframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            insertsubmit.addActionListener((ActionListener) this);
            insertframe.addWindowListener(new WindowAdapter()
            {
             public void windowClosing(WindowEvent e)
             {
                mainframe.setVisible(true);
             }
           });
          }
          public void insertdata(String uid, String pass)
          {
                try
                {
                    Statement st=conn.createStatement();
                    st.executeUpdate("insert into page1 values('"+uid+"','"+pass+"')");
                  JOptionPane.showConfirmDialog(null, "Your Data Has been Inserted", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.PLAIN_MESSAGE);
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
                   if(arg0.getSource()==insertbtn)
                   {
                        mainframe.setVisible(false);
                        insertwindow();
                   }
                   if(arg0.getSource()==insertsubmit)
                   {
                       String uid=uidtext.getText();
                       String pass=passtext.getText();
                        try
                        {
                            OpenDatabase();
                            insertdata(uid,pass);

                           CloseDatabase();
                         }
                        catch(Exception e)
                        {
                            System.out.println(e);
                        }
                        uidtext.setText("");
                        passtext.setText("");
                   }
                }
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
            java.util.logging.Logger.getLogger(AddDetailz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                AddDetailz ad=new AddDetailz();
                ad.Add();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
