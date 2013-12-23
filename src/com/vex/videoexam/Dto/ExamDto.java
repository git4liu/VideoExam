package com.vex.videoexam.Dto;

public class ExamDto {

	private int id;
	
	private int pic_id;
	
	private int stu_id;
	
	private int paper_id;

	public int getStu_id() {
		return stu_id;
	}

	public void setStu_id(int stu_id) {
		this.stu_id = stu_id;
	}

	public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPic_id() {
		return pic_id;
	}

	public void setPic_id(int pic_id) {
		this.pic_id = pic_id;
	}
	
	
}
