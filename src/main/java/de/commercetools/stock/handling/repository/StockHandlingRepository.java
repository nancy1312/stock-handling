package de.commercetools.stock.handling.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import de.commercetools.stock.handling.entity.ProductEntity;

public interface StockHandlingRepository extends CrudRepository<ProductEntity,String>{
	
	@Query("select p from ProductEntity p where p.productId = :productId")
	public ProductEntity getByProductId(@Param("productId") String productId);


}
