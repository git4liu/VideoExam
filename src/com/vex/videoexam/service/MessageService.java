package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.Dto.MessageDto;
import com.vex.videoexam.model.Message;

public interface MessageService {
	
	public List<Message> list(MessageDto messageDto);
	
	public Message load(int id);
	
	public int add(Message message);
	
	public boolean delete(int id);
	
	public int alter(Message message);
	
}
