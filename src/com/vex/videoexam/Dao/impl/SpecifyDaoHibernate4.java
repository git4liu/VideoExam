package com.vex.videoexam.Dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.SpecifyDao;
import com.vex.videoexam.Dto.SpecifyDto;
import com.vex.videoexam.model.Specify;


@Component("specifyDao")
public class SpecifyDaoHibernate4 implements SpecifyDao{

private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public List<Specify> list(SpecifyDto specifyDto) {
		List<Specify> specifys = new ArrayList<Specify>();
		Session session = sessionFactory.getCurrentSession();
		specifys = session.createQuery("from Specify specify where specify.father.id ="+ specifyDto.getFather_id()).list();
		return specifys;
	}

	@Override
	public Specify queryById(int id) {
		Specify specify = null;
		Session session = sessionFactory.getCurrentSession();
		specify = (Specify) session.get(Specify.class, id);
		return specify;
	}

	@Override
	public Specify queryByName(String name) {
		Specify specify = null;
		Session session = sessionFactory.getCurrentSession();
		specify = (Specify) session.createQuery("from Specify p where p.name='" + name + "'").uniqueResult();
		return specify;
	}

	@Override
	public int save(Specify specify) {
		int id = 0;
		Session session = sessionFactory.getCurrentSession();
		session.save(specify);
		id = specify.getId();
		return id;
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		
		
		//删除试题
		session.createQuery("delete from Question q where q.specify.id=" + id).executeUpdate();
		
		//删除子节点
		session.createQuery("delete from Specify pchild where pchild.father=" + id).executeUpdate();
		
		//删除当前节点
		session.createQuery("delete from Specify pfather where pfather.id=" + id).executeUpdate();
		
		//检查父节点
		//session.createQuery("update Specify pfather set pfather.where pfather.id=" + id).executeUpdate();
	}

	@Override
	public void deleteByName(String name) {
		Session session  = sessionFactory.getCurrentSession();
		session.createQuery("delete from Specify p where p.name='" + name + "'").executeUpdate();		
	}

	@Override
	public int update(Specify specify) {
		Session session = sessionFactory.getCurrentSession();
		session.update(specify);
		return specify.getId();
	}



}
