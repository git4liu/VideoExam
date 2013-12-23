package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.StudentDto;
import com.vex.videoexam.model.Student;

public interface StudentDao {
	
	List<Student> list(StudentDto studentDto);
	
	Student queryById(int id);
	
	Student queryByName(String name);
	
	int save(Student student);
	
	void deleteById(int id);
	
	void deleteByName(String name);
	
	int update(Student student);
}
