package com.lpu.Product.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.lpu.Product.entity.Product;
import com.lpu.Product.repo.ProductRepo;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepo repo;

    @PostMapping("/save")
    public Product saveProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @GetMapping("/test")
    public String test() {
        return "Product Service Working";
    }
    
    @GetMapping("/get-product")
    public String getProducts() {
    	return "products : Laptop, Mobile, Book";
    }
    
    int count =0;
    @CircuitBreaker(name = "payment", fallbackMethod = "fallBackMessage")
    public String testService() {
    	//call payment service
    	count++;
    	System.out.println("Service called : " + count);
    	if(count<=3) {
    		return "Request successful: " + count;
    	}
    	
    	throw new RuntimeException("Service failed : " + count);
    	
    }
    
    public String fallBackMessage(Exception ex) {
    	return "payment service is down";
    }
}
