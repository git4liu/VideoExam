package com.vex.videoexam.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vex.videoexam.Dto.ExamDto;
import com.vex.videoexam.model.Exam;
import com.vex.videoexam.model.Student;
import com.vex.videoexam.model.Paper;
import com.vex.videoexam.service.ExamService;
import com.vex.videoexam.service.FileService;
import com.vex.videoexam.service.PaperService;
import com.vex.videoexam.service.StudentService;

@SuppressWarnings({ "rawtypes", "serial" })
@Component("exam")
@Scope("prototype")
public class ExamAction extends ActionSupport implements ModelDriven{
	
	public String show(){
		int stu_id = examDto.getStu_id();
		int paper_id = examDto.getPaper_id();
		student = studentService.load(stu_id);
		paper = paperService.load(paper_id);
		return "show";
	}
	
	public String start() throws Exception{
		exam = examService.start(examDto);
		int id = exam.getId();
		String examId = id + "";
		inputStream = new ByteArrayInputStream(examId.getBytes("UTF-8"));
        return "ajax";
	}
	
	public String watch(){
        String uploadPath = ServletActionContext.getServletContext().getRealPath("/");  
        int picId = 0;
        if(file != null){
        	uploadPath = uploadPath + "upload\\" + file.getName();
        	picId = fileService.upload(file, uploadPath, "upload/" + file.getName());
        	if(picId == 0)
        		return "fail";
        	examDto.setPic_id(picId);
        	examService.watch(examDto);
        	
        }
		return "watch";
	}
	
	public String end(){
		exam = examService.end(examDto);
		return "end";
	}
	
	public String delete(){
		return null;
	}
	
	public String load(){
		return null;
	}
	
	public String list(){
		return null;
	}
	
	private Paper paper;
	
	private Student student;
	
	private StudentService studentService;
	
	private PaperService paperService;
	
	private ExamService examService;
	
	private Exam exam;
	
	private ExamDto examDto = new ExamDto();
	
	private File file;
	
	private FileService fileService;
	
	private InputStream inputStream;
	
	@Override
	public Object getModel() {
		return examDto;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}


	public ExamDto getExamDto() {
		return examDto;
	}

	public void setExamDto(ExamDto examDto) {
		this.examDto = examDto;
	}

	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	public ExamService getExamService() {
		return examService;
	}

	@Resource(name="examService")
	public void setExamService(ExamService examService) {
		this.examService = examService;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public FileService getFileService() {
		return fileService;
	}

	@Resource(name="fileService")
	public void setFileService(FileService fileService) {
		this.fileService = fileService;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public PaperService getPaperService() {
		return paperService;
	}

	@Resource(name="paperService")
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

}
