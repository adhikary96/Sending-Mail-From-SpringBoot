package com.cg.capstore.bean;

import java.util.List;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WishlistBean {
	
	private String wishlistId;
	private List<ProductBean> product;

	public String getWishlistId() {
		return wishlistId;
	}

	public void setWishlistId(String wishlistId) {
		this.wishlistId = wishlistId;
	}

	public List<ProductBean> getProductId() {
		return product;
	}

	public void setProductId(List<ProductBean> productId) {
		this.product = productId;
	}

	public WishlistBean(String wishlistId, List<ProductBean> productId) {
		super();
		this.wishlistId = wishlistId;
		this.product = productId;
	}
	public WishlistBean() {
		
	}
	
}