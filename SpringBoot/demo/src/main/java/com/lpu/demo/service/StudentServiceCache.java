package com.lpu.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.lpu.demo.entity.Student;
import com.lpu.demo.exception.ResourceNotFoundException;
import com.lpu.demo.repository.StudentRepository;

@Service
public class StudentServiceCache {
	@Autowired
	private StudentRepository repository;
	
	//Cache data when first fetched
	@Cacheable(value = "students", key = "#id")
	public Student getStudentById(int id) {
		System.err.println("Fetching in DB..."); // just to check cache is working
		return repository.findById(id).
				orElseThrow(()-> new ResourceNotFoundException("Student not found"));
	}
	
	//when adding or updating student, update cache
	@CachePut(value = "students", key = "#result.id")
	public Student addStudent(Student newStudent) {
		return repository.save(newStudent);
	}
	
	//#id->method parameter(student id)
	//so when you call getStudentById(10), cache key = 10.
	@CachePut(value = "students", key = "#result.id")
	public Student updateStudent(int id, Student student) {
		Student existing = getStudentById(id);
		existing.setName(student.getName());
		existing.setPhone(student.getPhone());
		return repository.save(existing);
	}
	
	//#result.id -> means use the returned student object's id after saving
	
	//remove cache when deleting
	@CacheEvict(value = "students", key = "#id")
	public void deleteStudent(int id) {
		repository.deleteById(id);
	}
}
