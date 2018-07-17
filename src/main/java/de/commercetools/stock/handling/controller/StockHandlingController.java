package de.commercetools.stock.handling.controller;



import java.sql.Timestamp;
import java.time.Instant;
import java.util.Calendar;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import de.commercetools.stock.handling.model.ProductByIdDTO;
import de.commercetools.stock.handling.model.ProductDTO;
import de.commercetools.stock.handling.model.StatisticsDTO;
import de.commercetools.stock.handling.repository.StockHandlingRepository;

@RestController
public class StockHandlingController {
	
	@Autowired
	private StockHandlingService stockHandlingService;
	
	@Autowired
	private StockHandlingRepository stockHandlingRepository;
	
	
	@SuppressWarnings("rawtypes")
	@RequestMapping(method=RequestMethod.POST, value="/updatestock")
	public ResponseEntity addStock(@RequestBody ProductDTO product)
	{
		if(stockHandlingRepository.getByProductId(product.getProductId())!=null)
		{
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}
		else
		{
		stockHandlingService.createProducts(product);
		return new ResponseEntity(HttpStatus.CREATED);
		}
	}
	
	@RequestMapping(value ="/stock" , produces = {"application/json"}, method = RequestMethod.GET)
	public ResponseEntity<ProductByIdDTO> getProductById(@RequestParam("productId") String productId)
	{
		ProductByIdDTO productDTO = stockHandlingService.getProductDetailsForProductId(productId, getCurrentTimestamp());
		if(productDTO!=null)
		{
			return new ResponseEntity<ProductByIdDTO>(productDTO, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<ProductByIdDTO>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@RequestMapping(value="/statistics" , produces = {"application/json"}, method = RequestMethod.GET)
	public ResponseEntity<StatisticsDTO> getStatistics(@RequestParam("time") String time)
	{
		StatisticsDTO statisticsDTO = stockHandlingService.getStatistics(time , getCurrentTimestamp());
		if(statisticsDTO!=null)
		{
			return new ResponseEntity<StatisticsDTO>(statisticsDTO, HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<StatisticsDTO>(statisticsDTO, HttpStatus.NOT_FOUND);
		}
	}
	
	public String getCurrentTimestamp() {
	    final Timestamp timestamp = new Timestamp(System.currentTimeMillis());
	    // Convert timestamp to instant
	    final Instant instant = timestamp.toInstant();
	    return instant.toString();
	  }
	
	
	
	
}
