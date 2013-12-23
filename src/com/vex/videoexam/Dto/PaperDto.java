package com.vex.videoexam.Dto;

import org.springframework.stereotype.Component;

@Component("paperDto")
public class PaperDto {
	
	private int id;
	
	private int mgr_id;

	private String time;
	
	private float score;
	
	private char degree;
	
	private String desc;
	
	private int qus_mount;
	
	private String name;
	
	private String json;
	
	private int page_start;
	
	private int page_size;
	
	private int total;


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public float getScore() {
		return score;
	}

	public void setScore(float score) {
		this.score = score;
	}

	public char getDegree() {
		return degree;
	}

	public void setDegree(char degree) {
		this.degree = degree;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getQus_mount() {
		return qus_mount;
	}

	public void setQus_mount(int qus_mount) {
		this.qus_mount = qus_mount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJson() {
		return json;
	}

	public void setJson(String json) {
		this.json = json;
	}

	public int getPage_start() {
		return page_start;
	}

	public void setPage_start(int page_start) {
		this.page_start = page_start;
	}

	public int getPage_size() {
		return page_size;
	}

	public void setPage_size(int page_size) {
		this.page_size = page_size;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
}
