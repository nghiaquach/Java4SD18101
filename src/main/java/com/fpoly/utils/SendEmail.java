package com.fpoly.utils;

import java.io.File;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendEmail {
	private void send(String toEmail, String subject, String body, File attacedFile) {
		// TODO Auto-generated method stub
		final String email = "";
		final String password = ""; //app password
		// set properties tu google mail
		Properties prop = new Properties();
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true"); //TLS
		
		Session session = Session.getDefaultInstance(prop, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}
		});
		//Tao mime message
		Message message = new MimeMessage(session);
		try {
			message.setFrom(new InternetAddress(email));
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
			message.setSubject("Testing Email");
			message.setText("Dear Mr. Nghia," + "\n\n Welcome to my website");
			Transport.send(message);
			System.out.println("Done");
		} catch (AddressException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		SendEmail sendEmail = new SendEmail();
		sendEmail.send("", "", "", null);
	}
	
}
