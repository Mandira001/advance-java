package com.lpu.ManyToMany;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateStudentSubject {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		CollegeStudent s = em.find(CollegeStudent.class, 10);
		
		List<Subjects> subList = s.getSubjects();
		
		 for(Subjects sub : subList) {

	            if(sub.getName().equals("Java")) {
	                sub.setTrainer("Sandeep");   // update trainer name
	            }
	        }
		 et.commit();
		
	}
}
