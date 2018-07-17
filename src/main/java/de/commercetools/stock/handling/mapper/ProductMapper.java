package de.commercetools.stock.handling.mapper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import de.commercetools.stock.handling.entity.ProductEntity;
import de.commercetools.stock.handling.model.ProductByIdDTO;
import de.commercetools.stock.handling.model.ProductDTO;
import de.commercetools.stock.handling.model.StatisticsDTO;
import de.commercetools.stock.handling.model.StockDTO;
import de.commercetools.stock.handling.model.TopAvailableProductsDTO;
import de.commercetools.stock.handling.model.TopSellingProductsDTO;

public class ProductMapper {
	
	public static ProductEntity mapNewProduct(ProductDTO product)
	{
		ProductEntity productEntity = new ProductEntity();
		productEntity.setId(product.getId());
		productEntity.setProductId(product.getProductId());
		productEntity.setQuantity(product.getQuantity());
		productEntity.setTimestamp(product.getTimestamp());
		
		return productEntity;
	}
	
	public static ProductByIdDTO mapProductToDTO(ProductEntity productEntity, String calendarDate)
	{
		StockDTO stockDTO= new StockDTO();
		stockDTO.setId(productEntity.getId());
		stockDTO.setTimestamp(dateToString(productEntity.getTimestamp()));
		stockDTO.setQuantity(productEntity.getQuantity());
		
		ProductByIdDTO productByIdDTO =new ProductByIdDTO(productEntity.getProductId(), calendarDate, 
				stockDTO);
		
		return productByIdDTO;
		
	}

	public static StatisticsDTO mapProductForStatistics(List<TopAvailableProductsDTO> topAvailableProducts, List<TopSellingProductsDTO> topSellingProductsDTO, String time, String calender) {
		
		StatisticsDTO statisticsDTO = new StatisticsDTO(calender, time, topAvailableProducts, topSellingProductsDTO);

		return statisticsDTO;
	}
	
	public static String getCurrentTimestamp() {
	    final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    // Convert timestamp to instant
	    final Instant instant = timestamp.toInstant();
	    return instant.toString();
	  }
	
	public static String dateToString(Date date)
	{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatter.format(date);
		
	}

}
