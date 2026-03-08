package com.lpu.EmployeeApp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.EmployeeApp.entity.Company;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.exception.CompanyNotFoundException;
import com.lpu.EmployeeApp.repository.CompanyRepository;
@Service
public class CompanyService {
	@Autowired
	private CompanyRepository repository;
	
	public Company findCompanyById(int id) {
		return repository.findById(id).orElseThrow(
				()-> new CompanyNotFoundException("company with id "+id+" not exists"));
	}
	//it will only save the company
	public Company saveCompany(Company com) {
		return repository.save(com);
	}
	
	//it will save the company and map it with the employees
	public Company saveCompanyAndMapWithEmp(Company company) {
		company.getEmployees().forEach((emp)->emp.setCompany(company));
		return repository.save(company);
	}
	
	public Company saveEmployeeToExistingCompany(int companyId, List<Employee> newEmp) {
		Company company = repository.findById(companyId).orElse(null);
		company.getEmployees().addAll(newEmp);
		return saveCompanyAndMapWithEmp(company);
	}
}
