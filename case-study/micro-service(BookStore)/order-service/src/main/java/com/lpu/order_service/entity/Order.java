package com.lpu.order_service.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="orders") 
public class Order {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column(nullable=false)
	private long bookId;
	
	@Column(nullable=false)
	private String customerName;
	
	@Column(nullable=false)
	private int quantity;
	
	@Column
	private double price;
	
	@Column
	private String status;
	
	@Column
	private LocalDate orderDate;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public LocalDate getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}

	public Order(long id, long bookId, String customerName, int quantity, double price, String status,
			LocalDate orderDate) {
		super();
		this.id = id;
		this.bookId = bookId;
		this.customerName = customerName;
		this.quantity = quantity;
		this.price = price;
		this.status = status;
		this.orderDate = orderDate;
	}

	public Order() {
		super();
	}
	
}
