package services;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;

import entity.User;

public class Mail {
	private int code ;
	public int  sendMail(User u ){
		 code = (int) (Math.random() * 100 + 1);
		   try{
	 String host ="smtp.gmail.com" ;
     String user = "evaders2019@gmail.com";
     String pass = "evaders__2019";
     String to = u.getEmail();
     String from = "khalil";
     String subject = "This is confirmation number for your expertprogramming account. Please insert this number to activate your account.";
     String messageText = "your confirmation code is "+code;
     boolean sessionDebug = false;

     Properties props = System.getProperties();
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.host", host);
     props.put("mail.smtp.port", "587");
     props.put("mail.smtp.auth", "true");
     props.put("mail.smtp.starttls.required", "true");
     java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
     Session mailSession = Session.getDefaultInstance(props, null);
     mailSession.setDebug(sessionDebug);
     Message msg = new MimeMessage(mailSession);
     msg.setFrom(new InternetAddress(from));
     InternetAddress[] address = {new InternetAddress(to)};
     msg.setRecipients(Message.RecipientType.TO, address);
     msg.setSubject(subject); msg.setSentDate(new Date());
     msg.setText(messageText);

    Transport transport=mailSession.getTransport("smtp");
    transport.connect(host, user, pass);
    transport.sendMessage(msg, msg.getAllRecipients());
    transport.close();
    System.out.println("message send successfully");
		   }catch(Exception ex)
	        {
	            System.out.println(ex);
	            return code;
	        }
     return code;
		
	}


}
