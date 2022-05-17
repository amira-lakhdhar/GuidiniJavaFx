/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esprit.com.utils;

import esprit.com.entity.Utilisateur;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Toumi
 */
public class JavaMailUtil {
    public static void sendMail(String recepient,Utilisateur user) throws MessagingException{
        Properties properties= new Properties();
        
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable","true");
        properties.put("mail.smtp.host","smtp.gmail.com");
        properties.put("mail.smtp.port", "587");
        
        String myAccountEmail="Guidini.pidev@gmail.com";
        String password="123azerty.";
        
        Session session= Session.getInstance(properties, new Authenticator(){
           @Override
           protected PasswordAuthentication getPasswordAuthentication(){
               return new PasswordAuthentication(myAccountEmail, password);
           }
        });
        Message message = prepareMessage(session, myAccountEmail, recepient,user);
        Transport.send(message);
        System.out.println("Message sent successfully");
        
    }
    
    private static Message prepareMessage(Session session,String myAccountEmail,String recepient,Utilisateur user) {
         try {
        Message message = new MimeMessage(session);
  
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            message.setSubject("Resotre Password - Guidini Pidev - Esprit");
            message.setText("Salut ,  "+user.getNom()+" ,"
                    + "Votre Mot de passe est : "+user.getMotpass().substring(57, user.getMotpass().length()));
            return message;
        } catch (Exception ex) {
            Logger.getLogger(JavaMailUtil.class.getName()).log(Level.SEVERE, null, ex);
        }
         return null;
    }
    
}
