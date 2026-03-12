package com.lpu.Product.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.Product.entity.Product;

public interface ProductRepo extends JpaRepository<Product,Integer>{

}
