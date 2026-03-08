package com.lpu.mobile.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class MobileDTO {
	
	@NotBlank(message = "Brand name is required")
	private String brand_name;
	
	@NotBlank(message = "Model name is required")
	private String mod_name;
	
	@Min(value = 1000, message = "Price must be atleast 1000")
	private double price;
	
	@Min(value = 1, message = "RAM must be at least 1GB")
	private int ram;
	
	@Min(value = 8, message = "Storage must be at least 8GB")
	private int storage;
	
	@NotBlank(message = "Color is required")
	private String color;
}
