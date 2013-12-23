package com.vex.videoexam.action;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vex.videoexam.Dto.PaperDto;
import com.vex.videoexam.Dto.StudentDto;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.model.Student;
import com.vex.videoexam.service.StudentService;


@Component("student")
@Scope("prototype")
public class StudentAction extends ActionSupport implements ModelDriven {

	
	
	public String add(){
		String name = studentDto.getName();
		Student s = studentService.load(name);
		if(s != null)
			return "fail";
		student = new Student();
		student.setMail(studentDto.getMail());
		student.setName(studentDto.getName());
		student.setPicAddr(studentDto.getPicAddr());
		String pswd = studentDto.getPswd();
		String pswd_confirm = studentDto.getPswd_range();
		if(!(pswd.equals(pswd_confirm))){
			return "fail";
		}
		student.setPswd(pswd);
		studentService.add(student);
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		int id = studentDto.getId();
		boolean delete = studentService.delete(id);
		if(delete)
			inputStream = new ByteArrayInputStream(("yes").getBytes("UTF-8"));
		else
			inputStream = new ByteArrayInputStream(("no").getBytes("UTF-8"));
		return "ajax";
	}
	
	public String update(){
		student = new Student();
		student.setId(studentDto.getId());
		student.setMail(studentDto.getMail());
		student.setName(studentDto.getName());
		student.setPicAddr(studentDto.getPicAddr());
		String pswd = studentDto.getPswd();
		String pswd_confirm = studentDto.getPswd_range();
		if(!(pswd.equals(pswd_confirm))){
			return "fail";
		}
		student.setPswd(pswd);
		int id = studentService.alter(student);
		if(id != 0){
			return SUCCESS;
		}
		student = null;
		return "fail";
	}
	
	public String load(){
		student = studentService.load(studentDto.getId());
		if(student  == null)
			return "fail";
		return "json";
	}
	
	public String exists() throws Exception{
		String name = studentDto.getName();
		Student s = studentService.load(name);
		if(s == null)
			inputStream = new ByteArrayInputStream(("no").getBytes("UTF-8"));
		else 
			inputStream = new ByteArrayInputStream(("yes").getBytes("UTF-8"));
			
		return "ajax";
	}
	
	public String list(){
		students = studentService.list(studentDto);
		return "list";
	}
	
	public String logIn(){
		HttpServletResponse response = ServletActionContext.getResponse();
		student = studentService.logIn(studentDto.getName(), studentDto.getPswd());	
		if (student != null) {
			Cookie id = new Cookie("student_id",student.getId() + "");
			Cookie name = new Cookie("student_name",student.getName());
			Cookie picAddr = new Cookie("studnet_picAddr",student.getPicAddr());
			
			name.setMaxAge(60 * 60 * 24);
			id.setMaxAge(60 * 60 * 24);
			picAddr.setMaxAge(60 * 60 * 24);
			
			name.setPath("/");
			id.setPath("/");
			picAddr.setPath("/");
			
			response.addCookie(id);
			response.addCookie(name);
			response.addCookie(picAddr);
			
			return "index";
		}
		return "fail";
	}
	
	public String logOut(){
		return null;
	}
	
	private StudentService studentService;
	
	private StudentDto studentDto = new StudentDto();
	
	private Student student;
	
	private InputStream inputStream;

	private Map<String, StudentDto> studentMap = new HashMap<String, StudentDto>();

	private List<?> students = new ArrayList<Student>();
	
	@Override
	public Object getModel() {
		return studentDto;
	}

	public StudentService getStudentService() {
		return studentService;
	}

	@Resource(name="studentService")
	public void setStudentService(StudentService studentService) {
		this.studentService = studentService;
	}

	public StudentDto getStudentDto() {
		return studentDto;
	}

	public void setStudentDto(StudentDto studentDto) {
		this.studentDto = studentDto;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<?> getStudents() {
		return students;
	}

	public void setStudents(List<?> students) {
		this.students = students;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Map<String, StudentDto> getStudentMap() {
		return studentMap;
	}

	public void setStudentMap(Map<String, StudentDto> studentMap) {
		this.studentMap = studentMap;
	}
	

}
