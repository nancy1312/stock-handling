package de.commercetools.stock.handling.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StatisticsDTO {
	
	@JsonProperty("requestTimestamp")
	private String requestTimestamp;
	
	@JsonProperty("range")
	private String range;
	
	@JsonProperty("topAvailableProducts")
	private List<TopAvailableProductsDTO> topAvailableProducts = null;
	
	@JsonProperty("topSellingProducts")
	private List<TopSellingProductsDTO> topSellingProducts = null;
	
	public StatisticsDTO() {

	}
	
	public StatisticsDTO(String requestTimestamp, String range, List<TopAvailableProductsDTO> topAvailableProducts,
			List<TopSellingProductsDTO> topSellingProducts) {
		super();
		this.requestTimestamp = requestTimestamp;
		this.range = range;
		this.topAvailableProducts = topAvailableProducts;
		this.topSellingProducts = topSellingProducts;
	}
	
	public String getRequestTimestamp() {
		return requestTimestamp;
	}
	public void setRequestTimestamp(String requestTimestamp) {
		this.requestTimestamp = requestTimestamp;
	}
	public String getRange() {
		return range;
	}
	public void setRange(String range) {
		this.range = range;
	}
	public List<TopAvailableProductsDTO> getTopAvailableProducts() {
		return topAvailableProducts;
	}
	public void setTopAvailableProducts(List<TopAvailableProductsDTO> topAvailableProducts) {
		this.topAvailableProducts = topAvailableProducts;
	}
	public List<TopSellingProductsDTO> getTopSellingProducts() {
		return topSellingProducts;
	}
	public void setTopSellingProducts(List<TopSellingProductsDTO> topSellingProducts) {
		this.topSellingProducts = topSellingProducts;
	}
	
	

}
