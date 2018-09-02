package com.cg.capstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class InviteFriendFrontController {
	
	@RequestMapping(value="/inviteFriend")
	public String transferControl() {
		//sending JSP page name
		return "inviteFriend";	
	}
	
}
