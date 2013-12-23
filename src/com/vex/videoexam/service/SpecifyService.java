package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.Dto.SpecifyDto;
import com.vex.videoexam.model.Specify;

public interface SpecifyService {
	
	public List<Specify> list(SpecifyDto specifyDto);
	
	public Specify load(int id);
	
	public int add(Specify specify);
	
	public boolean delete(int id);
	
	public int alter(Specify specify);
	
	public List<Specify> child(int id);
	
	public List<Specify> posterity(int id);
	

}
