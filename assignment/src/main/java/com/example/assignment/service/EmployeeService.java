package com.example.assignment.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.assignment.Repository.EmployeeRepository;
import com.example.assignment.entity.Employee;


@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee emp) {   //same method can be used for update also
		return repository.save(emp);
	}
	
	public List<Employee> findAllEmployee() {
		return repository.findAll();
	}
	
	public Employee findEmployeeById(int id) {
		Optional<Employee> optional=repository.findById(id);
		return optional.get();
	}
	
	public void deleteEmployeeById(int id) {
		repository.deleteById(id);
	}
	
	public List<Employee> findByName(String name){
		return repository.findByName(name);
	}
	
	public List<Employee> findByDept(String dept){
		return repository.findByDept(dept);
	}
	
	public List<Employee> findByPhone(long phone){
		return repository.findByPhone(phone);
	}
	
	public List<Employee> findByEmail(String email){
		return repository.findByEmail(email);
	}
	
	public Employee updateEmployee(int id, Employee emp) {

	    Employee existing = repository.findById(id)
	            .orElseThrow(() -> new RuntimeException("Employee not found"));

	    existing.setName(emp.getName());
	    existing.setPhone(emp.getPhone());
	    existing.setEmail(emp.getEmail());
	    existing.setSalary(emp.getSalary());
	    existing.setDept(emp.getDept());

	    return repository.save(existing);
	}
	
}
