package com.vex.videoexam.Dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.QuestionDao;
import com.vex.videoexam.Dto.QuestionDto;
import com.vex.videoexam.model.Question;
import com.vex.videoexam.model.Question;

@Component("questionDao")
public class QuestionDaoHibernate4 implements QuestionDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Question> list(QuestionDto questionDto) {
		List<Question> questions = new ArrayList<Question>();
		Session session = sessionFactory.getCurrentSession();
		if(questionDto.getSpecify_id() != 0)
			questions = session.createQuery("from Question q where q.specify.id =" + questionDto.getSpecify_id()).list();
		else
			questions = session.createQuery("from Question q where q.category='"+questionDto.getCategory() + "'").list();
		return questions;
	}

	@Override
	public Question queryById(int id) {
		Question question = null;
		Session session = sessionFactory.getCurrentSession();
		question = (Question) session.createQuery("from Question q where q.id = " + id).uniqueResult();
		return question;
	}

	@Override
	public Question queryByName(String name) {
		Question question = null;
		Session session = sessionFactory.getCurrentSession();
		question = (Question) session.createQuery("from Question q where q.name='" + name + "'").uniqueResult();
		return question;
	}

	@Override
	public int save(Question question) {
		int id = 0;
		Session session = sessionFactory.getCurrentSession();
		session.save(question);
		id = question.getId();
		return id;
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Question p where p.id=" + id).executeUpdate();
	}

	@Override
	public void deleteByName(String name) {
		Session session  = sessionFactory.getCurrentSession();
		session.createQuery("delete from Question p where p.name='" + name + "'").executeUpdate();		
	}

	@Override
	public int update(Question question) {
		Session session = sessionFactory.getCurrentSession();
		session.update(question);
		return question.getId();
	}


}
