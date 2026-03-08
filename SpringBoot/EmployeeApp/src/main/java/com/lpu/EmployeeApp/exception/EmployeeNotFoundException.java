package com.lpu.EmployeeApp.exception;

public class EmployeeNotFoundException extends RuntimeException{
	public EmployeeNotFoundException(String message) {
		super(message);
	}
}
