package com.vex.videoexam.Dao;

import java.util.List;

import com.vex.videoexam.Dto.ManagerDto;
import com.vex.videoexam.model.Manager;

public interface ManagerDao {
	
	
	 public int save(Manager manager);
	 
	 public void deleteById(int id);
	 
	 public void deleteByName(String name);
	 
	 public int update(Manager manager);
	 
	 public Manager queryById(int id);
	 
	 public Manager queryByName(String name);
	 
	 public List<Manager> list(ManagerDto managerDto);


}
