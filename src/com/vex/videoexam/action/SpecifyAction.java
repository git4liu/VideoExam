package com.vex.videoexam.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;



import net.sf.json.JSONObject;
import net.sf.json.groovy.GJson;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vex.videoexam.Dto.SpecifyDto;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.model.Specify;
import com.vex.videoexam.service.SpecifyService;
import com.vex.videoexam.service.aspect.Authority;

@Component("specify")
@Scope("prototype")
public class SpecifyAction extends ActionSupport implements ModelDriven{
	

	public String show(){
		int id = specifyDto.getId();
		specify = specifyService.load(id);
		return "show";
	}
	
	public String add(){
		specify = new Specify();
		specify.setLeaf('Y');
		specify.setDesc(specifyDto.getDesc());
		specify.setFather(new Specify());
		specify.getFather().setId(specifyDto.getFather_id());
		specify.setMgr_id(specifyDto.getMgr_id());
		specify.setName(specifyDto.getName());
		int id = specifyService.add(specify);
		if(id != 0){
			specify.setId(id);
			return SUCCESS;
			
		}
		else 
			return "fail";
	}
	
	public String update(){
		int id = specifyDto.getId();
		int child_size = specifyDto.getChild_size();
		String desc = specifyDto.getDesc();
		char leaf = specifyDto.getLeaf();
		int lev = specifyDto.getLev();
		String name = specifyDto.getName();
		int father_id = specifyDto.getFather_id();
		int mgr_id = specifyDto.getMgr_id();
		
		if(id ==0 || father_id == 0 || mgr_id == 0){
			return "fail";
		}
		if(desc == null || name == null){
			return "fail";
		}
		specify = new Specify();
		specify.setId(id);
		specify.setChild_size(child_size);
		specify.setDesc(desc);
		specify.setLeaf(leaf);
		specify.setLev(lev);
		specify.setName(name);
		Specify father = new Specify();
		father.setId(father_id);
		specify.setFather(father);
		specify.setMgr_id(mgr_id);
		
		
		int ret_id = specifyService.alter(specify);
		if(ret_id == 0)
			return "fail";
		return SUCCESS;
	}
	
	public String load(){
		return "ajax";
	}
	
	public String delete() throws Exception{
		int id = specifyDto.getId();
		boolean delete = specifyService.delete(id);
		if(delete)
			inputStream = new ByteArrayInputStream("yes".getBytes("UTF-8"));
		else 
			inputStream = new ByteArrayInputStream("no".getBytes("UTF-8"));
        return "ajax";
	}

	public String list(){
		specifies = specifyService.child(specifyDto.getFather_id());
		return "list";
	}
	
	public String ajaxlist() throws Exception{
		specifyMap.clear();
		List<Specify> childlist = specifyService.child(specifyDto.getFather_id());
		if(childlist != null)
		for(Specify specify : childlist){
			SpecifyDto sdto = new SpecifyDto();
			sdto.setId(specify.getId());
			sdto.setName(specify.getName());
			sdto.setFather_id(specify.getFather().getId());
			sdto.setChild_size(specify.getChild_size());
			sdto.setDesc(specify.getDesc());
			sdto.setLeaf(specify.getLeaf());
			sdto.setMgr_id(specify.getMgr_id());
			sdto.setLev(specify.getLev());
			specifyMap.put(specify.getId() + "", sdto);
		}		
        return "json";
	}
	
	private SpecifyService specifyService;
	
	private List<Specify>  specifies =   new ArrayList<Specify> ();
	
	private SpecifyDto specifyDto = new SpecifyDto();
	
	private Specify specify;
	
	private Authority authority;
	
	private InputStream inputStream;
	
	private Map<String ,SpecifyDto> specifyMap  = new HashMap<String,SpecifyDto> ();

	@Override
	public Object getModel() {
		return specifyDto;
	}
	
	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public SpecifyService getSpecifyService() {
		return specifyService;
	}

	@Resource(name="specifyService")
	public void setSpecifyService(SpecifyService specifyService) {
		this.specifyService = specifyService;
	}

	public SpecifyDto getSpecifyDto() {
		return specifyDto;
	}

	public void setSpecifyDto(SpecifyDto specifyDto) {
		this.specifyDto = specifyDto;
	}

	public Specify getSpecify() {
		return specify;
	}

	public void setSpecify(Specify specify) {
		this.specify = specify;
	}

	public Authority getAuthority() {
		return authority;
	}

	public void setAuthority(Authority authority) {
		this.authority = authority;
	}

	public List<Specify> getSpecifies() {
		return specifies;
	}

	public void setSpecifies(List<Specify> specifies) {
		this.specifies = specifies;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public Map<String, SpecifyDto> getSpecifyMap() {
		return specifyMap;
	}

	public void setSpecifyMap(Map<String, SpecifyDto> specifyMap) {
		this.specifyMap = specifyMap;
	}
	
}
