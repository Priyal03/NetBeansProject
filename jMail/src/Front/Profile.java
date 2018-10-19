/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Front;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Priyal
 */
public class Profile extends javax.swing.JFrame 
{
    Connection conn;
        String sql;
        String eid,password,uname,other;
        JLabel label1=new JLabel();
        
    JFrame mainframe=new JFrame("Add Details");
    JPanel mainpanel=new JPanel();
    JLabel uidlabel=new JLabel("uid",JLabel.CENTER);
    JLabel uidtext=new JLabel();
    JLabel unamelabel=new JLabel("Username",JLabel.CENTER);
    JLabel othe=new JLabel();
    JLabel unametext=new JLabel();
    JLabel passlabel=new JLabel("Password",JLabel.CENTER);
    JLabel passtext=new JLabel();
    JLabel otherids=new JLabel("Additional Ids",JLabel.CENTER);
   
    public void view() throws ClassNotFoundException, SQLException
      {
        Class.forName("com.mysql.jdbc.Driver");
        
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gc","root","");
        try 
        {
            sql = "select uid,pass,un,oth from page1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
                while( rs.next() )
                {
                    eid=rs.getString("uid");
                    password=rs.getString("pass");
                    uname=rs.getString("un");
                    other=rs.getString("oth");
                }
            
        }
        catch (SQLException ex) 
        {
            System.out.println(ex);
        }
        conn.close();
      }

     public void Add() throws ClassNotFoundException, SQLException
    {
        mainframe();         
    }    
    public void mainframe() throws ClassNotFoundException, SQLException
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
           
      label1.setOpaque(false);
      label1.setBounds(20,20,200,60);
      label1.setBackground(Color.GRAY);
      label1.setForeground(Color.GRAY);
      mainframe.add(label1);
                unamelabel.setOpaque(true);
                uidlabel.setOpaque(true);
                passlabel.setOpaque(true);
                otherids.setOpaque(true);  
                
                uidlabel.setBounds(80, 100, 100, 40);
                passlabel.setBounds(80, 180, 100,40);
                unamelabel.setBounds(80, 260, 100,40);
                otherids.setBounds(80,340,100,40);
                
                uidtext.setBounds(200, 100, 200,40);
                passtext.setBounds(200, 180, 200,40);
                unametext.setBounds(200, 260, 200,40);
                othe.setBounds(200,340,200,40);
   
                view();
               
               
                    uidtext.setText(eid);
                    unametext.setText(uname);
                    passtext.setText(password);
                    othe.setText(other);
                label1.setText("Welcome to your Profile, "+uname);
                
                mainpanel.add(uidlabel);
                mainpanel.add(uidtext);
                mainpanel.add(passlabel);
                mainpanel.add(passtext);
                mainpanel.add(unamelabel);
                mainpanel.add(unametext);
                mainpanel.add(otherids);
                mainpanel.add(othe);
                mainframe.add(mainpanel);                
                mainframe.setVisible(true);
                mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          

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
     * @throws java.lang.ClassNotFoundException
     * @throws java.sql.SQLException
     */
    public static void main(String args[]) throws ClassNotFoundException, SQLException 
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
            java.util.logging.Logger.getLogger(Profile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

      Profile pr=new Profile();
      pr.Add();
}    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
