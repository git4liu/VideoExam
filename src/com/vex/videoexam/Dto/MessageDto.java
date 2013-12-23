package com.vex.videoexam.Dto;



public class MessageDto {

	private int id;
	
	private int id_range;
	
	private int mgr_id;
	
	private String content;
	
	private String time;
	
	private String time_range;
	
	private String title;
	
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

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getId_range() {
		return id_range;
	}

	public void setId_range(int id_range) {
		this.id_range = id_range;
	}

	public String getTime_range() {
		return time_range;
	}

	public void setTime_range(String time_range) {
		this.time_range = time_range;
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
