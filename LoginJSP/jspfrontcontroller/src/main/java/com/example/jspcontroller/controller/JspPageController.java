package com.example.jspcontroller.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class JspPageController {
	
	@RequestMapping(value="/login")
	public String transferControl() {
		//sending JSP page name
		return "login";	
	}
	
}
