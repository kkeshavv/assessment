package com.capg;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class StudentDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public void addStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		em.close();
	}
	public void updateEmail(int id,String email) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student student = em.find(Student.class, id);
		if(student!=null)
		{
			student.setEmail(email);
			et.begin();
			em.merge(student);
			et.commit();
			em.close();
		}
		else {
			System.out.println("No Student with id = "+id+" exists");
		}
	}
	public void deleteStudentByID(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student student = em.find(Student.class, id);
		et.begin();
		if(student!=null)em.remove(student);
		et.commit();
		em.close();
	}
	public Student findStudentByID(int id) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, id);
		em.close();
		return student;
	}
}
