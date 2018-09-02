package com.cg.capstore.controller;

import java.util.Properties;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public StoreTempData sendInvitation(@RequestBody StoreTempData data) throws MessagingException {
		System.err.println("INTO BACKEND CONTROLLER");
		
		System.err.println("Data CAME IN : "+data);
		sendEmail(data.getFriendEmail());
		System.err.println("Success!! \n Invitation Sent to "+data.getFriendEmail());
		
		return data;
	}
	
	/*private void sendEmail(String friendEmail, String customerEmail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
						
		//helper.setFrom(customerEmail);
		helper.setTo(friendEmail);
		helper.setSubject("Test Mail Dynamic");
		helper.setText("Test Text...");
		
		sender.send(message);
	}*/
	private void sendEmail(String friendEmail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
						
		//helper.setFrom(customerEmail);
		helper.setTo(friendEmail);
		helper.setSubject("Invitation from your friend...");
		helper.setText("Hi "+friendEmail+"\n Buy Products from this website..."
				+ "\n CapStore...");
		
		sender.send(message);
	}
	
}
