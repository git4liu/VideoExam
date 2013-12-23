package com.vex.videoexam.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vex.videoexam.Dto.ChoiceDto;
import com.vex.videoexam.Dto.SpecifyDto;
import com.vex.videoexam.model.Choice;
import com.vex.videoexam.model.Manager;
import com.vex.videoexam.model.Question;
import com.vex.videoexam.model.Specify;
import com.vex.videoexam.service.ChoiceService;
import com.vex.videoexam.service.QuestionService;

@Component("choice")
@Scope("prototype")
public class ChoiceAction extends ActionSupport implements ModelDriven{

	public String add(){
		int degree = choiceDto.getDegree();
		char[] checked = choiceDto.getAnswer();
		choice = new Choice();
		choice.setTitle(choiceDto.getTitle());
		choice.setOption(choiceDto.getOption());
		choice.setAnswer(String.valueOf(choiceDto.getAnswer()));
		choice.setAnalys(choiceDto.getAnalys());
		choice.setCategory(choiceDto.getCategory());
		Specify specify = new Specify();
		specify.setId(choiceDto.getSpecify_id());
		choice.setSpecify(specify);
		choice.setMgr_id(choiceDto.getMgr_id());
		choice.setDegree(choiceDto.getDegree());
		int id = questionService.add(choice);
		if(id == 0)
			return "fail";
		choice.setId(id);
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		int id = choiceDto.getId();
		boolean delete = questionService.delete(id);
		if(delete)
			inputStream = new ByteArrayInputStream("yes".getBytes("UTF-8"));
		else 
			inputStream = new ByteArrayInputStream("no".getBytes("UTF-8"));
        return "ajax";
	}
	
	public String update(){
		char[] checked = choiceDto.getAnswer();
		choice = new Choice();
		choice.setTitle(choiceDto.getTitle());
		choice.setOption(choiceDto.getOption());
		choice.setAnswer(String.valueOf(choiceDto.getAnswer()));
		choice.setAnalys(choiceDto.getAnalys());
		choice.setCategory(choiceDto.getCategory());
		Specify specify = new Specify();
		specify.setId(choiceDto.getSpecify_id());
		choice.setSpecify(specify);
		choice.setMgr_id(choiceDto.getMgr_id());
		choice.setDegree(choiceDto.getDegree());
		choice.setId(choiceDto.getId());
		int id = questionService.alter(choice);
		if(id == 0){
			choice = null;
			return "fail";
		}
		return SUCCESS;
	}
	
	public String load(){
		int id = choiceDto.getId();
		Choice c = (Choice)questionService.load(id);
		ChoiceDto cto = new ChoiceDto();
		cto.setId(c.getId());
		cto.setAnswer(c.getAnswer().toCharArray());
		cto.setDegree(c.getDegree());
		cto.setTitle(c.getTitle());
		cto.setOption(c.getOption());
		cto.setMgr_id(c.getMgr_id());			
		choiceMap.put(c.getId() + "", cto);
		return "json";
	}

	public String ajaxlist() throws Exception{
		choiceMap.clear();
		List<?> choicelist = questionService.list(choiceDto);
		if(choicelist != null)
		for(int i = 0 ;i <choicelist.size() ; i ++){
			Choice c = (Choice) choicelist.get(i);
			ChoiceDto cto = new ChoiceDto();
			cto.setId(c.getId());
			cto.setAnswer(c.getAnswer().toCharArray());
			cto.setDegree(c.getDegree());
			cto.setTitle(c.getTitle());
			cto.setMgr_id(c.getMgr_id());			
			choiceMap.put(c.getId() + "", cto);
		}		
        return "json";
	}
	public String list(){
/*		if(questionService.list(choiceDto).size() != 0){
			for(Question q :questionService.list(choiceDto) )
				choices.add((Choice)q);
			return SUCCESS;
		}
		return "fail";*/
		
		choices = questionService.list(choiceDto);
		if(choices == null)
			return "fail";
		return "list";
	}
	
	public String show(){
		int id = choiceDto.getId();
		choice = (Choice) questionService.load(id);
		if(choice == null)
			return "fail";
		return "show";
	}
	
	
	
	
	
	private ChoiceDto choiceDto = new ChoiceDto();

	private Choice choice;

	private ChoiceService choiceService;
	
	private QuestionService questionService;

	private List<?> choices = new ArrayList<Choice>();

	private InputStream inputStream;

	private Map<String, ChoiceDto> choiceMap = new HashMap<String, ChoiceDto>();

	public ChoiceDto getChoiceDto() {
		return choiceDto;
	}

	public void setChoiceDto(ChoiceDto choiceDto) {
		this.choiceDto = choiceDto;
	}

	public Choice getChoice() {
		return choice;
	}

	public void setChoice(Choice choice) {
		this.choice = choice;
	}

	public ChoiceService getChoiceService() {
		return choiceService;
	}

	
	@Resource(name="choiceService")
	public void setChoiceService(ChoiceService choiceService) {
		this.choiceService = choiceService;
	}

	public List<?> getChoices() {
		return choices;
	}

	public void setChoices(List<Choice> choices) {
		this.choices = choices;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Map<String, ChoiceDto> getChoiceMap() {
		return choiceMap;
	}

	public void setChoiceMap(Map<String, ChoiceDto> choiceMap) {
		this.choiceMap = choiceMap;
	}

	@Override
	public Object getModel() {
		return choiceDto;
	}

	public QuestionService getQuestionService() {
		return questionService;
	}

	@Resource(name="questionService")
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}
}
