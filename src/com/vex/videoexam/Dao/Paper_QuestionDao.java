package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.Paper_QuestionDto;
import com.vex.videoexam.model.Paper_Question;

public interface Paper_QuestionDao {

	List<Paper_Question> list(Paper_QuestionDto paperDto);
	
	List<Paper_Question> listByPaper(int paperId);
	
	List<Paper_Question> listByQus(int qus_id);
	
	Paper_Question queryById(int id);
	
	Paper_Question queryByName(String name);
	
	long save(Paper_Question paper);
	
	void deleteById(int paper_id , int qus_id );
	
	void delete(Paper_Question pq);
	
	void deleteByName(String name);
	
	long update(Paper_Question paper);
}
