package com.lpu.OneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FetchPerson {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Person person = em.find(Person.class, 102);
//		System.out.println(person.getId());
//		System.out.println(person.getName());
//		
//		Aadhaar aadhaar = new Aadhaar();
//		System.out.println(aadhaar.getId());
//		System.out.println(aadhaar.getLocation());
		
		System.out.println(person);
		Aadhaar a = person.getAadhaar();
		System.out.println(a);
	}
}
