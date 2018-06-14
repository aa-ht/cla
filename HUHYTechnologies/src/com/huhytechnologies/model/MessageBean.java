package com.huhytechnologies.model;

import java.io.Serializable;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MessageBean implements Serializable{
	
	private String name;
	private String phone;
	private String email;
	private String message;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	} 

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void sendMail() {
		// TODO Auto-generated method stub

		final String username = "contact.huhy@gmail.com";
		final String password = "h956541h#";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setContent(message, "text/html; charset=utf-8");
			message.setFrom(new InternetAddress("interact@huhytechnologies.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse("interact@huhytechnologies.com,"+email));
			message.setSubject(name);
			message.setText("name"+"<br/>"+phone+"<br/>"+email+"<br/>"+this.message+"<br/>");

			Transport.send(message);

			System.out.println("Done");

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}

}
