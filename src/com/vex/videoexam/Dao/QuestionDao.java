package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.QuestionDto;
import com.vex.videoexam.model.Question;

public interface QuestionDao {

	List<Question> list(QuestionDto questionDto);
	
	Question queryById(int id);
	
	Question queryByName(String name);
	
	int save(Question question);
	
	void deleteById(int id);
	
	void deleteByName(String name);
	
	int update(Question question);
}
