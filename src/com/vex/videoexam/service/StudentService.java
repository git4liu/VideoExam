package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.Dto.StudentDto;
import com.vex.videoexam.model.Student;

public interface StudentService {

	public List<Student> list(StudentDto studentDto);
	
	public Student load(int id);
	
	public Student load(String name);
	
	public boolean delete(int id);
	
	public int alter(Student student);
	
	public int add(Student student);
	
	Student logIn(String name, String pswd);
	
	boolean logOut(int id);
}
