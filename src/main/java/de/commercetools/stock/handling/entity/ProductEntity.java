package de.commercetools.stock.handling.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Product", catalog="StockHandling")
public class ProductEntity {
	
	@Id
	@Column(name="id")
	private String id;
	
	@Column(name="productId" , unique=true)
	private String productId;
	
	@Column(name="timestamp")
	private Date timestamp;
	
	@Column(name="quantity")
	private int quantity;
	
	
	public ProductEntity() {
		
	}
		
	public ProductEntity(String id, String productId, Date timestamp, int quantity) {
		super();
		this.id = id;
		this.productId = productId;
		this.timestamp = timestamp;
		this.quantity=quantity;
	}

	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


}



