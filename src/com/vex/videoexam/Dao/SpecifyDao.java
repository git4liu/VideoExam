package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.SpecifyDto;
import com.vex.videoexam.model.Specify;

public interface SpecifyDao {
	
	List<Specify> list(SpecifyDto specifyDto);
	
	Specify queryById(int id);
	
	Specify queryByName(String name);
	
	int save(Specify specify);
	
	void deleteById(int id);
	
	void deleteByName(String name);
	
	int update(Specify specify);
}
