package com.lpu;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class StudentCrudImp implements StudentCRUD {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
EntityManager em = emf.createEntityManager();
EntityTransaction et = em.getTransaction();

@Override
public void saveStudent(Student s) {
	et.begin();
	em.merge(s);
	et.commit();
	System.out.println("Saved");
}

@Override
public void updateStudentName(int id, String name) {
	// TODO Auto-generated method stub
	Student s = em.find(Student.class, id);

        et.begin();
        s.setName(name);     // Dirty Checking will update DB
        et.commit();
        System.out.println("Student Name Updated");
}

@Override
public void updateStudentPhone(int id, long phone) {
	// TODO Auto-generated method stub
	Student s = em.find(Student.class, id);

        et.begin();
        s.setPhone(phone);
        et.commit();
        System.out.println("Student Phone Updated");
    }

@Override
public void deleteStudent(int id) {
	// TODO Auto-generated method stub
	Student s = em.find(Student.class, id);

     
        et.begin();
        em.remove(s);
        et.commit();
        System.out.println("Student Deleted");
   
}

@Override
public void findStudent(int id) {
	// TODO Auto-generated method stub
	Student s = em.find(Student.class, id);

    if (s != null) {
        System.out.println("Student Found:");
        System.out.println("ID: " + s.getStudentId());
        System.out.println("Name: " + s.getName());
        System.out.println("Phone: " + s.getPhone());
    } else {
        System.out.println("Student Not Found");
    }
	
}

public static void main(String[] args) {
	StudentCRUD sc = new StudentCrudImp();

    Student s = new Student();
    s.setStudentId(12);
    s.setName("Mandira");
    s.setPhone(67586);

    // SAVE
    sc.saveStudent(s);

    // UPDATE NAME
    sc.updateStudentName(12, "Avinash Sharma");

    // UPDATE PHONE
    //sc.updateStudentPhone(12, 765190);

    // FIND
    //sc.findStudent(12);
    //sc.deleteStudent(12);
	
}
}
