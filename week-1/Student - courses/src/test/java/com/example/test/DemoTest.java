package com.example.test;



import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.example.entity.Student;

public class DemoTest {
	
	@BeforeAll
	public static  void m1() {
		System.out.println("This is before All");
	}
	
	@AfterAll
	public  static void m2() {
		System.out.println("This is after all");
	}

	@BeforeEach
	public void m3() {
		System.out.println("Before each");
	}
	
	@AfterEach
	public void m4() {
		System.out.println("After each");
	}
	
	
	@Test
	public void demo1() {
		Assertions.assertEquals("XYZ","XYZ");
	}
	@Test
	public void demo2() {
		Assertions.assertNotNull(8,"value is Null");
		//Assertions.assertNotNull(null,"test fail message");
	}
	@Test
	public void demo3() {
		Assertions.assertThrows(ArithmeticException.class,()->{
			int res = 7/0;
		});
	}
	
	@Test
	public void demo4() {
		//Assertions.assertDoesNotThrow(()->{int res = 9/0});
		Assertions.assertDoesNotThrow(()->{
			int res = 9/9;
		});
	}
	
	@Test
	public void demo5() {
//		Student s1 = new Student("KD",67,56);
//		Student s2 = new Student("AD",56,67);
		
		String s1 = "XYZ";
		String s2 = "XYZ";
		Assertions.assertSame(s1, s2);
	}
	
	
	@Test
	public void demo6() {
		int age = 19;
		if(age<18) {
			Assertions.fail("age is less than 18");
		}
	}
	
	@Test
	public void demo7() {
		int[] arr1 = {10,20};
		int[] arr2 = {10,20};
		Assertions.assertArrayEquals(arr1,arr2);
	}
	
	@Test
	public void demo8() {
		boolean res = true;
		Assertions.assertTrue(res);
		
	}
	@Test
	public void demo9() {
		boolean res = true;
		
		Assertions.assertFalse(res);
	}
	
	@ParameterizedTest
	@CsvSource({"2,3,5","-1,1,0","5,6,11","8,2,9"})
	public void demo10(int a , int b , int expected) {
		int res = a+b;
		Assertions.assertEquals(expected, res);
		
		
		
	}
	

}
