package de.commercetools.stock.handling;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Date;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import de.commercetools.stock.handling.controller.StockHandlingController;
import de.commercetools.stock.handling.model.ProductDTO;
import de.commercetools.stock.handling.repository.StockHandlingRepository;
import de.commercetools.stock.handling.dao.StockHandlingDAO;

@Ignore
@RunWith(SpringRunner.class)
@WebMvcTest(StockHandlingController.class)
public class StockHandlingApplicationTests {
	
	@Autowired
	private MockMvc mvc;
	
	@MockBean
	private StockHandlingRepository repository;
	

	/*@Test
	public void contextLoads() {
		
		ProductDTO products=new ProductDTO();
		products.setId("A001");
		products.setProductId("A200-0022");
		products.setQuantity(28179);
		products.setTimestamp(new Date());
		
		given(repository.getByProductId("A001")).willReturn(products);
		mvc.perform(get("stock?productId=A100-0001").accept(MediaType.APPLICATION_JSON_VALUE)).andExpect(status().isOk())
		.andExpect(jsonPath("$.id", is(1)))
		.andExpect(jsonPath("$.name", is("John")))
		.andExpect(jsonPath("$.age", is(25)));
		
		
	}*/
	
	

}
