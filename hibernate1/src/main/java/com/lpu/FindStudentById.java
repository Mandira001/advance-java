package com.lpu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindStudentById {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Student student = em.find(Student.class, 10);  //set primary key as 10, it will help to fetch the data at 10 and store it to student
		
		System.out.println("id=" + student.getStudentId());
		System.out.println("name=" + student.getName());
		System.out.println("phone=" + student.getPhone());
	}
}
