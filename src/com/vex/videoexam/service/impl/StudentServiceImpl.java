package com.vex.videoexam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.StudentDao;
import com.vex.videoexam.Dto.StudentDto;
import com.vex.videoexam.model.Student;
import com.vex.videoexam.service.StudentService;

@Component("studentService")
public class StudentServiceImpl implements StudentService{

	private StudentDao studentDao;
	
	public StudentDao getStudentDao() {
		return studentDao;
	}

	@Resource(name="studentDao")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Override
	public List<Student> list(StudentDto studentDto) {
		
		return studentDao.list(studentDto);
	}

	@Override
	public Student load(int id) {
		
		return studentDao.queryById(id);
	}

	@Override
	public Student load(String name) {
		return studentDao.queryByName(name);
	}

	@Override
	public boolean delete(int  id) {
		studentDao.deleteById(id);
		Student student = studentDao.queryById(id);
		if(student == null)
			return true;
		return false;
	}

	@Override
	public int alter(Student student) {
		studentDao.update(student);
		return student.getId();
	}

	@Override
	public int add(Student student) {
		studentDao.save(student);
		return student.getId();
	}

	@Override
	public Student logIn(String name, String pswd) {
		Student student = studentDao.queryByName(name);
		if(student != null){
			if(student.getPswd().equals(pswd))
				return student;
		}
		return null;
	}

	@Override
	public boolean logOut(int id) {
		return true;
	}

}
