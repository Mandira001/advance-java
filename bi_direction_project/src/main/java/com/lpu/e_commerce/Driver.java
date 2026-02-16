package com.lpu.e_commerce;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class Driver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Customer c = new Customer();
		c.setId(10);
		
		Orders o1 = new Orders();
		o1.setId(101);
		
		Orders o2 = new Orders();
		o2.setId(102);
		
		Products p1 = new Products();
		p1.setId(1001);
		
		Products p2 = new Products();
		p2.setId(1002);
		
		Categories cat = new Categories();
		cat.setId(10001);
		
		Delivery d = new Delivery();
		d.setId(100001);
		
		et.begin();
		em.persist(c);
		em.persist(o1);
		em.persist(o2);
		em.persist(p1);
		em.persist(p2);
		em.persist(cat);
		em.persist(d);
		et.commit();
	}
}
