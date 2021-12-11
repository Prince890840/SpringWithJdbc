package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;

//2 Class are Required JdbcTemplate and DriverManagerDataSource

public class App {
	public static void main(String[] args) {
		
		System.out.println("Hello World !");

		//ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/ConfigFile.xml");
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		StudentDao studentDao = context.getBean("studentDao",StudentDao.class);
		
		Student student = new Student();
		student.setStudentid(105);
		student.setName("Raj");
		student.setAddress("Baroda");
		
		int insert = studentDao.insert(student);
		System.out.println("Student added  ->"+insert);
		
		/*Student student = new Student();
		student.setStudentid(456);
		student.setName("Rajveer");
		student.setAddress("Bhavnagar");
		
		int update = studentDao.update(student);
		System.out.println("Student Updated  ->"+update);*/
		
		/*Student student = new Student();
		student.setStudentid(456);
		
		int delete = studentDao.delete(student);
		System.out.println("Student Deleted Successfully"+delete);*/
		
		/*Student student = studentDao.select(101);
		System.out.println("Student From Database "+student);*/
		
		List<Student> students = studentDao.getAllStudents();
		for(Student student1 : students) {
			System.out.println(student1);
		}
	}
}