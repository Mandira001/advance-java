package com.lpu.e_commerce;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Delivery {
	@Id
	private int id;
	private String type;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
