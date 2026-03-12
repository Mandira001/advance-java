package com.lpu.User.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.User.ProductFeignClient;
import com.lpu.User.Entity.Product;
import com.lpu.User.Entity.User;
import com.lpu.User.repository.UserRepo;

@RestController
@RequestMapping("/user")
public class UserController {
	
//	@Autowired
//	PaymentFeignClient Payment;
	
	@Autowired
	ProductFeignClient productservice;
	
	@GetMapping("/products")
	public String getProductInUser() {
		return productservice.getProducts(); //call product from product service.
	}
	
	@PostMapping("/saveproduct")
	public Product saveProduct(@RequestBody Product product) {
		return productservice.saveProduct(product);
	}
	
	@Autowired
	private UserRepo repo;
	
	@GetMapping("/save")
	public String saveUser() {
		System.err.println("hiiiiiiiii");
		return "User saved";
	}
	@GetMapping("/test")
	public String test(){
	    return "User Service Working";
	}
	
	@GetMapping("/data")
	public String takeData(){
	    return "Data from user service";
	}
	
	 @GetMapping("/{id}")
	 public User getUserById(@PathVariable int id) {
	    return repo.findById(id).orElse(null);
	 }
	 
	 @PostMapping("/saveuser")
	 public User saveUser(@RequestBody User user) {
		 return repo.save(user);
	 }
	 
}
