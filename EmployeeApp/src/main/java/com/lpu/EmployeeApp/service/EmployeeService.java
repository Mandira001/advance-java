package com.lpu.EmployeeApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.EmployeeApp.dto.EmployeeDTO;
import com.lpu.EmployeeApp.entity.Company;
import com.lpu.EmployeeApp.entity.Employee;
import com.lpu.EmployeeApp.exception.CompanyNotFoundException;
import com.lpu.EmployeeApp.exception.EmployeeNotFoundException;
import com.lpu.EmployeeApp.repository.EmployeeRepository;
@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	
	public Employee findEmployeeById(int id) {
		return repository.findById(id).orElseThrow(
				()-> new EmployeeNotFoundException("employee with id "+id+" not exists"));
	}
	
	public Employee saveEmpAndMapWitCom(Employee emp) {
		emp.getCompany();//.forEach((emp)->emp.setCompany(company));
		return repository.save(emp);
	}
	
	///EmployeeDTO layer imp
	public EmployeeDTO saveEmp(EmployeeDTO dto) {
		Employee emp = DTOToEntity(dto);
		Employee employee = repository.save(emp);//DB
		return entityToDTO(emp);
	}
	
	public EmployeeDTO entityToDTO(Employee emp) {
		EmployeeDTO dto = new EmployeeDTO();
		dto.setAge(emp.getAge());
		dto.setEmail(emp.getEmail());
		dto.setName(emp.getName());
		dto.setPhone(emp.getPhone());
		return dto;
	}
	
	public Employee DTOToEntity(EmployeeDTO dto) {
		Employee emp = new Employee();
		emp.setAge(dto.getAge());
		emp.setEmail(dto.getEmail());
		emp.setName(dto.getName());
		emp.setPhone(dto.getPhone());
		return emp;
	}
}
