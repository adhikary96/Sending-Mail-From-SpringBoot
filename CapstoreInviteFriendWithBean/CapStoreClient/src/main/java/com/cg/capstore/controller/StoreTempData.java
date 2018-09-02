package com.cg.capstore.controller;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreTempData {
	
	private String customerMail;
	private String password;
	private String friendEmail;
	public String getCustomerMail() {
		return customerMail;
	}
	public void setCustomerMail(String customerMail) {
		this.customerMail = customerMail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFriendEmail() {
		return friendEmail;
	}
	public void setFriendEmail(String friendEmail) {
		this.friendEmail = friendEmail;
	}
	@Override
	public String toString() {
		return "StoreTempData [customerMail=" + customerMail + ", password=" + password + ", friendEmail=" + friendEmail
				+ "]";
	}
	
	
	
}
