package com.vex.videoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.QuestionDao;
import com.vex.videoexam.Dto.QuestionDto;
import com.vex.videoexam.model.Question;
import com.vex.videoexam.service.QuestionService;

@Component("questionService")
public class QuestionServiceImpl implements QuestionService{

	private QuestionDao questionDao;
	
	public QuestionDao getQuestionDao() {
		return questionDao;
	}

	@Resource(name="questionDao")
	public void setQuestionDao(QuestionDao questionDao) {
		this.questionDao = questionDao;
	}

	@Override
	public List<Question> list(QuestionDto questionDto) {
		List<Question> questions = new ArrayList<Question>();
		questions = questionDao.list(questionDto);
		return questions;
	}
	
//	public List<Choice> list(ChoiceDto choiceDto){
//		List<Choice> questions = new ArrayList<Choice>();
//		questions = questionDao.list(choiceDto);
//		return questions;
//		
//	}

	@Override
	public Question load(int id) {
		return questionDao.queryById(id);
	}

	@Override
	public int add(Question question) {
		questionDao.save(question);
		return question.getId();
	}

	@Override
	public boolean delete(int id) {
		questionDao.deleteById(id);
		Question question = questionDao.queryById(id);
		if(question == null)
			return true;
		return false;
	}

	@Override
	public int alter(Question question) {
		questionDao.update(question);
		return question.getId();
	}

}
