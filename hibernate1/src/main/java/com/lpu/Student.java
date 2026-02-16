package com.lpu;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	
		@Id
		private int studentId;
		private String name;
		private long phone;
		
		
	    public int getStudentId() {
			return studentId;
		}


		public void setStudentId(int studentId) {
			this.studentId = studentId;
		}


		public String getName() {
			return name;
		}


		public void setName(String name) {
			this.name = name;
		}


		public long getPhone() {
			return phone;
		}


		public void setPhone(long phone) {
			this.phone = phone;
		}

 
	
	
}
