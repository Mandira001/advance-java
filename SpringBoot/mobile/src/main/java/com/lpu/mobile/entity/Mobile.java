package com.lpu.mobile.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Mobile {
	@Id
	private int id;
	private String brand_name;
	private String mod_name;
	private double price;
	private int ram;
	private int storage;
	private String color;
	public Mobile() {
		super();
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBrand_name() {
		return brand_name;
	}
	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}
	public String getMob_name() {
		return mod_name;
	}
	public void setMob_name(String mob_name) {
		this.mod_name = mob_name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getRam() {
		return ram;
	}
	public void setRam(int ram) {
		this.ram = ram;
	}
	public int getStorage() {
		return storage;
	}
	public void setStorage(int storage) {
		this.storage = storage;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	
}
