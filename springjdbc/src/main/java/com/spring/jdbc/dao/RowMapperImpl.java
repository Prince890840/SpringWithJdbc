package com.spring.jdbc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.spring.jdbc.Student;

public class RowMapperImpl implements RowMapper<Student> {

	public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		
		Student student = new Student();	
		
		student.setStudentid(rs.getInt(1));
		student.setName(rs.getString(2));
		student.setAddress(rs.getString(3));
		
		return student;
	}
	
}
