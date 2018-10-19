/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Front;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 *
 * @author Priyal
 */
public class ViewDetails extends javax.swing.JFrame 
{
     JFrame viewframe=new JFrame("View Accouunts");
    JPanel viewpanel=new JPanel();
    
    Vector datacol=new Vector();
    Vector datarow=new Vector();
    JTable datatable;
    JScrollPane viewdata;  
    Connection conn;
public void view()
{
          viewwindow();
}
public void viewwindow()
          {
              datacol.removeAllElements();
              datarow.removeAllElements();
         /*    viewframe.addWindowListener(new WindowAdapter()
            {
             public void windowClosing(WindowEvent e)
             {
                insertframe.setVisible(true);
             }
           });*/
                OpenDatabase();
                try
                {
                    Statement st=conn.createStatement();
                    ResultSet rs=st.executeQuery("select uid,un,oth from page1");
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
         /*       viewframe.addWindowListener(new WindowAdapter()
                {
                    public void windowClosing(WindowEvent e)
                    {
                        mainframe.setVisible(true);
                    }
                });} */
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
                public void CloseDatabase() throws SQLException
                {
                    conn.close();
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

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(ViewDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                 ViewDetails pg=new ViewDetails();
               pg.view();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
