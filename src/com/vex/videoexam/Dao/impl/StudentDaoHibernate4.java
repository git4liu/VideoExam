package com.vex.videoexam.Dao.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.StudentDao;
import com.vex.videoexam.Dto.StudentDto;
import com.vex.videoexam.model.Student;

@Component("studentDao")
public class StudentDaoHibernate4 implements StudentDao{

private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Student> list(StudentDto studentDto) {
		List<Student> students = new ArrayList<Student>();
		Session session = sessionFactory.getCurrentSession();
		students = session.createQuery("from Student").list();
		return students;
	}

	@Override
	public Student queryById(int id) {
		Student student = null;
		Session session = sessionFactory.getCurrentSession();
		student = (Student)session.createQuery("from Student s where s.id=" + id).uniqueResult();
//		student = (Student) session.load(Student.class, id);
		return student;
	}

	@Override
	public Student queryByName(String name) {
		Student student = null;
		Session session = sessionFactory.getCurrentSession();
		student = (Student) session.createQuery("from Student p where p.name='" + name + "'").uniqueResult();
		return student;
	}

	@Override
	public int save(Student student) {
		int id = 0;
		Session session = sessionFactory.getCurrentSession();
		session.save(student);
		id = student.getId();
		return id;
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Student p where p.id=" + id).executeUpdate();
	}

	@Override
	public void deleteByName(String name) {
		Session session  = sessionFactory.getCurrentSession();
		session.createQuery("delete from Student p where p.name='" + name + "'").executeUpdate();		
	}

	@Override
	public int update(Student student) {
		Session session = sessionFactory.getCurrentSession();
		session.update(student);
		return student.getId();
	}



	
}
