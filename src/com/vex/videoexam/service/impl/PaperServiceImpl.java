package com.vex.videoexam.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.PaperDao;
import com.vex.videoexam.Dao.Paper_QuestionDao;
import com.vex.videoexam.Dto.PaperDto;
import com.vex.videoexam.Dto.Paper_QuestionDto;
import com.vex.videoexam.model.Paper;
import com.vex.videoexam.model.Paper_Question;
import com.vex.videoexam.model.Question;
import com.vex.videoexam.service.PaperService;

@Component("paperService")
public class PaperServiceImpl implements PaperService{

	
	private PaperDao paperDao;
	
	private Paper_QuestionDao paper_qusDao;
	
	public Paper_QuestionDao getPaper_qusDao() {
		return paper_qusDao;
	}

	@Resource(name="paper_qusDao")
	public void setPaper_qusDao(Paper_QuestionDao paper_qusDao) {
		this.paper_qusDao = paper_qusDao;
	}
	
	public PaperDao getPaperDao() {
		return paperDao;
	}

	@Resource(name="paperDao")
	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}

	
	@Override
	public List<Paper> list(PaperDto paperDto) {
		List<Paper> papers = new ArrayList<Paper>();
		papers = paperDao.list(paperDto);
		return papers;
	}

	@Override
	public Paper load(int id) {
		Paper paper = paperDao.queryById(id);
		return paper;
	}

	@Override
	public boolean delete(int id) {
		paperDao.deleteById(id);
		Paper paper = paperDao.queryById(id);
		if(paper != null){
			return false;
		}
		return true;
	}

	@Override
	public int alter(Paper paper) {
		paperDao.update(paper);
		return paper.getId();
	}

	@Override
	public int add(Paper paper) {
		paperDao.save(paper);
		return paper.getId();
	}

	@Override
	public int fill(List<?> paper_qus_list) {
		
		int paperId = 0;
		int qus_mount = 0;
		int paper_score = 0;
		for(Object o :  paper_qus_list){
			Paper p = new Paper();
			Question q = new Question();
			Paper_Question pq  = new Paper_Question();
			Paper_QuestionDto pqd = (Paper_QuestionDto)o;
			paperId = (int) pqd.getPaper_id();
			p.setId((int)pqd.getPaper_id());
			q.setId((int)pqd.getPaper_qus_id());
			pq.setPaper(p);
			pq.setQus(q);
			pq.setQus_score(pqd.getQus_score());
			paper_qusDao.save(pq);
			qus_mount ++ ;
			paper_score += pqd.getQus_score();
			
		}
		int size = paper_qusDao.listByPaper(paperId).size();
		Paper paper = new Paper();
		paper = paperDao.queryById(paperId);
		if(paper != null){
			paper.setTime(new Date().toString());
			paper.setQus_mount(paper.getQus_mount() + qus_mount);
			paper.setScore(paper.getScore() + paper_score);
			paperDao.update(paper);
		}
		return size;
	}

	@Override
	public int removeQus(List<?> paper_qus_list) {
		int paper_qus_mount = 0;
		for(Object o : paper_qus_list){
			Paper_QuestionDto pqd = (Paper_QuestionDto)o;
			Paper_Question pq = new Paper_Question();
			int paper_id = pqd.getPaper_id();
			Paper p = paperDao.queryById(paper_id);
			Question q = new Question();
			p.setId(pqd.getPaper_id());
			q.setId((int)pqd.getPaper_qus_id());
			pq.setPaper(p);
			pq.setQus(q);
			paper_qusDao.delete(pq);
			p.setQus_mount(p.getQus_mount() - 1);
			p.setScore(p.getScore() - pqd.getQus_score());
			paperDao.update(p);
			paper_qus_mount = p.getQus_mount();
		}
		return paper_qus_mount;
	}



}
