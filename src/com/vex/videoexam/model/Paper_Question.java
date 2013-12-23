package com.vex.videoexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vex_paper_qus")
@IdClass(pqPK.class)
public class Paper_Question {

	private Paper paper;
	
	private Question qus;
	
	private int qus_score;
	
	@Id
	@ManyToOne
	@JoinColumn(name="paper_id")
	public Paper getPaper() {
		return paper;
	}

	public void setPaper(Paper paper) {
		this.paper = paper;
	}

	@Id
	@ManyToOne
	@JoinColumn(name="qus_id")
	public Question getQus() {
		return qus;
	}

	public void setQus(Question qus) {
		this.qus = qus;
	}

	@Column(name="qus_score")
	public int getQus_score() {
		return qus_score;
	}

	public void setQus_score(int qus_score) {
		this.qus_score = qus_score;
	}


	
}
