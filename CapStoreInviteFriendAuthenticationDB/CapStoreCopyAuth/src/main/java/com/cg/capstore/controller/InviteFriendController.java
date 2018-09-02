package com.cg.capstore.controller;

import java.util.Date;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.bean.CustomerBean;
import com.cg.capstore.service.IInviteFriendService;

@RestController
public class InviteFriendController {
	
	@Autowired
	private IInviteFriendService service;
	
	@Autowired
	private JavaMailSender sender;
	
	@RequestMapping(value="/")
	public String testController() {
		return "<<< BACK REST CONTROLLER IS RUNNING  <br/> POST NO 5501>>>";
	}
	
	@RequestMapping(value="/mailNow", method=RequestMethod.POST)
	public Map<String, String> sendInvitation(@RequestBody Map<String, String> data) throws MessagingException {
		System.err.println("INTO BACKEND CONTROLLER");
		
		Map<String, String> data2 = data;
		
		System.err.println("Data CAME IN : "+data2);
		
		sendEmail(data.get("friendEmail"), data.get("customerName"));
		
		System.err.println("Success!! \n Invitation Sent to "+data2.get("friendEmail"));
		
		return data;
	}
	
	
	private void sendEmail(String friendEmail, String customerName) throws MessagingException {
		
		CustomerBean bean = service.inviteFriend(customerName);
		String username = bean.getEmail();
		String password = bean.getPassword();
		
		Properties properties = new Properties();
		properties.put("mail.smtp.auth", "true");
		properties.put("mail.smtp.starttls.enable", "true");
		properties.put("mail.smtp.host", "smtp.gmail.com");
		properties.put("mail.smtp.port", "587");
		
		Authenticator authenticator = new Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				return new javax.mail.PasswordAuthentication(username, password);
			}
		};
		
		Session session = Session.getInstance(properties, authenticator);
		
		Message msg = new MimeMessage(session);
		msg.setFrom(new InternetAddress(username, false));
		msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(friendEmail));
		msg.setSubject("--- TEST MAIL USING AUTHENTICATION FROM DATABASE ---");
		msg.setContent("Test Message"+new Date(), "text/html");
		
		Transport.send(msg);
						
		/*//helper.setFrom(customerEmail);
		 * MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		helper.setTo(friendEmail);
		helper.setSubject("Invitation from your friend...");
		helper.setText("Hi "+friendEmail+"\n Buy Products from this website..."
				+ "\n CapStore...");
		
		sender.send(message);*/
	}
	
}
