package com.lpu.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.lpu.demo.entity.Student;
@Repository  //internally it is @Component
public interface StudentRepository extends JpaRepository<Student, Integer>{
//DB CRUD methods
	//custom method
	List<Student> findByName(String name);
	Student findByNameAndPhone(String name, long phone);
	
	//custom query
	//using JPQL query
	@Query("select s from Student s where s.name=:n")  
	List<Student> getByName(String n);
	
	@Query("select s from Student s where s.name=:n and s.phone=:p") 
	Student getByNameAndPhone(String n, long p);
	
	//using sql Query
	@Query(nativeQuery = true, value = "select * from student")
	List<Student> getAllStudents();
}
