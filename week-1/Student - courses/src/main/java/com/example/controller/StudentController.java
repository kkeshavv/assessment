package com.example.controller;

import java.util.Arrays;

import com.example.entity.Courses;
import com.example.entity.Student;
import com.example.service.CoursesService;
import com.example.service.StudentService;

public class StudentController {
	private static StudentService ss = new StudentService();
	private static CoursesService cs = new CoursesService();
	
	
	public static void main(String[] args) {
		
		
		
		//objects of courses
		Courses course1 = cs.registerCourse("Java","JAV101",50,"Ravi Ojha");
		Courses course2 = cs.registerCourse("SQL","SQL102",20,"Vaishnav");
		Courses course3 = cs.registerCourse("JUnit","JUT103",15,"Sandeep");
		Courses course4 = cs.registerCourse("Java Advanced","JAV104",70,"Sandeep");
		Courses course5 = cs.registerCourse("English","ENG105",60,"Prabha");
		Courses course6 = cs.registerCourse("Engineering Math","MTH106",80,"Arshdeep");
		
		
		Student stu1 = ss.registerStudent("Khushi",22,90);
		Student stu2 = ss.registerStudent("Bhavya",21,89);
		Student stu3 = ss.registerStudent("Shubh",21,56);
		
		
		cs.assignCourseToStudent(1, 2);
		cs.assignCourseToStudent(2, 2);
		cs.assignCourseToStudent(3, 2);
		cs.assignCourseToStudent(4, 2);
		cs.assignCourseToStudent(1, 3);
		cs.assignCourseToStudent(2, 3);
		cs.assignCourseToStudent(3, 3);
		cs.assignCourseToStudent(4, 3);
		
		cs.assignCourseToStudent(5, 5);
		cs.assignCourseToStudent(6, 5);
		
		
		
		
		ss.deleteStudent(4);
		cs.assignCourseToStudent(4,3);
		
		ss.updateMarks(3, 78);
		cs.updateTeacher(6, "Akashdeep");
		
		
		
		
		
		

		
	}
}
