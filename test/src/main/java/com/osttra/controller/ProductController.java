package com.osttra.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.osttra.entity.Product;
import com.osttra.repository.ProductRepository;

@RestController
public class ProductController {

	
	@Autowired
	ProductRepository productRepository;
	
	
	//for testing only 
	@GetMapping("/find")
	public Product find()
	{
		Optional<Product> op= productRepository.findById("p1");
		
		return op.get();
		
	}
	
	@PostMapping("/addproduct")
	public Product addproduct(@RequestBody Product product)
	{
		return productRepository.save(product);
		
	}
	
	
	@GetMapping("/productsinrange")
    public List<Product> getProductsInPriceRange(
        @RequestParam("minPrice") double minPrice,
        @RequestParam("maxPrice") double maxPrice
    ) 
    
	{
        
		return productRepository.findProductsInPriceRange(minPrice, maxPrice);
    }
	
	
	@GetMapping("/productsgreaterthan")
	public List<Product> greaterthan( @RequestParam("greater") double greater)
	{
		return productRepository.findByPriceGreaterThan(greater);
	}
	
	

	
}
