package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.Dto.PaperDto;
import com.vex.videoexam.model.Paper;

public interface PaperService {
	
	public List<Paper> list(PaperDto paperDto);
	
	public Paper load(int id);
	
	public boolean delete(int id);
	
	public int alter(Paper paper);
	
	public int add(Paper paper);
	
	public int fill(List<?> paper_qus_list);
	
	public int removeQus (List<?> paper_qus_list);
}
