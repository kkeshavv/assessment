package com.example.service;

import com.example.dao.StudentDao;
import com.example.entity.Student;

public class StudentService {
	
	private StudentDao dao = new StudentDao();
	
	public Student registerStudent(String name, int age, double marks) {
		
	if(age<18 || age >100){
		throw new IllegalArgumentException("Student age is not valid...CHIRKUT!!!!..wapas bhaag jaa battameezi nhi !!!!\n ya toh 18 se upar nahi toh college se bhar");
	}
	
	if(marks<0 || marks >100) {
		throw new IllegalArgumentException("Invalid marks.... aise marks maine toh nahi dekhe kahi !!");
	}
	
	Student student  = new Student(name, age, marks);
	return dao.saveStudent(student);
	
	}
	
	public Student getStudent(int id){
		Student student = dao.findStudentById(id);
		if(student == null ) {
			throw new IllegalArgumentException("Invalid id...404 student not found");
		}
		
		return student;
		
	}	
	
	public void updateMarks(int id, double newMarks) {
		
		//Student student = getStudent(id);
		if(newMarks< 0 || newMarks>100) {
			throw new IllegalArgumentException("Invalid marks.... aise marks maine toh nahi dekhe kahi !!");
		}
		
		dao.updateStudentMarks(id, newMarks);
	}
	
	public void deleteStudent(int id) {
		//getStudent(id);
		dao.deleteStudentById(id);
	}

}
