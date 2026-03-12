package com.example.service;

import com.example.dao.CoursesDao;
import com.example.entity.Courses;
import com.example.entity.Student;

public class CoursesService {
	private CoursesDao csDao = new CoursesDao();
	
	

	public Courses registerCourse(String name, String code, int hours, String teacher) {
		if (hours < 15) {
			throw new IllegalArgumentException("Invalid hours");
		}

		Courses course = csDao.saveCourse(new Courses(name, code, hours, teacher));
		return course;

	}
	
	public Courses getCourse(int id){
		Courses course = csDao.findCourseById(id);
		if(course == null ) {
			throw new IllegalArgumentException("Invalid id...404 course not found");
		}
		
		return course;
		
	}	
	

	public void updateHours(int id, int newHours) {

		if (newHours < 15) {
			throw new IllegalArgumentException("Invalid hours");
		}

		csDao.updateCourseHours(id, newHours);
	}
	
	
	

	public void updateTeacher(int id, String teacher) {

		csDao.updateCourseTeacher(id, teacher);
	}
	
	
	

	public void deleteCourse(int id) {
		csDao.deleteCourse(id);
	}
	
	
	public void assignCourseToStudent(int c_id, int s_regno) {
		if(csDao.findCourseById(c_id)!= null) {
		csDao.giveCourseToStudent(c_id, s_regno);
		}
		
	}

}
