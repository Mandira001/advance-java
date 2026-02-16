package com.lpu.OneToMany;

import java.util.ArrayList;
import java.util.List;

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
		a1.setId(101);
		a1.setName("Arpit");
		a1.setBalance(1500);
		
		Account a2 = new Account();
		a2.setId(102);
		a2.setName("Ravi");
		a2.setBalance(2000);
		
		Bank b = new Bank();
		b.setId(1002);
		b.setName("SBI");
		b.setLoc("Manali");
		
		List<Account> list = new ArrayList<Account>();//storing accounts inside list
		list.add(a1);
		list.add(a2);
		
		b.setAccounts(list); //giving list of accounts to bank
		
		et.begin();
		em.persist(a1);
		em.persist(a2);
		em.persist(b);
		et.commit();
		
		
		
	}

}
