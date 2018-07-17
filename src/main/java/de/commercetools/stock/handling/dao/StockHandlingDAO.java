package de.commercetools.stock.handling.dao;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import de.commercetools.stock.handling.model.TopAvailableProductsDTO;
import de.commercetools.stock.handling.model.TopSellingProductsDTO;

@Repository
public class StockHandlingDAO {
	
	@Autowired
    private JdbcTemplate jdbcTemplate;
	
	@SuppressWarnings("rawtypes")
	public List<TopAvailableProductsDTO> getTopAvailableProductsForToday(){
		
		List<TopAvailableProductsDTO> products = new ArrayList<TopAvailableProductsDTO>();
		          
		        String sql = "select * from product \r\n" + 
		        		"where timestamp::date = CURRENT_DATE\r\n" + 
		        		"order by quantity desc limit 3";
		        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		                for (Map row : rows) {
		                	TopAvailableProductsDTO product = new TopAvailableProductsDTO();
		                    product.setId((String)(row.get("ID")));
		                    product.setProductId((String)row.get("product_Id"));
		                    product.setQuantity((Integer)row.get("quantity"));
		                    product.setTimestamp(dateToString((Date)row.get("timestamp")));
		                    products.add(product);
		                }
						return products;


	}
	
	@SuppressWarnings("rawtypes")
	public List<TopAvailableProductsDTO> getTopAvailableProductsForLastMonth(){
		
		List<TopAvailableProductsDTO> products = new ArrayList<TopAvailableProductsDTO>();
		          
		        String sql = "SELECT *\r\n" + 
		        		"FROM product \r\n" + 
		        		"WHERE timestamp >= date_trunc('month', current_date - interval '1' month)\r\n" + 
		        		"  and timestamp < date_trunc('month', current_date) \r\n" + 
		        		"  order by quantity desc\r\n" + 
		        		"  limit 3";
		        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		                for (Map row : rows) {
		                	TopAvailableProductsDTO product = new TopAvailableProductsDTO();
		                    product.setId((String)(row.get("ID")));
		                    product.setProductId((String)row.get("product_Id"));
		                    product.setQuantity((Integer)row.get("quantity"));
		                    product.setTimestamp(dateToString((Date)row.get("timestamp")));
		                    products.add(product);
		                }
						return products;


	}
	
	@SuppressWarnings("rawtypes")
	public List<TopSellingProductsDTO> getTopSellingProductsForToday(){
		
		List<TopSellingProductsDTO> products = new ArrayList<TopSellingProductsDTO>();
		          
		        String sql = "select * from product_sales\r\n" + 
		        		"where timestamp::date = CURRENT_DATE\r\n" + 
		        		"order by items_sold desc limit 3";
		        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
		                for (Map row : rows) {
		                	TopSellingProductsDTO product = new TopSellingProductsDTO();
		                    product.setProductId((String)row.get("product_Id"));
		                    product.setItemsSold((Integer)row.get("items_sold"));
		                    products.add(product);
		                }
						return products;


	}
	
	
	@SuppressWarnings("rawtypes")
	public List<TopSellingProductsDTO> getTopSellingProductsForLastMonth(){
			
			List<TopSellingProductsDTO> products = new ArrayList<TopSellingProductsDTO>();
			          
			        String sql = "select * from product_sales\r\n" + 
			        		"WHERE timestamp >= date_trunc('month', current_date - interval '1' month)\r\n" + 
			        		"and timestamp < date_trunc('month', current_date) \r\n" + 
			        		"order by items_sold desc limit 3";
			        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);
			                for (Map row : rows) {
			                	TopSellingProductsDTO product = new TopSellingProductsDTO();
			                    product.setProductId((String)row.get("product_Id"));
			                    product.setItemsSold((Integer)row.get("items_sold"));
			                    products.add(product);
			                }
							return products;
	
	
		}

	public static String dateToString(Date date)
	{
		DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
		return formatter.format(date);
		
	}
	

}
