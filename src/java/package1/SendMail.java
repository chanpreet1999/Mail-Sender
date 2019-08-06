/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package package1;

import java.util.Properties;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Chanpreet
 */
public class SendMail {
    public static void send(String to,String sub,String msg,final String user,final String pass)
    {
        Properties p=new Properties();
        
        p.put("mail.smtp.host", "smtp.gmail.com");
        
        p.put("mail.smtp.port", "587");
        p.put("mail.smtp.auth", "true");
        p.put("mail.smtp.starttls.enable", "true");
        
        Session session=Session.getInstance(p,new javax.mail.Authenticator() 
        {
          protected javax.mail.PasswordAuthentication getPasswordAuthentication()
                    {
                        return new javax.mail.PasswordAuthentication(user, pass);
                    }
        
        });
        
        
        try
        {
            MimeMessage message= new MimeMessage(session);
            
            message.setFrom(new InternetAddress(user));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            message.setSubject(sub);
            message.setText(msg);
            
            Transport.send(message);
            
        }catch(Exception e){System.out.println("Error in messgae sending "+e);}
    }
}
