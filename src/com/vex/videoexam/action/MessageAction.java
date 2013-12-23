package com.vex.videoexam.action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.vex.videoexam.Dto.MessageDto;
import com.vex.videoexam.model.Message;
import com.vex.videoexam.service.MessageService;

@Component("message")
@Scope("prototype")
public class MessageAction extends ActionSupport implements ModelDriven{
	
	
	public String add(){
		String content = messageDto.getContent();
		int mgr_id = messageDto.getMgr_id();
		String time = new Date().toString();
		message = new Message();
		message.setContent(content);
		message.setMgr_id(mgr_id);
		message.setTime(time);
		message.setTitle(messageDto.getTitle());
		int id = messageService.add(message);
		if(id  == 0)
			return "fail";
		message.setId(id);
		return SUCCESS;
	}
	
	public String delete() throws Exception{
		int id = messageDto.getId();
		boolean delete = messageService.delete(id);
		if(delete)
			inputStream = new ByteArrayInputStream("yes".getBytes("UTF-8"));
		else 
			inputStream = new ByteArrayInputStream("no".getBytes("UTF-8"));
        return "ajax";
	}
	
	public String update(){
		String time = new Date().toString();
		message = new Message();
		message.setId(messageDto.getId());
		message.setTitle(messageDto.getTitle());
		message.setContent(messageDto.getContent());
		message.setMgr_id(messageDto.getMgr_id());
		message.setTime(time);
		int id = messageService.alter(message);
		if(id == 0){
			message = null;
			return "fail";
		}
		return SUCCESS;
	}
	
	public String load(){
		messageMap.clear();
		int id = messageDto.getId();
		message = messageService.load(id);
		if(message == null)
			return "fail";
		MessageDto mto = new MessageDto();
		mto.setContent(message.getContent());
		mto.setId(message.getId());
		mto.setMgr_id(message.getMgr_id());
		mto.setTime(message.getTime());
		messageMap.put(mto.getId() + "", mto);
		
		return "json";
	}

	public String ajaxlist(){
		messageMap.clear();
		int index = 0;
		List<Message> ms = messageService.list(messageDto);
		messageMap.put(index + "", messageDto);
		index ++ ;
		if(ms != null)
		for(Message m : ms){
			MessageDto mdto = new MessageDto();
			mdto.setTime(m.getTime());
			mdto.setTitle(m.getTitle());
			mdto.setContent(m.getContent());
			mdto.setId(m.getId());
			mdto.setMgr_id(m.getMgr_id());
			messageMap.put( index + "", mdto);
			index ++ ;
		}		
        return "json";
	}
	
	public String list(){
		messages = messageService.list(messageDto);
		if(messages == null)
			return "fail";
		return "list";
	}
	
	public String show(){
		int id = messageDto.getId();
		message = messageService.load(id);
		if(message == null)
			return "fail";
		return "show";
	}
	private MessageService messageService;
	
	private MessageDto messageDto = new MessageDto();
	
	private InputStream inputStream;
	
	private Message message;
	
	private List<Message> messages = new ArrayList<Message>();
	
	private Map<String , MessageDto> messageMap = new LinkedHashMap<String , MessageDto>();

	public MessageService getMessageService() {
		return messageService;
	}

	@Resource(name="messageService")
	public void setMessageService(MessageService messageService) {
		this.messageService = messageService;
	}

	public MessageDto getMessageDto() {
		return messageDto;
	}

	public void setMessageDto(MessageDto messageDto) {
		this.messageDto = messageDto;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public Map<String, MessageDto> getMessageMap() {
		return messageMap;
	}

	public void setMessageMap(Map<String, MessageDto> messageMap) {
		this.messageMap = messageMap;
	}

	@Override
	public String execute() throws Exception {
		return super.execute();
	}

	@Override
	public Object getModel() {
		return messageDto;
	}
}
