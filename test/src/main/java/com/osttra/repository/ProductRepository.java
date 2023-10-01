package com.osttra.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.osttra.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

	
	// List<Product> findByPriceGreaterThan(Integer price);
	
	@Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> findByPriceGreaterThan(@Param("price") Double price);
	
	@Query("SELECT p FROM Product p WHERE p.price>= :minPrice and p.price<= :maxPrice")
	List<Product> findProductsInPriceRange(@Param("minPrice") Double minPrice, @Param("maxPrice") Double maxPrice);
}
