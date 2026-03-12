package com.example.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import com.example.entity.Student;
import com.example.service.StudentService;

public class StudentServiceTest {
	static StudentService service;
	
	@ParameterizedTest
	@CsvSource({})
	public void testRegisterStudent() {
		Assertions.assertThrows(NullPointerException.class,()->{Student stu = service.registerStudent("Khushi", 12, 101);
		});	
	}
	
	@Test
	public void 
	

}
