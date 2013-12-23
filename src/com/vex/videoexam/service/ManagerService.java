package com.vex.videoexam.service;

import java.util.List;

import com.vex.videoexam.Dto.ManagerDto;
import com.vex.videoexam.model.Manager;

public interface ManagerService {
	
	public Manager logIn(String name ,String pswd);
	
	public boolean logOut(int id);
	
	public List<Manager> list(ManagerDto managerDto);

	public List<Manager> getManagerOnline();
	
	public int add(Manager manager);
	
	public int alter(Manager manager);
	
	public boolean delete(int id);
	
	public Manager load(int id);
	
	public Manager load(String name);
	
}
