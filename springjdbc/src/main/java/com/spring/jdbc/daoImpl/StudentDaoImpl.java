package com.spring.jdbc.daoImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import com.spring.jdbc.Student;
import com.spring.jdbc.dao.RowMapperImpl;
import com.spring.jdbc.dao.StudentDao;

@Component("studentDao")
public class StudentDaoImpl implements StudentDao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}
	
	@Autowired
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int insert(Student student) {
		// TODO Auto-generated method stub
		
		String query = "insert into student_table(i_student_id,c_student_name,c_student_address) values(?,?,?)";
		
		int result1 = this.jdbcTemplate.update(query,student.getStudentid(),student.getName(),student.getAddress());
		
		return result1;
	}
	public int update(Student student) {
		// TODO Auto-generated method stub
		
		String query = "update student_table set c_student_name=?,c_student_address=? where i_student_id=?";
		
		int result2 = this.jdbcTemplate.update(query,student.getName(),student.getAddress(),student.getStudentid());
		
		return result2;
	}
	public int delete(Student student) {
		// TODO Auto-generated method stub
		
		String query = "delete from student_table where i_student_id=?";
		
		int result3 = this.jdbcTemplate.update(query,student.getStudentid());
		
		return result3;
	}
	public Student select(int studentId) {
		// TODO Auto-generated method stub
		
		String query = "select * from student_table where i_student_id=?";
		
		RowMapper<Student> rowMapper = new RowMapperImpl();
		
		Student student = this.jdbcTemplate.queryForObject(query,rowMapper,studentId);
		
		return student;
	}
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		
		String query = "select * from student_table";
		
		List<Student> studentlist = this.jdbcTemplate.query(query,new RowMapperImpl());
		
		return studentlist;
	}
}