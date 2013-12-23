package com.vex.videoexam.Dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.PaperDao;
import com.vex.videoexam.Dao.Paper_QuestionDao;
import com.vex.videoexam.Dto.PaperDto;
import com.vex.videoexam.Dto.Paper_QuestionDto;
import com.vex.videoexam.model.Paper;
import com.vex.videoexam.model.Paper_Question;


@Component("paper_qusDao")
public class PaperQuestionDaoHibernate4 implements Paper_QuestionDao{

private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Paper_Question> list(Paper_QuestionDto paperDto) {
		return null;
	}

	@Override
	public Paper_Question queryById(int id) {
		return null;
	}

	@Override
	public Paper_Question queryByName(String name) {
		return null;
	}

	@Override
	public long save(Paper_Question paper) {
		Session session = sessionFactory.getCurrentSession();
		session.save(paper);
		return 0;
	}

	@Override
	public void deleteById(int paper_id , int qus_id) {
		
	}

	@Override
	public void deleteByName(String name) {
		
	}

	@Override
	public long update(Paper_Question paper) {
		return 0;
	}

	@Override
	public List<Paper_Question> listByPaper(int paperId) {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("from Paper_Question pa where pa.paper.id = " + paperId).list();
	}

	@Override
	public List<Paper_Question> listByQus(int qus_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Paper_Question pq) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Paper_Question pq where pq.paper.id=" + pq.getPaper().getId() + " and pq.qus.id = " + pq.getQus().getId()).executeUpdate();
	}
}
