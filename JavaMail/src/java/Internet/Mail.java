/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Priyal
 */
 package internet;

        import java.util.*;
        import javax.mail.*;
        import javax.mail.internet.*;
        import javax.activation.*;

        public class Mail
        {
           public static void main(String [] args)
           {


              String to = "priyalpatel94@gmail.com";
              String from = "shaileshmpatel176@gmail.com";


              String host = "smtp.gmail.com";


              Properties properties = System.getProperties();


              properties.put("mail.smtp.host", "smtp.gmail.com");
              properties.put("mail.smtp.port", "587");
              properties.put("mail.smtp.auth", "true");
              properties.put("mail.smtp.starttls.enable", "true");



              Session session = Session.getDefaultInstance(properties);

              try{

                 MimeMessage message = new MimeMessage(session);


                 message.setFrom(new InternetAddress(from));


                 message.addRecipient(Message.RecipientType.TO,
                                          new InternetAddress(to));


                 message.setSubject("This is the Subject Line!");


                 message.setText("This is actual message");


                 Transport.send(message);
                 System.out.println("hi");
                 System.out.println("Sent message successfully....");
              }catch (MessagingException mex) {
                 mex.printStackTrace();
              }
           }
        }
