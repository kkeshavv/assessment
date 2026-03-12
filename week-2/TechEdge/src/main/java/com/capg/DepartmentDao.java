package com.capg;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;

import com.capg.Student;




@Component
public class DepartmentDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public void saveDepartemnt(Department d) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(d);
		et.commit();
		em.close();
	}
	public void assignStudent(Student s, int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Department d = em.find(Department.class, id);
		d.getStudents().add(s);
		s.setDepartment(d);
		et.begin();
		em.merge(d);
		et.commit();
		em.close();
	}
	public void updateName(int id, String name) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Department d = em.find(Department.class, id);
		if(d!=null)
		{
			d.setName(name);
			et.begin();
			em.merge(d);
			et.commit();
			em.close();
		}
		else {
			System.out.println("No Department with id = "+id+" exists");
		}
	}
	public void deleteDepartmentByID(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Department d = em.find(Department.class, id);
		et.begin();
		if(d!=null)em.remove(d);
		et.commit();
		em.close();
	}
	public Department findDepartmentByID(int id) {
		EntityManager em = emf.createEntityManager();
		Department d = em.find(Department.class, id);
		em.close();
		return d;
	}
	public List<Student> getallStudents(int id) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Student> query = em.createQuery("SELECT s FROM Student s WHERE s.department.id = :deptId",Student.class);   
		query.setParameter("deptId", id);
		List<Student> students = query.getResultList();
		em.close();  
		return students;
	}
}
