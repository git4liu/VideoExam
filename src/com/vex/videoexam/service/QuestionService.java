package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.Dto.QuestionDto;
import com.vex.videoexam.model.Question;

public interface QuestionService {
	
	public List<Question> list(QuestionDto questionDto);
	
	public Question load(int id);
	
	public int add(Question question);
	
	public boolean delete(int id);
	
	public int alter(Question question);
	
}
