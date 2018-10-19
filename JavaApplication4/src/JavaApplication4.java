/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;



/**
 *
 * @author Priyal
 */
public class JavaApplication4 {
        /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        private void jButton20ActionPerformed(ActionEvent evt)
        {
        Properties props=new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port","465"); 
        props.put("mail.smtp.socketFactory.class","javax.net.SSLSocketFactory");
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.port","465");
         
        Session session=Session.getDefaultInstance(props,
                 new javax.mail.Authenticator() 
                 {
                     protected PasswordAuthentication getPasswordAuthenticaton()
                     {
                        return new PasswordAuthentication("priyalpatel94@gmail.com","loveuubc");
                     }
                 });
         try
         {
             Message message=new MimeMessage(session);
             message.setFrom(new InternetAddress("priyalpatel94@gmail.com"));
             message.setRecipients(Message.RecipientType.TO, InternetAddress.parse("shaileshmpatel176@gmail.com"));
             message.setSubject("priyal here");
             message.setText("uaisgasighslighsgo");
             Transport.send(message);
             JOptionPane.showMessageDialog(null,"Its working");
         }catch(HeadlessException | MessagingException e)
         {
             JOptionPane.showMessageDialog(null,e);
         }
    }

        
    }
    

