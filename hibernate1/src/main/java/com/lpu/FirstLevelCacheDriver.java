package com.lpu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FirstLevelCacheDriver {
	public static void main(String[] args) {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	EntityManager em1 = emf.createEntityManager();
	
	em1.find(Student.class, 10); //DB
	em1.find(Student.class, 10); //cache
	em1.find(Student.class, 11); //DB
	
	EntityManager em2 = emf.createEntityManager();
	em2.find(Student.class, 10); //DB
	em2.find(Student.class, 10); //cache
	}
}
