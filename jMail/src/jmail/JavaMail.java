package jmail;
import java.io.*;
import java.net.InetAddress;
import java.util.Properties;
import java.util.Date;

import javax.mail.*;

import javax.mail.internet.*;

import com.sun.mail.smtp.*;


public class JavaMail 
{

    public static void main(String args[]) throws Exception {
        Properties props = System.getProperties();
        props.put("mail.smtps.host","smtp.gmail.com");
        props.put("mail.smtps.auth","true");
        Session session = Session.getInstance(props, null);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("priyalpatel94@gmail.com"));;
        msg.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse("dwatsonbynes@gmail.com", false));
        msg.setSubject("Its Working"+System.currentTimeMillis());
        msg.setText("This is test email");
        msg.setHeader("Mailer", "Tov Are's program");
        msg.setSentDate(new Date());
        SMTPTransport t = (SMTPTransport)session.getTransport("smtps");
        t.connect("smtp.gmail.com", "priyalpatel94@gmail.com", "loveuubc");
        t.sendMessage(msg, msg.getAllRecipients());
        System.out.println("Response: " + t.getLastServerResponse());
        t.close();
    }
}