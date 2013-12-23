package com.vex.videoexam.Dto;

public class ChoiceDto extends QuestionDto {
	
	private String title;
	
	private String title_range;
	
	private String option;
	
	private String option_range;
	
	private char[] answer = new char[7];
	
	private String answer_range;
	
	private String answer_str;
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle_range() {
		return title_range;
	}

	public void setTitle_range(String title_range) {
		this.title_range = title_range;
	}


	public String getAnswer_range() {
		return answer_range;
	}

	public void setAnswer_range(String answer_range) {
		this.answer_range = answer_range;
	}

	public char[] getAnswer() {
		return answer;
	}

	public void setAnswer(char[] answer) {
		this.answer = answer;
	}

	public String getOption() {
		return option;
	}

	public void setOption(String option) {
		this.option = option;
	}

	public String getOption_range() {
		return option_range;
	}

	public void setOption_range(String option_range) {
		this.option_range = option_range;
	}

	public String getAnswer_str() {
		return answer_str;
	}

	public void setAnswer_str(String answer_str) {
		this.answer_str = answer_str;
	}




}
