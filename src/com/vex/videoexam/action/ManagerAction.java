package com.vex.videoexam.action;


import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
//import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vex.videoexam.Dto.ManagerDto;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.service.ManagerService;
import com.vex.videoexam.service.aspect.Authority;


@Component("manager")
@Scope("prototype")
public class ManagerAction extends ActionSupport implements ModelDriven<Object>{

	private static final long serialVersionUID = 1L;


	private ManagerDto managerDto;

	
	private ManagerService managerService;
	
	private List<Manager> managers = new ArrayList<Manager> ();
	
	private Manager manager;
		
	private InputStream inputStream;
	
	public String add(){
		manager = new Manager();
		String name = managerDto.getName();
		int category = managerDto.getCategory();
		manager.setName(managerDto.getName());
		manager.setPswd(managerDto.getPswd());
		manager.setCategory(managerDto.getCategory());
		int id = managerService.add(manager);
		managerDto.setId(id);
		return SUCCESS;
	}

	public String delete() throws Exception{
		int id = managerDto.getId();
		boolean delete = managerService.delete(id);
		if(delete)
			inputStream = new ByteArrayInputStream("yes".getBytes("UTF-8"));
		else 
			inputStream = new ByteArrayInputStream("no".getBytes("UTF-8"));
        return "ajax";

	}


	@Override
	public String execute() throws Exception {
		System.out.println("from execute");
		return "index";
	}


	public InputStream getInputStream() {
        return inputStream;
    }


	public Manager getManager() {
		return manager;
	}


	public ManagerDto getManagerDto() {
		return managerDto;
	}
	

	public List<Manager> getManagers() {
		return managers;
	}


	public ManagerService getManagerService() {
		return managerService;
	}

	@Override
	public Object getModel() {
		System.out.println("ModelDriver called!!");
		return managerDto;
	}

	public String list(){
		managers = managerService.list(null);
		return "list";
	}
	
	public String load() throws Exception{
		String name = managerDto.getName();

		if(managerService.load(managerDto.getName()) == null)
			inputStream = new ByteArrayInputStream("yes".getBytes("UTF-8"));
		else 
			inputStream = new ByteArrayInputStream("no".getBytes("UTF-8"));
        return "ajax";
	}
	
	public String logIn() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String name = request.getParameter("name");
		String pswd = request.getParameter("pswd");
		Manager manager = managerService.logIn(name, pswd);
		if(manager != null){
			session.setAttribute("manager", manager);
			return "index";
		}
		
		return "fail";
	}
	
	public String logOut(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		Manager manager = (Manager) session.getAttribute("manager");
		if(managerService.logOut(manager.getId())){
			session.removeAttribute("manager");
			session.invalidate();
			return "success";
		}
		return "fail";
	}
	
	public void setManager(Manager manager) {
		this.manager = manager;
	}
	
	@Resource(name="managerDto")
	public void setManagerDto(ManagerDto managerDto) {
		this.managerDto = managerDto;
	}
	
	public void setManagers(List<Manager> managers) {
		this.managers = managers;
	}
	@Resource(name="managerService")
	public void setManagerService(ManagerService managerService) {
		this.managerService = managerService;
	}


	public String show(){
		int id = managerDto.getId();
		manager = managerService.load(id);
		if(manager != null){
			return "show";
		}
		return "fail";
	}
	
	
	public String update(){
		manager = new Manager();
		if(managerDto.getPswd().equals(managerDto.getPswd_range())){
			manager.setId(managerDto.getId());
			manager.setName(managerDto.getName());
			manager.setPswd(managerDto.getPswd());
			manager.setCategory(managerDto.getCategory());
			managerService.alter(manager);
			return "success";
		}
		else 
			return "fail";
	}
}
