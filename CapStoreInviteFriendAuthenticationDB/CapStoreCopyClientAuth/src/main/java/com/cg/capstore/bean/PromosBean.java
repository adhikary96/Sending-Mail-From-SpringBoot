package com.cg.capstore.bean;

import java.sql.Date;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PromosBean {

	private String promoCode;
	private Integer discount;
	private Date timePeriod;
	
	public String getPromoCode() {
		return promoCode;
	}
	public void setPromoCode(String promoCode) {
		this.promoCode = promoCode;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public Date getTimePeriod() {
		return timePeriod;
	}
	public void setTimePeriod(Date timePeriod) {
		this.timePeriod = timePeriod;
	}

}