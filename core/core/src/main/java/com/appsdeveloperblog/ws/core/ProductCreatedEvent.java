package com.appsdeveloperblog.ws.core;

import java.math.BigDecimal;

public class ProductCreatedEvent {
	
	private String productId;
	private String title;
	private double price;
	private Integer quantity;
	
	public ProductCreatedEvent() {
		
	}
	
	public ProductCreatedEvent(String productId, String title, double price, Integer quantity) {
		this.productId = productId;
		this.title = title;
		this.price = price;
		this.quantity = quantity;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
