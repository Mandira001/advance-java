package com.lpu.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.lpu.order_service.entity.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long>{

}
