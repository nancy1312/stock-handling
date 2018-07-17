package de.commercetools.stock.handling.model;


import com.fasterxml.jackson.annotation.JsonProperty;


public class ProductByIdDTO {
	
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("requestTimestamp")
	private String requestTimestamp;
	
	@JsonProperty("stock")
	private StockDTO stocks = null;
	
	
	public ProductByIdDTO() {
		
	}
		
	
	public ProductByIdDTO(String productId, String requestTimestamp, StockDTO stocks) {
		super();
		this.productId = productId;
		this.requestTimestamp = requestTimestamp;
		this.stocks = stocks;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getRequestTimestamp() {
		return requestTimestamp;
	}

	public void setRequestTimestamp(String requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}

	public StockDTO getStocks() {
		return stocks;
	}

	public void setStocks(StockDTO stocks) {
		this.stocks = stocks;
	}


}
