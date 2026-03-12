package com.capg;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capg.MyConfig;


public class Driver {
	public static void main(String[]args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
	DepartmentService dservice = context.getBean(DepartmentService.class);
	//StudentService sservice = context.getBean("studenttService",StudentService.class);
	/*Department d1 = context.getBean("department",Department.class); 
	d1.setId(5);
	d1.setName("Postgress");
	dservice.saveDepartemnt(d1);
	Department d2 = context.getBean("department",Department.class); 
	d2.setId(6);
	d2.setName("Java Core");
	dservice.saveDepartemnt(d2);
	Student s1 = context.getBean("student",Student.class);
	s1.setId(3);
	s1.setName("Ramesh");
	//dservice.assignStudent(s1, 1);*/
	System.out.println(dservice.getallStudents(1));
	System.out.println(dservice.findDepartmentByID(1));
	((AnnotationConfigApplicationContext)context).close();
	}
}
