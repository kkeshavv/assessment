package com.example.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Student {
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private int age;
	private double marks;
	@ManyToMany
	List<Courses> courses;
	
	public List<Courses> getCourses() {
		return courses;
	}

	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
	public Student(String name, int age, double marks) {
		super();
		this.name = name;
		this.age = age;
		this.marks = marks;
	}
	public Student() {}
	

}
