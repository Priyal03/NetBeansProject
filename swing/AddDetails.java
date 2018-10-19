package Front;

import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.*;

/**
 *
 * @author Priyal
 */
public class AddDetails extends javax.swing.JFrame implements ActionListener
{
    Connection conn = null;
    Statement stmt = null;

    JFrame mainframe=new JFrame("Database Operation");
    JPanel mainpanel=new JPanel();
   
    JButton insertbtn=new JButton("Insert");
    JButton viewbtn=new JButton("View");
    
    JLabel label1=new JLabel("ID: ");
    JLabel label2=new JLabel("Age: ");
    JLabel label3=new JLabel("");
    
    JFrame insertframe=new JFrame("Insert into Database");
    
    JPanel insertpanel=new JPanel();
    
    JLabel idlabel=new JLabel(" uid");
    JTextField idtext=new JTextField(20);
    
    JLabel agelabel=new JLabel(" pass");
    JTextField agetext=new JTextField(20);
    
    JButton insertsubmit=new JButton("Submit");
    
    JFrame viewframe=new JFrame("View Database Data");
    JPanel viewpanel=new JPanel();
    
    Vector datacol=new Vector();
    Vector datarow=new Vector();
           JTable datatable;
           JScrollPane viewdata;  
    public void Add()
    {
            mainwindow();
    }
    public void mainwindow()
    {
                mainpanel.setBackground(Color.GRAY);
                mainpanel.setLayout(null);
                insertbtn.setBounds(300, 300, 100, 30);
                viewbtn.setBounds(800, 300, 100, 30);
                mainpanel.add(insertbtn);
                mainpanel.add(viewbtn);
                mainframe.add(mainpanel);
                mainframe.setSize(1300, 700);
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mainframe.setVisible(true);
                insertbtn.addActionListener((ActionListener) this); 
    }  
    public void insertwindow()
    {
            insertpanel.setBackground(Color.GRAY);
            idlabel.setForeground(Color.WHITE);
            agelabel.setForeground(Color.WHITE);
            insertpanel.setLayout(null);
            idlabel.setBounds(400, 150, 100, 20);
            idtext.setBounds(550, 150, 150, 30);
            agelabel.setBounds(400, 200, 100, 20);
            agetext.setBounds(550, 200, 150, 30);

            insertsubmit.setBounds(490, 300, 100, 30);
            insertpanel.add(idlabel);

            insertpanel.add(idtext);
            insertpanel.add(agelabel);
            insertpanel.add(agetext);

            insertpanel.add(insertsubmit);
            insertpanel.add(viewbtn);
            insertframe.add(insertpanel);

            viewbtn.addActionListener(this);
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
          public void viewwindow()
          {
              datacol.removeAllElements();
              datarow.removeAllElements();
             viewframe.addWindowListener(new WindowAdapter()
            {
             public void windowClosing(WindowEvent e)
             {
                insertframe.setVisible(true);
             }
           });
                OpenDatabase();
                try
                {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select uid,pass from page1");
                    ResultSetMetaData rms=rs.getMetaData();
                    int cols=rms.getColumnCount();
                    for(int i=1;i<=cols;i++)
                    {
                        datacol.addElement(rms.getColumnName(i));
                    }
                    while(rs.next())
                    {
                        Vector row=new Vector(cols);
                        for(int i=1;i<=cols;i++)
                        {
                            row.addElement(rs.getObject(i));
                        }
                        datarow.addElement(row);
                    }
                    datatable=new JTable(datarow,datacol);
                    viewdata=new JScrollPane(datatable);
                }
                catch(SQLException e)
                {
                    JOptionPane.showConfirmDialog(null, "Problem in Database connectivity or Data", "Result", JOptionPane.DEFAULT_OPTION,JOptionPane.WARNING_MESSAGE);
                }
                viewpanel.setBackground(Color.GRAY);
                viewpanel.setLayout(null);
                viewdata.setBounds(20, 50, 1250, 600);
                viewpanel.add(viewdata);
                viewframe.add(viewpanel);
                viewframe.setSize(1350, 700);
                viewframe.setVisible(true);
                viewframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                viewframe.addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        mainframe.setVisible(true);
                    }
                });}
                
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
                    }
                }
                public void actionPerformed(ActionEvent arg0) 
                {
                   if(arg0.getSource()==insertbtn)
                   {
                        mainframe.setVisible(false);
                        insertwindow();
                   }
                   if(arg0.getSource()==viewbtn)
                   {
                        mainframe.setVisible(false);
                        viewwindow();
                   }
                   if(arg0.getSource()==insertsubmit)
                   {
                       String uid=idtext.getText();
                       String pass=agetext.getText();
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
                        idtext.setText("");
                        agetext.setText("");
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                AddDetails ad=new AddDetails();
                ad.Add();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
