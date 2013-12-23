package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.ExamDto;
import com.vex.videoexam.model.Exam;
import com.vex.videoexam.model.Stu_Paper;

public interface ExamDao {

	public int save(Exam exam);
	
	public void delete(int examId);
	
	public int update(Exam exam);
	
	public Exam queryById(int examId);
	
	public List<Exam> list(ExamDto examDto);
	
	public int saveStu_Paper(Stu_Paper stu_paper);
}
