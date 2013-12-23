package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.model.Choice;

public interface ChoiceService {
	
	public List<Choice> list();
	
	public Choice loadById(int id);
	
	public Choice loadByName(String name);
	
	public void deleteById(int id);
	
	public void deleteByName(String name);
	
	public void add(Choice choice);
}
