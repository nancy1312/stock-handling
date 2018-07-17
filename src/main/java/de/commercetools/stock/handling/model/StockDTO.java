package de.commercetools.stock.handling.model;


import com.fasterxml.jackson.annotation.JsonProperty;

public class StockDTO {
	
	@JsonProperty("id")
	private String id;
	
	@JsonProperty("timestamp")
	private String timestamp;
	
	@JsonProperty("quantity")
	private int quantity;
	
	public StockDTO() {

	}
	
	public StockDTO(String id, String timestamp, int quantity) {
		super();
		this.id = id;
		this.timestamp = timestamp;
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
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	

}
