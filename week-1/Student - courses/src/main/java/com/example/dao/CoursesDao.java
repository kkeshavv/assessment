package com.example.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.entity.Courses;
import com.example.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CoursesDao {
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	
	
	public Courses saveCourse(Courses c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		em.persist(c);
		et.commit();
		em.close();
		
		return c;
	}
	
	public void updateCourseHours(int id, int hours) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Courses course = findCourseById(id);
		
		
		
		
		et.begin();
		if(course != null) {
			course.setHours(hours);
			em.merge(course);
		}
		et.commit();
		em.close();
	}
	public void updateCourseTeacher(int id, String newTeacher) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Courses course = findCourseById(id);
		
		
		
		
		et.begin();
		if(course != null) {
			course.setTeacher(newTeacher);
			em.merge(course);
		}
		et.commit();
		em.close();
	}
	
	public Courses findCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		Courses course = em.find(Courses.class, id);
		em.close();
		return course;
		
	}
	
	public void deleteCourse(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Courses course = em.find(Courses.class, id);
		
		
		et.begin();
		if(course != null) em.remove(course);
		et.commit();
		em.close();
		
	}
	
	public void giveCourseToStudent(int course_id, int student_regno) {
		 EntityManager em = emf.createEntityManager();
		    EntityTransaction et = em.getTransaction();
		    
		    et.begin();
		    Student stu = em.find(Student.class, student_regno);
		    Courses course = em.find(Courses.class, course_id);

		    if (stu != null && course != null) {

		        if (stu.getCourses() != null) {
		            stu.getCourses().add(course);
		        } else {
		            List<Courses> list = new ArrayList<>();
		            list.add(course);
		            stu.setCourses(list);
		        }

		        em.merge(stu); 
		    }

		    et.commit();
		    em.close();
		}
	

}
