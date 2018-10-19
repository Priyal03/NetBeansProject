package Front;

import com.sun.mail.smtp.SMTPTransport;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Date;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Priyal
 */
public class Send extends javax.swing.JFrame implements ActionListener
{
    JFrame mainframe=new JFrame("GClient");
    JPanel mainpanel=new JPanel();
    JLabel tolabel=new JLabel("Recipient",JLabel.CENTER);
    JTextField totext=new JTextField(30);
    JLabel sublabel=new JLabel("Subject",JLabel.CENTER);
    JTextField subtxt=new JTextField(100);
    JLabel passlabel=new JLabel("Password",JLabel.CENTER);
    JPasswordField passtxt=new JPasswordField(30);

    JTextArea msgtext=new JTextArea(20,20);
    JScrollPane scr = new JScrollPane(msgtext,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    JLabel msglabel=new JLabel("Message",JLabel.CENTER);
    JButton insertsubmit=new JButton("Send");
    Connection conn;
   // Login1 l1=new Login1();
                JTextField na;
  //  String name = Front.Login1.id;
    public Send()
    {
       
        Dial();
    }
    private void Dial()
    {
        initComponents();
         mainpanel.setLayout(null);
           this.na = Login1.t;
           mainframe.add(mainpanel);
           mainframe.setSize(900,600);
           
           tolabel.setForeground(Color.GREEN);
           passlabel.setForeground(Color.GREEN);
           sublabel.setForeground(Color.GREEN);
           msglabel.setForeground(Color.GREEN);
           
           tolabel.setBackground(Color.GRAY);
           passlabel.setBackground(Color.GRAY);
           sublabel.setBackground(Color.GRAY);
           msglabel.setBackground(Color.GRAY);
           System.out.println(na);
                tolabel.setOpaque(true);
                passlabel.setOpaque(true);
                sublabel.setOpaque(true);
                msglabel.setOpaque(true);
                                
                tolabel.setBounds(80, 50, 100, 40);
                passlabel.setBounds(500, 50, 100,40);
                sublabel.setBounds(80, 130, 100,40);
                msglabel.setBounds(80, 210, 100,40);
                                
                totext.setBounds(200, 50, 200,40);
                passtxt.setBounds(620, 50, 200, 40);
                subtxt.setBounds(200, 130, 620,40);
                msgtext.setBounds(200, 210, 620,200); 
                msgtext.setLineWrap(true);
                msgtext.setWrapStyleWord(true);
                scr.setBounds(300, 220, 100, 10);
                
                insertsubmit.setBounds(120, 450, 100, 30);
                mainpanel.add(tolabel);
                mainpanel.add(totext);
                mainpanel.add(sublabel);
                mainpanel.add(subtxt);
                mainpanel.add(msglabel);
                mainpanel.add(msgtext);
                mainpanel.add(scr);
                mainpanel.add(passlabel);
                mainpanel.add(passtxt);
                mainpanel.add(insertsubmit);
             

        
                mainframe.add(mainpanel);
                
                 insertsubmit.addActionListener((ActionListener) this);
                 mainframe.setVisible(true);
                 mainframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
                 public void actionPerformed(ActionEvent arg0) 
                {
                   if(insertsubmit==arg0.getSource())
                   {
                       String toid=totext.getText();
                       char[] pass=passtxt.getPassword();
                       String sub=subtxt.getText();
                       String message=msgtext.getText();                                             
                       String password=String.valueOf(pass);
                       String from=na.getText();
                     /*  Statement st;
                       ResultSet rs;
                       try {
                           st = conn.createStatement();
                           rs=st.executeQuery("select uid from page1");
                       } catch (SQLException ex) {
                           Logger.getLogger(Send.class.getName()).log(Level.SEVERE, null, ex);
                       }*/
                      
                       try
                        {
                                Properties props = System.getProperties();
                                props.put("mail.smtps.host","smtp.gmail.com");
                                props.put("mail.smtps.auth","true");
                                Session session = Session.getInstance(props, null);
                                Message msg = new MimeMessage(session);
                                msg.setFrom(new InternetAddress(from));
                                System.out.println(from);
                                msg.setRecipients(Message.RecipientType.TO,
                                InternetAddress.parse(toid, false));
                                msg.setSubject(sub+System.currentTimeMillis());
                                msg.setText(message);
                                msg.setHeader("Mailer", "Tov Are's program");
                                msg.setSentDate(new Date());
                                SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
                                t.connect("smtp.gmail.com", from, password);
                                t.sendMessage(msg, msg.getAllRecipients());
                                System.out.println("Response: " + t.getLastServerResponse());
                                t.close();
                         }
                        catch(MessagingException e)
                        {
                            System.out.println(e);
                        }
                        totext.setText("");
                        subtxt.setText("");
                        msgtext.setText("");
                        JOptionPane.showMessageDialog(null, "Your message has been sent","Success",
                                       JOptionPane.INFORMATION_MESSAGE);
                   }
                   else
                   {
                       JOptionPane.showMessageDialog(null, "Some error occured, message not sent","Success",
                                       JOptionPane.INFORMATION_MESSAGE);
                   }
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Send.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                //System.out.println(na);
                Send send = new Send();
                
                }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
