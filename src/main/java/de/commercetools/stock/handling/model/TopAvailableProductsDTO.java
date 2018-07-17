package de.commercetools.stock.handling.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class TopAvailableProductsDTO {

	@JsonProperty("id")
	private String id;
	
	@JsonProperty("timstamp")
	private String timestamp;
	
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("quantity")
	private int quantity;
	
	public TopAvailableProductsDTO() {

	}
	
	public TopAvailableProductsDTO(String id, String timestamp, String productId, int quantity) {
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
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
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
