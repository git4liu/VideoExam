package com.vex.videoexam.Dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.PaperDao;
import com.vex.videoexam.Dto.PaperDto;
import com.vex.videoexam.model.Message;
import com.vex.videoexam.model.Paper;


@Component("paperDao")
public class PaperDaoHibernate4 implements PaperDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Paper> list(PaperDto paperDto) {
		Session session = sessionFactory.getCurrentSession();
		List<Paper> papers = new ArrayList<Paper>();
		int total = session.createQuery("from Paper").list().size();
		paperDto.setTotal(total);
		String hql = "from Paper p order by p.id desc ";
		int page_start = paperDto.getPage_start();
		int page_size = paperDto.getPage_size();
		int item_start =(page_start - 1) * page_size;
		if(page_start == 0 || page_size == 0 ){
			papers = session.createQuery(hql).list();
		}
		else{
			
			papers = session.createQuery("from Paper p order by p.id desc")
				.setFirstResult(item_start)
				.setMaxResults(page_size)
				.list();
		}
		return papers;
	}

	@Override
	public Paper queryById(int id) {
		Paper paper = null;
		Session session = sessionFactory.getCurrentSession();
		paper = (Paper) session.createQuery("from Paper p where p.id =" + id).uniqueResult();
		return paper;
	}

	@Override
	public Paper queryByName(String name) {
		Paper paper = null;
		Session session = sessionFactory.getCurrentSession();
		paper = (Paper) session.createQuery("from Paper p where p.name='" + name + "'").uniqueResult();
		return paper;
	}

	@Override
	public int save(Paper paper) {
		int id = 0;
		Session session = sessionFactory.getCurrentSession();
		session.save(paper);
		id = paper.getId();
		return id;
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Paper p where p.id=" + id).executeUpdate();
	}

	@Override
	public void deleteByName(String name) {
		Session session  = sessionFactory.getCurrentSession();
		session.createQuery("delete from Paper p where p.name='" + name + "'").executeUpdate();		
	}

	@Override
	public int update(Paper paper) {
		Session session = sessionFactory.getCurrentSession();
		session.update(paper);
		return paper.getId();
	}

}
