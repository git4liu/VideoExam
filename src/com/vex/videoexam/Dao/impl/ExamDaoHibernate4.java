package com.vex.videoexam.Dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.ExamDao;
import com.vex.videoexam.Dto.ExamDto;
import com.vex.videoexam.model.Exam;
import com.vex.videoexam.model.Stu_Paper;

@Component("examDao")
public class ExamDaoHibernate4 implements ExamDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public int save(Exam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.save(exam);
		return exam.getId();
	}

	@Override
	public void delete(int examId) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Exam e where e.id=" + examId).executeUpdate();
	}

	@Override
	public int update(Exam exam) {
		Session session = sessionFactory.getCurrentSession();
		session.update(exam);
		return exam.getId();
	}

	@Override
	public Exam queryById(int examId) {
		Session session = sessionFactory.getCurrentSession();
		Exam exam =(Exam) session.createQuery("from Exam e where e.id=" + examId);
		return exam;
	}

	@Override
	public List<Exam> list(ExamDto examDto) {
		Session session = sessionFactory.getCurrentSession();
		List<Exam> exams = session.createQuery("from Exam").list();
		return exams;
	}

	@Override
	public int saveStu_Paper(Stu_Paper stu_paper) {
		Session session = sessionFactory.getCurrentSession();
		session.save(stu_paper);
		return stu_paper.getId();
	}



}
