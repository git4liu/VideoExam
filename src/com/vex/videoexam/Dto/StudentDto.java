package com.vex.videoexam.Dto;

import org.springframework.stereotype.Component;

@Component("studentDto")
public class StudentDto {
	
	private int id;
	
	private String name;
	
	private String pswd;
	
	private String pswd_range;
	
	private String mail;
	
	private String picAddr;
	
	private String localPicAddr;
	
	private String picId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	public String getPswd_range() {
		return pswd_range;
	}

	public void setPswd_range(String pswd_range) {
		this.pswd_range = pswd_range;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getPicAddr() {
		return picAddr;
	}

	public void setPicAddr(String picAddr) {
		this.picAddr = picAddr;
	}

	public String getLocalPicAddr() {
		return localPicAddr;
	}

	public void setLocalPicAddr(String localPicAddr) {
		this.localPicAddr = localPicAddr;
	}

	public String getPicId() {
		return picId;
	}

	public void setPicId(String picId) {
		this.picId = picId;
	}
}
