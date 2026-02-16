package com.lpu.ManyToMany;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Subjects {
	@Id
	private int id;
	private String name;
	private String trainer;
	@ManyToMany(mappedBy = "subjects")
	private List<CollegeStudent> students;
	
	//getter setter
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTrainer() {
		return trainer;
	}
	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}
	public List<CollegeStudent> getStudents() {
		return students;
	}
	public void setStudents(List<CollegeStudent> students) {
		this.students = students;
	}
	
	//no-arg constructor
	public Subjects() {
		super();
	}
	
}
