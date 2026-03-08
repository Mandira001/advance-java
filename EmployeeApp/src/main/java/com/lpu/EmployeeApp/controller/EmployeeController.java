package com.lpu.EmployeeApp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.EmployeeApp.dto.EmployeeDTO;
import com.lpu.EmployeeApp.entity.Company;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
//	@PostMapping("/employee")
//	public ResponseEntity<Employee> saveEmployee(@Valid @RequestBody Employee employee){
//		return ResponseEntity.status(HttpStatus.CREATED)
//		.body(employeeService.saveEmployee(employee));
//		
//	}
	
	@PostMapping("/emp")
	public ResponseEntity<EmployeeDTO> saveEmp(@Valid @RequestBody EmployeeDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED)
		.body(employeeService.saveEmp(dto));
		
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmpById(@PathVariable int id) {
		return employeeService.findEmployeeById(id);
	}
	
	@PostMapping("/mapemployee")
	public Employee saveEmployeeWithMapping(@RequestBody Employee emp) {
		return employeeService.saveEmpAndMapWitCom(emp);
	}
}
