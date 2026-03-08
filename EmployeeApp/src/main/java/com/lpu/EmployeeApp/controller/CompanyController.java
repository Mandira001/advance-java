package com.lpu.EmployeeApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.EmployeeApp.entity.Company;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@GetMapping("/test")
	public String test() {
	    return "Working";
	}
	
	@PostMapping("/company2")
	public Company saveCompany2(@RequestBody Company company) {
		return companyService.saveCompany(company);
	}
	
	@PostMapping("/company")
	public ResponseEntity<Company> saveCompany(@RequestBody Company company) {
		Company body=companyService.saveCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).body(body);
	}
	
	@PostMapping("/mapcompany2")
	public ResponseEntity<Company> saveCompanyWithMapping2(@RequestBody Company company) {
		Company body=companyService.saveCompany(company);
		return new ResponseEntity<Company>(body,HttpStatus.CREATED);
	}
	
	@PostMapping("/mapcompany")
	public Company saveCompanyWithMapping(@RequestBody Company company) {
		return companyService.saveCompanyAndMapWithEmp(company);
	}
	
	@PostMapping("/saveinexisting/{cId}")
	public Company saveEmployeeToExistingCompany(@PathVariable int cId,@RequestBody List<Employee> employee) {
		return companyService.saveEmployeeToExistingCompany(cId, employee);
	}
	
	@GetMapping("/divide/{n1}/{n2}")
	public String divide(@PathVariable int n1, @PathVariable int n2) {
		return "result="+n1/n2;
	}
	
	@GetMapping("/company/{id}")
	public Company findComById(@PathVariable int id) {
		return companyService.findCompanyById(id);
	}
	
	
}
