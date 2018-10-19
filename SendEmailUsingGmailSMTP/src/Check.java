
import java.util.Properties;
import javax.mail.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Priyal
 */
public class Check {
    public static void main(String args[])
    {
    int n;
    Properties prop=new Properties();
    Session session = Session.getInstance(prop,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });

    
    Store store=session.getStore("pop3");
    
    Message message[]=folder.getMessage();
    for(int i=0, n=message.length; i<n);i++)
    {
        System.out.println(i+":"+message[i].getFrom()[0]+"\t\t"+ message[i].getSubject());
        
    }
    folder.close();
    store.close();
    }
}
