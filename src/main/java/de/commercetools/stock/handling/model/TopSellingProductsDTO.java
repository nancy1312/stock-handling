package de.commercetools.stock.handling.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TopSellingProductsDTO {
	
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("itemsSold")
	private int itemsSold;
	
	public TopSellingProductsDTO() {

	}

	public TopSellingProductsDTO(String productId, int itemsSold) {
		super();
		this.productId = productId;
		this.itemsSold = itemsSold;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getItemsSold() {
		return itemsSold;
	}

	public void setItemsSold(int itemsSold) {
		this.itemsSold = itemsSold;
	}
	

}
