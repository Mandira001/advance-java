package com.lpu.EmployeeApp.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
//	@ExceptionHandler(ArithmeticException.class)
//	public Map<String, String> handleArithematicEx(ArithmeticException ex){
//		Map<String, String> map=new HashMap<String, String>();
//		map.put("Error", ex.getMessage());
//		map;
//	}
	
	//500 Internal server error
	@ExceptionHandler(ArithmeticException.class)
	public ResponseEntity<Map<String, String>> handleArithematicEx(ArithmeticException ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(map);
	}
	
	//404 not found
//	@ExceptionHandler(CompanyNotFoundException.class)
//	public Map<String, String> handleCompanyNotFoundException(CompanyNotFoundException ex){
//		Map<String, String> map=new HashMap<String, String>();
//		map.put("Error", ex.getMessage());
//		return map;
//	}
	
	@ExceptionHandler(CompanyNotFoundException.class)
	public ResponseEntity<Map<String, String>> handleCompanyNotFoundException(CompanyNotFoundException ex){
		Map<String, String> map=new HashMap<String, String>();
		map.put("Error", ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
	//400 bad request
//	@ExceptionHandler(MethodArgumentNotValidException.class)
//	public Map<String, String> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
//		Map<String, String> map=new HashMap<>();
//		ex.getBindingResult().getFieldErrors()
//		.forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
//		return map;
//	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex){
		Map<String, String> map=new HashMap<>();
		ex.getBindingResult().getFieldErrors()
		.forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(map);
	}
	
	//it will handle all other exceptions which is not mentioned above
	@ExceptionHandler(Exception.class)
	public Map<String, String> handleAllException(Exception ex){
		Map<String, String> map = new HashMap<>();
		map.put("Error", ex.getMessage());
		return map;
	}
}
