package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.PaperDto;
import com.vex.videoexam.model.Paper;

public interface PaperDao {

	List<Paper> list(PaperDto paperDto);
	
	Paper queryById(int id);
	
	Paper queryByName(String name);
	
	int save(Paper paper);
	
	void deleteById(int id);
	
	void deleteByName(String name);
	
	int update(Paper paper);
	

}
