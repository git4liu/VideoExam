package com.vex.videoexam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/*
 * ÿ��student��paper����һ��exam
 * ���exam�п������Ե��������������ʱ�䣬���Լ࿼���
 * */
@Entity
@Table(name="vex_exam")
public class Exam {
	
	private int id;
	
	private Manager manager;
	
	private Stu_Paper stu_paper;
	
	private String time;
	
	private char cheat;
	
	private List<Exampic> exampics = new ArrayList<Exampic>();

	
	@Id
	@GeneratedValue
	@Column(name="exam_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="mgr_id")
	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public char getCheat() {
		return cheat;
	}

	public void setCheat(char cheat) {
		this.cheat = cheat;
	}

	@OneToMany(mappedBy="exam")
	public List<Exampic> getExampics() {
		return exampics;
	}

	public void setExampics(List<Exampic> exampics) {
		this.exampics = exampics;
	}
	
	@OneToOne
	@JoinColumn(name="stu_paper_id")
	public Stu_Paper getStu_paper() {
		return stu_paper;
	}

	public void setStu_paper(Stu_Paper stu_paper) {
		this.stu_paper = stu_paper;
	}

}
