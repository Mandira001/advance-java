package com.lpu.User;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.lpu.User.Entity.Product;

@FeignClient("PRODUCT")
public interface ProductFeignClient {
	
	@GetMapping("/product/get-product")
	public String getProducts();
	
	@PostMapping("/product/save")
	public Product saveProduct(@RequestBody Product product);
}
