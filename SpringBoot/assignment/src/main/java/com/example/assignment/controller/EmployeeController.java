package com.example.assignment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.assignment.entity.Employee;
import com.example.assignment.service.EmployeeService;
@RequestMapping("/api")
@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@PostMapping("/employee")
	public Employee save(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}
	
	@GetMapping("/employee")
	public List<Employee> findAllEmployee(){
		return service.findAllEmployee();
	}
	
	@GetMapping("/employee1")
	public Employee fetchEmployeeById(@RequestParam int id) {
		return service.findEmployeeById(id);
	}
	
	@DeleteMapping("/employee")
	public String deleteEmployeeById(@RequestParam int id) {
		service.deleteEmployeeById(id);
		return "Employee deleted with " + id;
	}
	
	@GetMapping("/empname/{name}")
	public List<Employee> findEmployeeByName(@PathVariable String name){
		return service.findByName(name);
	}
	
	@GetMapping("/empdept/{dept}")
	public List<Employee> findEmployeeByDept(@PathVariable String dept){
		return service.findByDept(dept);
	}
	
	@GetMapping("/empphone/{phone}")
	public List<Employee> findEmployeeByPhone(@PathVariable long phone){
		return service.findByPhone(phone);
	}
	
	@GetMapping("/empemail/{email}")
	public List<Employee> findEmployeeByEmail(@PathVariable String email){
		return service.findByEmail(email);
	}
	
	@PutMapping("/empupdate")
	public Employee updateEmployee(@RequestParam int id, @RequestBody Employee emp){
		return service.updateEmployee(id, emp);
	}
}
