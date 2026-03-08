package com.example.SpringSecurity.service;

import java.util.Collection;
import java.util.Collections;

import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.SpringSecurity.entity.Customer;


public class CustomerUserDetails implements UserDetails {
	private Customer customer;  //customer details are fetched from database
	
	public CustomerUserDetails(Customer customer) {
		super();
		this.customer = customer;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority(customer.getRole()));
	}

	@Override
	public @Nullable String getPassword() {
		// TODO Auto-generated method stub
		return customer.getPass();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return customer.getName();
	}
	
	
}
