package com.cg.capstore.bean;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedbackCommonBean {
	private String id;
	private MerchantBean merchant;
	private CustomerBean customer;
	private String comments;
	private Date date;
		
	public FeedbackCommonBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FeedbackCommonBean(String id,  /*List<CustomerBean>*/ CustomerBean customer, String comments, Date date,  /*List<MerchantBean>*/MerchantBean merchant) {
		super();
		this.id = id;
		this.customer = customer;
		this.comments = comments;
		this.date = date;
		this.merchant = merchant;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	/*public List<CustomerBean> getCustomer() {
		return customer;
	}
	public void setCustomer(List<CustomerBean> customer) {
		this.customer = customer;
	}*/
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	/*public List<MerchantBean> getMerchant() {
		return merchant;
	}
	public void setMerchant(List<MerchantBean> merchant) {
		this.merchant = merchant;
	}	*/
	@Override
	public String toString() {
		return "FeedbackCommon [id=" + id + ", merchant=" + merchant + ", customer=" + customer+ ", comments="
				+ comments + ", date=" + date + "]";
	}

	public MerchantBean getMerchant() {
		return merchant;
	}

	public void setMerchant(MerchantBean merchant) {
		this.merchant = merchant;
	}

	public CustomerBean getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerBean customer) {
		this.customer = customer;
	}	
	
	

}