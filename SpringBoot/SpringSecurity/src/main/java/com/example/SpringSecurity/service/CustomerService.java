package com.example.SpringSecurity.service;

import java.util.List;

import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.SpringSecurity.entity.Customer;
import com.example.SpringSecurity.repository.CustomerRepository;

@Service
public class CustomerService {
	private final CustomerRepository repo;
	private final PasswordEncoder encoder;
	
	
	
	public CustomerService(CustomerRepository repo, PasswordEncoder encoder) {
		super();
		this.repo = repo;
		this.encoder = encoder;
	}


//it will save the same password as you give
//	public Customer registerCustomer(Customer customer) {
//		return repo.save(customer);
//	}
	//this will encode the password
	public Customer registerCustomer(Customer customer) {
		String encodedPass = encoder.encode(customer.getPass());
		customer.setPass(encodedPass);//storing encoded password
		return repo.save(customer);
	}
	
	@PostAuthorize("returnObject.name == authentication.name")
	public Customer findCustomerById(int id) {
		return repo.findById(id).get();
	}
	
	public void deleteCustomerById(int id) {
		repo.deleteById(id);
	}
	
	@PreAuthorize("hasRole('ADMIN')")
	public List<Customer> findAllCustomer(){
		return repo.findAll();
	}
	
}
