package com.vex.videoexam.Dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.MessageDao;
import com.vex.videoexam.Dto.MessageDto;
import com.vex.videoexam.model.Message;

@Component("messageDao")
public class MessageDaoHibernate4 implements MessageDao{

	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	/*@SuppressWarnings("unchecked")
	@Override
	public List<Message> list(MessageDto messageDto) {
		int id = messageDto.getId();
		int id_range = messageDto.getId_range();
		int page_start = messageDto.getPage_start();
		int page_size = messageDto.getPage_size();
		int item_start = ( page_start - 1) * page_size;
		String hql = "from Message m order by m.id desc";
		if(id  != 0 && id_range != 0){
			hql = "from Message m where m.id > " + id +" and m.id < " + id_range + "order by m.id desc";
		}
		List<Message> messages = new ArrayList<Message>();
		Session session = sessionFactory.getCurrentSession();
		int total = session.createQuery("from Message m").list().size();
		if(page_size != 0 && ){			
			messages = session.createQuery(hql)
			.setFirstResult(item_start)
			.setMaxResults(page_size)
			.list() ;
		}
		else 
			messages = session.createQuery(hql).list();
		messageDto.setTotal(total);
		messageDto.setPage_start(page_start);
		messageDto.setPage_size(page_size);
		return messages;
	}*/

	@SuppressWarnings("unchecked")
	@Override
	public List<Message> list(MessageDto messageDto) {
		List<Message> messages = new ArrayList<Message>();
		Session session = sessionFactory.getCurrentSession();
		int total = session.createQuery("from Message m").list().size();
		messageDto.setTotal(total);
		String hql = "from Message m order by m.id desc ";
		int page_start = messageDto.getPage_start();
		int page_size = messageDto.getPage_size();
		int item_start =(page_start - 1) * page_size;
		if(page_start == 0 || page_size == 0 ){
			messages = session.createQuery(hql).list();
		}
		else{
			
			messages = session.createQuery("from Message m order by m.id desc")
				.setFirstResult(item_start)
				.setMaxResults(page_size)
				.list();
		}
		return messages;
	}
	
	@Override
	public Message queryById(int id) {
		Message message = new Message();
		Session session = sessionFactory.getCurrentSession();
		message = (Message) session.createQuery("from Message m where m.id = " + id).uniqueResult();
		return message;
	}

	@Override
	public int save(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.save(message);
		return message.getId();
	}

	@Override
	public void deleteById(int id) {
		Session session = sessionFactory.getCurrentSession();
		session.createQuery("delete from Message m where m.id = " + id).executeUpdate();
	}

	@Override
	public int update(Message message) {
		Session session = sessionFactory.getCurrentSession();
		session.update(message);
		return message.getId();
	}

}
