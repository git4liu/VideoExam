package com.vex.videoexam.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.vex.videoexam.Dao.SpecifyDao;
import com.vex.videoexam.Dto.SpecifyDto;
import com.vex.videoexam.model.Specify;
import com.vex.videoexam.service.SpecifyService;

@Component("specifyService")
public class SpecifyServiceImpl implements SpecifyService{

	private SpecifyDao specifyDao;
	
	public SpecifyDao getSpecifyDao() {
		return specifyDao;
	}

	@Resource(name="specifyDao")
	public void setSpecifyDao(SpecifyDao specifyDao) {
		this.specifyDao = specifyDao;
	}

	@Override
	public List<Specify> list(SpecifyDto specifyDto) {
		List<Specify> specifys = specifyDao.list(specifyDto);
		return specifys;
	}

	@Override
	public Specify load(int id) {
		return specifyDao.queryById(id);
	}

	@Override
	public int add(Specify specify) {
		int father_id = specify.getFather().getId();
		if(father_id == 0)
			return specify.getId();
		Specify father = specifyDao.queryById(father_id);
		int lev = father.getLev();
		father.setChild_size(father.getChild_size() + 1);
		if(father.getLeaf() != 'N'){
			father.setLeaf('N');
		}
		specifyDao.update(father);
		specify.setLev(lev + 1);
		specifyDao.save(specify);
		return specify.getId();
		
		
		//for test
//		specifyDao.save(specify);
//		return specify.getId();
	}


	
	@Override
	public boolean delete(int id) {
		
		
		Specify specify = specifyDao.queryById(id);
		if(specify.getLeaf() != 'Y'){
			List<Specify> specifies = specify.getChilds();
			for(Specify s : specifies){
				delete(s.getId());
			}
		}
		Specify father  = specify.getFather();
		int child_size = father.getChild_size();
		father.setChild_size(child_size -1);
		if(child_size == 1){
			father.setLeaf('Y');
		}
		specifyDao.update(father);
		specifyDao.deleteById(id);
		
		
/*		try{
			Specify specify = specifyDao.queryById(id);
			Specify father = specify.getFather();
			if(father.getChild_size() == 1){
				father.setLeaf('Y');
			}
			specifyDao.deleteById(id);
			father.setChild_size(father.getChild_size() - 1);
			specifyDao.update(father);
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}*/
		return true;
	}

	@Override
	public int alter(Specify specify) {
		specifyDao.update(specify);
		return specify.getId();
	}

	@Override
	public List<Specify> child(int father_id) {
		SpecifyDto specifyDto = new SpecifyDto();
		Specify specify = specifyDao.queryById(father_id);
		if(specify.getLeaf() != 'Y'){
			specifyDto.setFather_id(father_id);
			if(father_id == 1){
				List <Specify> tops = new ArrayList<Specify>();
				tops = specifyDao.list(specifyDto);
				tops.remove(0);
				return tops;
			}
			
			return specifyDao.list(specifyDto);			
		}
		return null;
	}

	
	/*
	 * 获取指定Id的后代
	 * */
	@Override
	public List<Specify> posterity(int id) {
		Specify specify = specifyDao.queryById(id);
		List<Specify> allGenerations = new ArrayList<Specify> ();
		if(specify.getLeaf() == 'Y')
			return null;
		tree(id ,allGenerations);		
		return allGenerations;
	}
	
	
	/*
	 * 递归遍历树,查找出所有的叶子节点
	 * */
	private void tree(int id , List<Specify> specifies){
		Specify specify = specifyDao.queryById(id);
		if(specify.getLeaf() == 'Y')
			specifies.add(specify);
		else
			tree(specify.getId() , specifies);
	}

	

}
