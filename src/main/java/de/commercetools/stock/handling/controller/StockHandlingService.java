package de.commercetools.stock.handling.controller;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.commercetools.stock.handling.dao.StockHandlingDAO;
import de.commercetools.stock.handling.mapper.ProductMapper;
import de.commercetools.stock.handling.model.ProductByIdDTO;
import de.commercetools.stock.handling.model.ProductDTO;
import de.commercetools.stock.handling.model.StatisticsDTO;
import de.commercetools.stock.handling.model.TopAvailableProductsDTO;
import de.commercetools.stock.handling.model.TopSellingProductsDTO;
import de.commercetools.stock.handling.repository.StockHandlingRepository;

@Service
public class StockHandlingService {
	
	 private static final Logger LOGGER = LogManager.getLogger(StockHandlingService.class);
	
	@Autowired
	private StockHandlingRepository stockRepository;
	
	@Autowired
	private StockHandlingDAO stockHandlingJDBC;
	
	public ProductDTO createProducts(ProductDTO product)
	{
		stockRepository.save(ProductMapper.mapNewProduct(product));
		return product;
	}

	public ProductByIdDTO getProductDetailsForProductId(String productId, String calendarDate) {
		
		ProductByIdDTO productByIdDTO = ProductMapper.mapProductToDTO(stockRepository.getByProductId(productId), calendarDate);
		return productByIdDTO;
	}

	public StatisticsDTO getStatistics(String time, String calendarDate) {
		
		StatisticsDTO statisticsDTO =new StatisticsDTO();
		try
		{
		if(time.equals("today"))
		{
			List<TopSellingProductsDTO> productSale = stockHandlingJDBC.getTopSellingProductsForToday();
			List<TopAvailableProductsDTO> product= stockHandlingJDBC.getTopAvailableProductsForToday();
			statisticsDTO=ProductMapper.mapProductForStatistics(product, productSale,time, calendarDate);
		}
		else if(time.equals("lastMonth"))
		{
			List<TopSellingProductsDTO> productSale = stockHandlingJDBC.getTopSellingProductsForLastMonth();
			List<TopAvailableProductsDTO> product= stockHandlingJDBC.getTopAvailableProductsForLastMonth();
			statisticsDTO=ProductMapper.mapProductForStatistics(product, productSale, time, calendarDate);
		}
		
		else
		{
			return null;
		}
		}
		catch(Exception e)
		{
			LOGGER.error(e.getMessage());
		}
		return statisticsDTO;
	}
	
	public static String getCurrentTimestamp() {
	    final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    // Convert timestamp to instant
	    final Instant instant = timestamp.toInstant();
	    return instant.toString();
	  }
	
	
	
}
