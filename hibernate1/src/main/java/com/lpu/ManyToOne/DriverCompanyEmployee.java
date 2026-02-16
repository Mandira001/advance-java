package com.lpu.ManyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class DriverCompanyEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Company company = new Company(101, "Capgemini", "Bangalore");
		
		Employee e1 = new Employee(10, "Arpit", "30LPA", company);
		
		Employee e2 = new Employee(20, "Ravi", "20LPA", company);
		
		et.begin();
		em.persist(e1);
		em.persist(e2);
		em.persist(company);
		et.commit();
		
		
		
		
		
	}
}
