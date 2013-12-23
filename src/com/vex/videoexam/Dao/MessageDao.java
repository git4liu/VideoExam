package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.MessageDto;
import com.vex.videoexam.model.Message;

public interface MessageDao {

	List<Message> list(MessageDto messageDto);
	
	Message queryById(int id);
	
	int save(Message message);
	
	void deleteById(int id);
	
	int update(Message message);
}
