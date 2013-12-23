package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.Dto.ExamDto;
import com.vex.videoexam.model.Exam;

public interface ExamService {
	
	public List<Exam> list(ExamDto examDto);
	
	public Exam load(int id);
	
	public int add(Exam exam);
	
	public boolean delete(int id);
	
	public int alter(Exam exam);
	
	public Exam start(ExamDto examDto);
	
	public Exam end(ExamDto examDto);
	
	public void watch(ExamDto examDto);
	
}
