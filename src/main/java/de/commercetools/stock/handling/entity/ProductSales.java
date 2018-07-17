package de.commercetools.stock.handling.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ProductSales", catalog="StockHandling")
public class ProductSales {
	
	@Id
	@Column(name="productId")
	private String productId;
	
	@Column(name="itemsSold")
	private int itemsSold;
	
	@Column(name="timestamp")
	private Date timestamp;
	
	public ProductSales() {

	}
	
	public ProductSales(String productId, int itemsSold, Date timestamp) {
		super();
		this.productId = productId;
		this.itemsSold = itemsSold;
		this.timestamp = timestamp;
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
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
