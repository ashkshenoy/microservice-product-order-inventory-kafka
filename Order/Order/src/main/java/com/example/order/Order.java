package com.example.order;
import jakarta.persistence.*;

@Entity
@Table(name ="Orders")
public class Order {
    @Id
    
    private String id;
    private String productId;
    private int quantity;
    public Order() {
		
	}
	// Getters and setters
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
    
}
