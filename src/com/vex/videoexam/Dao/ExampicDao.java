package com.vex.videoexam.Dao;

import com.vex.videoexam.model.Exampic;

public interface ExampicDao {

	int save(Exampic exampic);
	
	void deleteById(int id);
	
	Exampic queryById(int id);
	
}
