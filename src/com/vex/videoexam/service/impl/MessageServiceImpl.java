package com.vex.videoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.MessageDao;
import com.vex.videoexam.Dto.MessageDto;
import com.vex.videoexam.model.Message;
import com.vex.videoexam.service.MessageService;

@Component("messageService")
public class MessageServiceImpl implements MessageService{

	private MessageDao messageDao;
	
	public MessageDao getMessageDao() {
		return messageDao;
	}

	@Resource(name="messageDao")
	public void setMessageDao(MessageDao messageDao) {
		this.messageDao = messageDao;
	}

	@Override
	public List<Message> list(MessageDto messageDto) {
		List<Message> messages = new ArrayList<Message>();
		messages = messageDao.list(messageDto);
		return messages;
	}

	@Override
	public Message load(int id) {
		return messageDao.queryById(id);
	}

	@Override
	public int add(Message message) {
		messageDao.save(message);
		return message.getId();
	}

	@Override
	public boolean delete(int id) {
		messageDao.deleteById(id);
		Message message = messageDao.queryById(id);
		if(message == null)
			return true;
		return false;
	}

	@Override
	public int alter(Message message) {
		messageDao.update(message);
		return message.getId();
	}

}
