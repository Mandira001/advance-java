package com.lpu;

public interface StudentCRUD {
	
	void saveStudent(Student s);
	void updateStudentName(int id, String name);
	void updateStudentPhone(int id, long phone);
	void deleteStudent(int id);
	void findStudent(int id);
}
