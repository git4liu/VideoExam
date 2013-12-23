package com.vex.videoexam.Dao.impl;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.ManagerDao;
import com.vex.videoexam.Dto.ManagerDto;
import com.vex.videoexam.model.Manager;

@Component("managerDao")
public class managerDaoHibernate4 implements ManagerDao{

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public int save(Manager manager) {
		int id = 0;
		Session session = sessionFactory.getCurrentSession();
		session.save(manager);
		id = manager.getId();
		return id;
	}

	@Override
	public void deleteById(int id) {
		Session session  = sessionFactory.getCurrentSession();
		session.createQuery("delete from Manager m where m.id=" + id).executeUpdate();
	}

	@Override
	public void deleteByName(String name) {
		Session session  = sessionFactory.getCurrentSession();
		session.createQuery("delete from Manager m where m.name='" + name + "'").executeUpdate();
	}

	@Override
	public int update(Manager manager) {
		Session session = sessionFactory.getCurrentSession();
		session.update(manager);
		return manager.getId();
	}

	@Override
	public Manager queryById(int id) {
		Manager manager = null;
		Session session  = sessionFactory.getCurrentSession();
		manager = (Manager)session.createQuery("from Manager m where m.id=" + id).uniqueResult();
		return manager;
	}

	@Override
	public Manager queryByName(String name) {
		Manager manager = null;
		Session session  = sessionFactory.getCurrentSession();
		manager = (Manager)session.createQuery("from Manager m where m.name='" + name + "'").uniqueResult();
		return manager;
	}

	@Override
	public List<Manager> list(ManagerDto managerDto) {
		List<Manager> managers = new ArrayList<Manager>();
		Session session = sessionFactory.getCurrentSession();
		managers =  (List<Manager>)session.createQuery("from Manager").list();
		return managers;
	}

	
	
}
