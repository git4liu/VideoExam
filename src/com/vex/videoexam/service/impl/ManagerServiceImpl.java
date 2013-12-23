package com.vex.videoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.ManagerDao;
import com.vex.videoexam.Dto.ManagerDto;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.service.ManagerService;


@Component("managerService")
public class ManagerServiceImpl implements ManagerService{

	private ManagerDao managerDao;
	
	private List<Manager> managerOnline = new ArrayList<Manager>();
	
	public List<Manager> getManagerOnline() {
		return managerOnline;
	}

	public void setManagerOnline(List<Manager> managerOnline) {
		this.managerOnline = managerOnline;
	}

	public ManagerDao getManagerDao() {
		return managerDao;
	}

	@Resource(name="managerDao")
	public void setManagerDao(ManagerDao managerDao) {
		this.managerDao = managerDao;
	}

	@Override
	public Manager logIn(String name, String pswd) {
		Manager manager = managerDao.queryByName(name);
		if(manager!=null){
			if(manager.getPswd().equals(pswd)){
				managerOnline.add(manager);
				return manager;
			}
		}
		return null;
	}

	@Override
	public boolean logOut(int id) {
		for(int i = 0; i <managerOnline.size(); i ++){
			if(managerOnline.get(i).getId() == id){
				managerOnline.remove(i);
				return true;
			}
		}
		return false;
	}

	@Override
	public List<Manager> list(ManagerDto managerDto) {
		List<Manager> managers = managerDao.list(managerDto);
		return managers;
	}

	@Override
	public int add(Manager manager) {
		int id = managerDao.save(manager);
		return id;
	}

	@Override
	public int alter(Manager manager) {
		int id = managerDao.update(manager);
		return id;
	}

	@Override
	public boolean delete(int id) {
		managerDao.deleteById(id);
		Manager manager = managerDao.queryById(id);
		if(manager != null)
			return false;
		return true;
	}

	@Override
	public Manager load(int id) {
		Manager manager = managerDao.queryById(id);
		return manager;
	}

	@Override
	public Manager load(String name) {
		Manager manager = managerDao.queryByName(name);
		return manager;
	}


}
