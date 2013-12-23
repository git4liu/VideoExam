package com.vex.videoexam.Dto;

public class Paper_QuestionDto {

	
	private int paper_id;
	
	private long paper_qus_id;
	
	private int qus_score;

	public long getPaper_qus_id() {
		return paper_qus_id;
	}

	public void setPaper_qus_id(long paper_qus_id) {
		this.paper_qus_id = paper_qus_id;
	}

	public int getQus_score() {
		return qus_score;
	}

	public void setQus_score(int qus_score) {
		this.qus_score = qus_score;
	}

	public int getPaper_id() {
		return paper_id;
	}

	public void setPaper_id(int paper_id) {
		this.paper_id = paper_id;
	}
}
