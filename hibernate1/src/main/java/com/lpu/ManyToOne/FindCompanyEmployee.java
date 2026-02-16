package com.lpu.ManyToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindCompanyEmployee {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
//		Company c = em.find(Company.class, 101);
		
		Employee e = em.find(Employee.class, 10);
		System.out.println("Employee Name: " + e.getName());
		System.out.println("Salary: " + e.getSalary());
		// Access Company through ManyToOne
		System.out.println("Company: " + e.getCompany().getName());
		System.out.println("Location: " + e.getCompany().getLoc());
		
		
	}
}
