package com.vex.videoexam.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vex.videoexam.Dto.MessageDto;
import com.vex.videoexam.Dto.PaperDto;
import com.vex.videoexam.Dto.PaperDtoSimple;
import com.vex.videoexam.Dto.Paper_QuestionDto;
import com.vex.videoexam.model.Message;
import com.vex.videoexam.model.Paper;
import com.vex.videoexam.model.Paper_Question;
import com.vex.videoexam.service.PaperService;


@Component("paper")
@Scope("prototype")
public class PaperAction extends ActionSupport implements ModelDriven{
	
	
	public String add(){
		paper = new Paper();
		paper.setMgr_id(paperDto.getMgr_id());
		paper.setScore(paperDto.getScore());
		paper.setTime(new Date().toString());
		paper.setDegree(paperDto.getDegree());
		paper.setDesc(paperDto.getDesc());
		paper.setQus_mount(paperDto.getQus_mount());
		paper.setName(paperDto.getName());
		int id = paperService.add(paper);
		if(id != 0)
			return SUCCESS;
		return "fail";
	}
	
	public String delete() throws Exception{ 
		int id = paperDto.getId();
		boolean delete = paperService.delete(id);
		if(delete)
			inputStream = new ByteArrayInputStream("yes".getBytes("UTF-8"));
		else 
			inputStream = new ByteArrayInputStream("no".getBytes("UTF-8"));
        return "ajax";
	}
	
	public String update(){
		paper = new Paper();
		paper.setMgr_id(paperDto.getMgr_id());
		paper.setScore(paperDto.getScore());
		paper.setTime(paperDto.getTime());
		paper.setDegree(paperDto.getDegree());
		paper.setId(paperDto.getId());
		paper.setDesc(paperDto.getDesc());
		paper.setQus_mount(paperDto.getQus_mount());
		paper.setName(paperDto.getName());
		int id = paperService.alter(paper);
		if(id != 0)
			return SUCCESS;
		paper = null;
		return "fail";
	}
	
	public String load(){
		
		return  "ajax";
	}
	
	public String qus(){
		int id = paperDto.getId();
		paper = paperService.load(id);
		
		if(paper == null)
			return "fail";
		return "qus";
	}
	
	
	public String list(){
		papers = paperService.list(paperDto);
		if(papers == null)
			return "fail";
		return "list";
	}
	
	public String show(){
		int id = paperDto.getId();
		paper = paperService.load(id);
		if(paper == null)
			return "fail";
		return "show";
	}
	
	public String ajaxlist(){
		paperMap.clear();
		int index = 0;
		List<Paper> ps = paperService.list(paperDto);
		paperMap.put(index + "", paperDto);
		index ++ ;
		if(ps != null)
		for(Paper p : ps){
			PaperDto pdto = new PaperDto();
			pdto.setId(p.getId());
			pdto.setName(p.getName());
			pdto.setDesc(p.getDesc());
			pdto.setDegree(p.getDegree());
			pdto.setMgr_id(p.getMgr_id());
			paperMap.put( index + "", pdto);
			index ++ ;
		}		
        return "json2";
	}
	
	public String fill() throws Exception{
		String json = paperDto.getJson();
		JSONObject jsonobj = JSONObject.fromObject(json);
		jsonobj.accumulateAll(choiceMap);
		JSONArray jsonArray = jsonobj.getJSONArray("myjson");
		List<?> paper_qus_list = (ArrayList<?>)JSONArray.toCollection(jsonArray, Paper_QuestionDto.class);
		int size = paperService.fill(paper_qus_list);
		inputStream = new ByteArrayInputStream(("当前试卷已经存储" + size + "个").getBytes("UTF-8"));
		return "ajax";
	}
	
	public String removeQus() throws Exception{
		String json = paperDto.getJson();
		JSONObject jsonobj = JSONObject.fromObject(json);
		JSONArray jsonArray = jsonobj.getJSONArray("myjson");
		List<?> paper_qus_list = (ArrayList<?>)JSONArray.toCollection(jsonArray, Paper_QuestionDto.class);
		int remain = paperService.removeQus(paper_qus_list);
		inputStream = new ByteArrayInputStream(("当前试卷剩余" + remain  + "个").getBytes("UTF-8"));
		return "ajax";
	}
	
	
	private PaperDto paperDto = new PaperDto();

	private Paper paper;

	private PaperService paperService;
	
	private List<?> papers = new ArrayList<Paper>();

	private InputStream inputStream;

	private Map<String, PaperDto> choiceMap = new HashMap<String, PaperDto>();
	
	private Map<String ,PaperDto> paperMap = new LinkedHashMap<String ,PaperDto>();

	public PaperDto getPaperDto() {
		return paperDto;
	}

	public void setPaperDto(PaperDto paperDto) {
		this.paperDto = paperDto;
	}

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public PaperService getPaperService() {
		return paperService;
	}

	@Resource(name="paperService")
	public void setPaperService(PaperService paperService) {
		this.paperService = paperService;
	}

	public List<?> getPapers() {
		return papers;
	}

	public void setPapers(List<?> papers) {
		this.papers = papers;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Map<String, PaperDto> getChoiceMap() {
		return choiceMap;
	}

	public void setChoiceMap(Map<String, PaperDto> choiceMap) {
		this.choiceMap = choiceMap;
	}

	@Override
	public Object getModel() {
		return paperDto;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	public Map<String, PaperDto> getPaperMap() {
		return paperMap;
	}

	public void setPaperMap(Map<String, PaperDto> paperMap) {
		this.paperMap = paperMap;
	}
	
	

}
