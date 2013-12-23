package com.vex.videoexam.model;

import java.io.Serializable;

public class pqPK implements Serializable{
	

	private Paper paper;
	
	private Question qus;

	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	public Question getQus() {
		return qus;
	}

	public void setQus(Question qus) {
		this.qus = qus;
	}

	
	
	
}
