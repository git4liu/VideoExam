package com.vex.videoexam.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.ExamDao;
import com.vex.videoexam.Dao.ExampicDao;
import com.vex.videoexam.Dao.PaperDao;
import com.vex.videoexam.Dao.StudentDao;
import com.vex.videoexam.Dto.ExamDto;
import com.vex.videoexam.model.Exam;
import com.vex.videoexam.model.Exampic;
import com.vex.videoexam.model.Stu_Paper;
import com.vex.videoexam.model.Student;
import com.vex.videoexam.model.Paper;
import com.vex.videoexam.service.ExamService;

@Component("examService")
public class ExamServiceImpl implements ExamService{
	
	private PaperDao paperDao;
	
	private StudentDao studentDao;
	
	private ExamDao examDao;
	
	private ExampicDao exampicDao;

	public PaperDao getPaperDao() {
		return paperDao;
	}

	@Resource(name="paperDao")
	public void setPaperDao(PaperDao paperDao) {
		this.paperDao = paperDao;
	}

	public StudentDao getStudentDao() {
		return studentDao;
	}

	@Resource(name="studentDao")
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	public ExamDao getExamDao() {
		return examDao;
	}

	@Resource(name="examDao")
	public void setExamDao(ExamDao examDao) {
		this.examDao = examDao;
	}

	public ExampicDao getExampicDao() {
		return exampicDao;
	}

	@Resource(name="exampicDao")
	public void setExampicDao(ExampicDao exampicDao) {
		this.exampicDao = exampicDao;
	}

	@Override
	public List<Exam> list(ExamDto examDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Exam load(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int add(Exam exam) {
		return 0;
	}

	@Override
	public boolean delete(int id) {
		return false;
	}

	@Override
	public int alter(Exam exam) {
		return 0;
	}

	@Override
	public Exam start(ExamDto examDto) {
		int stu_id = examDto.getStu_id();
		int paper_id = examDto.getPaper_id();
		Student student = studentDao.queryById(stu_id);
		Paper paper = paperDao.queryById(paper_id);
		Stu_Paper stu_paper = new Stu_Paper();
		stu_paper.setPaper(paper);
		stu_paper.setStudent(student);
		examDao.saveStu_Paper(stu_paper);
		if(stu_paper.getId() == 0)
			return null;
		Exam exam = new Exam();
		exam.setStu_paper(stu_paper);
		examDao.save(exam);
		return exam;
	}

	@Override
	public Exam end(ExamDto examDto) {
		Exam exam = examDao.queryById(examDto.getId());
		exam.setCheat('N');
		return exam;
	}

	@Override
	public void watch(ExamDto examDto) {
		int pic_id = examDto.getPic_id();
		Exampic ep = new Exampic();
		ep = exampicDao.queryById(pic_id);
		Exam exam = examDao.queryById(examDto.getId());
		exam.getExampics().add(ep);
	}
	
	
}
