package com.example.SpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SpringSecurity.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
	Customer findByName(String name);
}
