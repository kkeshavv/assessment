package com.capg;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StudentService {
	@Autowired
	private StudentDao studentDao;
	
	public void addStudent(Student student) {
		studentDao.addStudent(student);
	}
	public void updateEmail(int id,String email) {
		studentDao.updateEmail(id, email);
	}
	public void deleteStudentByID(int id) {
		studentDao.deleteStudentByID(id);
	}
	public Student findStudentByID(int id) {
		return studentDao.findStudentByID(id);
	}
}

