package com.cg.capstore.controller;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class StoreTempData {
	
	@Id
	private String customerEmail;
	private String password;
	private String friendEmail;
	public String getCustomerEmail() {
		return customerEmail;
	}
	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
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
		return "StoreTempData [customerEmail=" + customerEmail + ", password=" + password + ", friendEmail="
				+ friendEmail + "]";
	}
	
	

}
