package com.lpu.OneToOne;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UpdateCarEngine {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
        Car c = em.find(Car.class, 10);  //fetch student from db with id
		
		c.setName("BMW");  //Assign new value
		
		Engine e = c.getEngine();  //fetching Adhaar from person
		
		e.setCc("1500cc");
		et.begin();
		em.merge(c);//call update method
		em.merge(e);
		et.commit();
		
		System.out.println("updated");
	}
}
