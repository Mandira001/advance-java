package com.lpu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class AdharPersonDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Person p = new Person();
		p.setId(10);
		p.setName("ramu");
		
		Adhar a = new Adhar();
		a.setId(101);
		a.setLoc("India");
		
		p.setAdhar(a);//give adhar to person
		a.setPerson(p);//give person to adhar
		
		et.begin();
		em.persist(a);
		em.persist(p);
		et.commit();
	}
}
