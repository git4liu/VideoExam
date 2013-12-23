package com.vex.videoexam.Dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.ExampicDao;
import com.vex.videoexam.model.Exampic;


@Component("exampicDao")
public class ExampicDaoHibernate4 implements ExampicDao{
	
	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	@Override
	public int save(Exampic exampic) {
		int id = 0;
		Session session = sessionFactory.getCurrentSession();
		session.save(exampic);
		id = exampic.getId();
		return id;
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Exampic ep where ep.id = " + id).executeUpdate();
	}

	@Override
	public Exampic queryById(int id) {
		Session session = sessionFactory.getCurrentSession();
		Exampic exampic = (Exampic)session.createQuery("from Exampic ep where ep.id=" + id);
		return exampic;
	}

}
