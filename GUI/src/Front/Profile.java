/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Front;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Priyal
 */
public final class Profile extends javax.swing.JFrame implements ActionListener
{
    Connection conn;
    String sql;
    String eid,password,uname,other;
    JLabel label1=new JLabel();        
    JFrame mainframe=new JFrame("Profile");
    JPanel mainpanel=new JPanel();
    JLabel uidlabel=new JLabel("uid",JLabel.CENTER);
    JLabel uidtext=new JLabel();
    JLabel unamelabel=new JLabel("Username",JLabel.CENTER);
    JLabel othe=new JLabel();
    JLabel unametext=new JLabel();
    JLabel passlabel=new JLabel("Password",JLabel.CENTER);
    JLabel passtext=new JLabel();
    JLabel otherids=new JLabel("Additional Ids",JLabel.CENTER);
    JButton compose=new JButton("Login");
    Login1 s;
    JTextField x;
    String xo;
    Profile() throws ClassNotFoundException, SQLException
            {
                this.x=Page2_1.uidtext;
                xo=x.getText();
                
            }
    public void add() throws ClassNotFoundException, SQLException
    {
        Class.forName("com.mysql.jdbc.Driver");        
        conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gc","root","");
        try 
        {
            sql ="select uid,pass,un,oth from page1 where uid='" + xo +"'" ;
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
        compose.setBounds(300,500, 100, 40);                
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
        mainpanel.add(compose);
        mainframe.add(mainpanel);                
        mainframe.setVisible(true);
        compose.addActionListener((ActionListener) this);
        mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);          
    }
    public void actionPerformed(ActionEvent arg0) 
                {
                   if(arg0.getSource()==compose)
                   {
                        s=new Login1();
                        s.log();
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
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        //</editor-fold>
  //    Profile pr=new Profile();
     //   try {
       //     pr.add();
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
       
}
