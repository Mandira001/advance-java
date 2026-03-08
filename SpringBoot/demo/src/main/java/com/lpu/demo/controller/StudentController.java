package com.lpu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.demo.entity.Student;
import com.lpu.demo.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService service;
	
	@PostMapping("/studentnew")
	public Student save(@RequestBody Student student) {
		return service.saveStudent(student);
	}
	
	@GetMapping("studentnew/{id}")
	public Student fetchStudentById(@PathVariable int id) {
		return service.findStudentById(id);
	}
	
	@DeleteMapping("/studentnew")
	public String deleteStudent(@RequestBody Student student) {
		service.deleteStudent(student);
		return "student deleted";
	}
	
	@GetMapping("/studentnew")
	public List<Student> findAllStudent(){
		return service.findAllStudent();
	}
	
	@DeleteMapping("/studentnew/{id}")
	public String deleteStudentById(@PathVariable int id) {
		service.deleteStudentById(id);
		return "Student deleted with " + id;
	}
	
	@PostMapping("/studentnew/saveAll")
	public List<Student> saveAllStudents(@RequestBody List<Student> students) {
		return service.saveAllStudents(students);
	}
	
	@GetMapping("/studentnew/{name}")
	public List<Student> findStudentByName(@PathVariable String name){
		return service.findStudentByName(name);
	}
	
	@GetMapping("/studentnew/{name}/{phone}")
	public Student findStudentByNameAndPhone(@PathVariable String name, @PathVariable long phone) {
		return service.findStudentByNameAndPhone(name, phone);
	}
	
	@GetMapping("/student/{name}")
	public List<Student> getStudentByName(@PathVariable String name){
		return service.getStudentByName(name);
	}
	
	@GetMapping("/student/{name}/{phone}")
	public Student getStudentByNameAndPhone(@PathVariable String name, @PathVariable long phone) {
		return service.findStudentByNameAndPhone(name, phone);
	}
}
