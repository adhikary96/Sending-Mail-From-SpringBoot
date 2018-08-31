package com.cg.capstore.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cg.capstore.service.IInviteFriendService;

@RestController
public class InviteFriendController {
	
	@Autowired
	private IInviteFriendService inviteFriendService;
	
	@Autowired
	private JavaMailSender sender;
		
	@RequestMapping(value="/sendMail", method=RequestMethod.GET)
	public String inviteFriend(String name, String friendEmail) throws MessagingException {
		String customerEmail = inviteFriendService.inviteFriend(name);
		sendInvitationToFriend(friendEmail);
		return "Success, Sending invitation to "+ friendEmail+ "from your mail "+customerEmail ;
	}
	
	private void sendInvitationToFriend(String friendmail) throws MessagingException {
		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		
		//helper.setFrom(customerEmail);
		helper.setTo(friendmail);
		helper.setText("Test Message...");
		helper.setSubject("Inviting You to Buy Products from this website");
		
		sender.send(message);
	}
	
}
