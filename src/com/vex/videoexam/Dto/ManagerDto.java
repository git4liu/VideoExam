package com.vex.videoexam.Dto;

import org.springframework.stereotype.Component;

@Component("managerDto")
public class ManagerDto {
	
	private int id;
	
	private int id_range;

	private String name_range;
	
	private String name;
	
	private String pswd;
	
	private String pswd_range;
	
	private int category;
	
	private int category_range;

	

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getCategory_range() {
		return category_range;
	}

	public void setCategory_range(int category_range) {
		this.category_range = category_range;
	}

	public int getId_range() {
		return id_range;
	}

	public void setId_range(int id_range) {
		this.id_range = id_range;
	}

	public String getName_range() {
		return name_range;
	}

	public void setName_range(String name_range) {
		this.name_range = name_range;
	}

	
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
	
}
