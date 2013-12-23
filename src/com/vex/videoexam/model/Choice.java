package com.vex.videoexam.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="vex_choice")
public class Choice extends Question{
		
	private String title;
	
	private String option;
	
	private String answer;


	@Column(name="choice_title")
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}



	@Column(name="choice_answer")
	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name="choice_option")
	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

}
