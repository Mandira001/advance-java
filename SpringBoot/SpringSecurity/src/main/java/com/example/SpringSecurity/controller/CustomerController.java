package com.example.SpringSecurity.controller;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringSecurity.entity.Customer;
import com.example.SpringSecurity.service.CustomerService;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class CustomerController {
	private final CustomerService service;

	public CustomerController(CustomerService service) {
		super();
		this.service = service;
	}
	
	//for GetMapping csrf token is not required, for other mapping token is required
	//this method will generate the csrf token
	@GetMapping("/csrf")
	public CsrfToken csrf(CsrfToken token) {
		return token;
	}
	
	@PostMapping("/save")
	public String save() {
		return "saved";
	}
	
	@PostMapping("/register")
	public Customer registerController(@RequestBody Customer customer) {
		return service.registerCustomer(customer);
	}
	
	@GetMapping("/public")
	public String homePage() {
		return "public page";
	}
	
	@GetMapping("/account")
	public String accountPage() {
		return "Account Page";
	}
	
	@GetMapping("/delete") //--->only admin
	public String deletePage() {
		return "Page Deleted";
	}
	
	@GetMapping("/update") //---> only admin
	public String updatePage() {
		return "Page Updated";
	}
	
	@DeleteMapping("/deleteById/{id}")
	public String deletebyId(@PathVariable int id) {
		service.deleteCustomerById(id);
		return "deleted";
	}
	
	@GetMapping("/findById/{id}")
	public Customer findById(@PathVariable int id) {
		return service.findCustomerById(id);
	}
	
	
}
