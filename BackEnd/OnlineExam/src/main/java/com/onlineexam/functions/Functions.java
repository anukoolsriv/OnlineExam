package com.onlineexam.functions;

import java.util.Properties;
import java.util.Random;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class Functions {
//	private static final String String = null;

	public static String generatePassword() {
		int len = 8;
		System.out.println("Generating password using random() : ");
		System.out.print("Your new OTP is : ");

		// A strong password has Cap_chars, Lower_chars,
		// numeric value and symbols. So we are using all of
		// them to generate our password
		String Capital_chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars = "abcdefghijklmnopqrstuvwxyz";
		String numbers = "0123456789";
		String symbols = "!@#$%^&*_=+-/.?<>)";

		String values = Capital_chars + Small_chars + numbers + symbols;

		// Using random method
		Random rndm_method = new Random();

		char[] OTP = new char[len];

		for (int i = 0; i < len; i++) {
			// Use of charAt() method : to get character value
			// Use of nextInt() as it is scanning the value as int
			OTP[i] = values.charAt(rndm_method.nextInt(values.length()));

		}
		System.out.println(OTP);
		return (new String(OTP));

	}

	public static boolean sendEmail(String recepient, String OTP) {

		boolean mailSent = false;
		// Recipient's email ID needs to be mentioned.
		final String email = "reddyharichandana@gmail.com";
		final String password = "chandu@77";

		// Sender's email ID needs to be mentioned
//		String recepient = "anukoolsriv@gmail.com";

		// Assuming you are sending email from localhost
//		String host = "localhost";

		Properties properties = new Properties();

		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");

		// Get system properties
		// Properties properties = System.getProperties();

		// Setup mail server
		// properties.setProperty("mail.smtp.host", host);

		// Get the default Session object.
		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(email, password);
			}

		});

		Message message = prepareMessage(session, email, recepient, OTP);
		try {
			Transport.send(message);
			System.out.println("Sent message successfully....");
			mailSent = true;
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return mailSent;
	}

	private static Message prepareMessage(Session session, String email, String recepient, String OTP) {
		MimeMessage message = new MimeMessage(session);
		try{
		// Set From: header field of the header.
			message.setFrom(new InternetAddress(email));
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
			message.setSubject("Registration Completed!");
			message.setText("Welcome To Eklavya! <br>Your Default Password is" + OTP);			
			return message;
		}
		catch(MessagingException e){
			System.out.println(e);
		}
			return null;
	}
}
