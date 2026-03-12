package com.lpu.Payment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lpu.Payment.entity.Payment;

public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
