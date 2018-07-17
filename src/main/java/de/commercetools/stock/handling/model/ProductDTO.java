package de.commercetools.stock.handling.model;

import java.util.Date;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ProductDTO {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("timestamp")
	private Date timestamp;
	
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("quantity")
	private int quantity;
	
	public ProductDTO() {

	}
	
	public ProductDTO(String id, Date timestamp, String productId, int quantity) {
		super();
		this.id = id;
		this.timestamp = timestamp;
		this.productId = productId;
		this.quantity = quantity;
	}
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	@JsonSerialize
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
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
