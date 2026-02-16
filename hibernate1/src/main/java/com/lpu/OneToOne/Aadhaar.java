package com.lpu.OneToOne;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Aadhaar {
	@Id
	private int id;
	private String location;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	
	
}
