package com.lpu.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Student;
import com.lpu.demo.repository.StudentRepository;

@Service
public class StudentService {
	//business logic
	@Autowired
	private StudentRepository repository;
	
	public Student saveStudent(Student student) {   //same method can be used for update also
		return repository.save(student);
	}
	
	public Student findStudentById(int id) {
		Optional<Student> optional=repository.findById(id);
		return optional.get();   //Optional act like a null pointer exception
		
		//return repository.findById(id).orElse(null); //we can also use it 
	}
	
	public void deleteStudent(Student student) {
		repository.delete(student);
		//repository.deleteById(id); this will take id
	}
	
	public List<Student> findAllStudent() {
		return repository.findAll();
	}
	
	public void deleteStudentById(int id) {
		repository.deleteById(id);
	}
	
	public List<Student> saveAllStudents(List<Student> list){
		return repository.saveAll(list);
	}
	
	public List<Student> findStudentByName(String name){
		return repository.findByName(name);
	}
	
	public Student findStudentByNameAndPhone(String name, long phone) {
		return repository.findByNameAndPhone(name, phone);
	}
	
	@Query("select s from Student s where s.name=:n")  
	public List<Student> getStudentByName(String n){
		return repository.getByName(n);
	}
	
	@Query("select s from Student s where s.name=:n and s.phone=:p") 
	public Student getStudentByNameAndPhone(String n, long p) {
		return repository.getByNameAndPhone(n, p);
	}
}
