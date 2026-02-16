package com.lpu.OneToMany;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FindBankAccount {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
		EntityManager em = emf.createEntityManager();
		
		Bank bank = em.find(Bank.class, 1002);
		System.out.println(bank.getId());
		System.out.println(bank.getName());
		System.out.println(bank.getLoc());
		
		List<Account> list = bank.getAccounts();
		for(Account a:list) {
			System.out.println(a.getId());
			System.out.println(a.getName());
			System.out.println(a.getBalance());
		}
	}
}
