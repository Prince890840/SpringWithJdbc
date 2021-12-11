package com.spring.jdbc;

public class Student {
	private int studentid;
	private String name;
	private String Address;
	
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	@Override
	public String toString() {
		return String.format("Student [studentid=%s, name=%s, Address=%s]", studentid, name, Address);
	}

	public Student(int studentid, String name, String address) {
		super();
		this.studentid = studentid;
		this.name = name;
		Address = address;
	}
}
