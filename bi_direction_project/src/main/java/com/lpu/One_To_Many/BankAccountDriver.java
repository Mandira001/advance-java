package com.lpu.One_To_Many;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BankAccountDriver {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Account a1 = new Account();
		a1.setName("Raju");
		
		Account a2 = new Account();
		a2.setName("Ravi");
		
		Bank b = new Bank();
		b.setName("KOTAK");
		b.setLoc("Pune");
		
		 b.addAccount(a1);
	     b.addAccount(a2);

	        et.begin();
	        em.persist(b);   // ONLY ONE persist needed
	        et.commit();
	}
}
