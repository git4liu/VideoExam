package com.vex.videoexam.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="vex_paper")
public class Paper {
	
	private int id;
	
	private int mgr_id;
	
	private String time;
	
	private float score;
	
	private char degree;
	
	private String desc;
	
	private int qus_mount;
	
	private String name;
	
	private Set<Paper_Question> paper_questions = new HashSet<Paper_Question> ();
	
	private List<Student> students = new ArrayList<Student>();


	@Id
	@GeneratedValue
	@Column(name="paper_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="paper_time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Column(name="paper_score")
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
	
	
	@ManyToMany(mappedBy="qustions")
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Column(name="mgr_id")
	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	@Column(name="paper_desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	@Column(name="paper_qus_mount")
	public int getQus_mount() {
		return qus_mount;
	}

	
	public void setQus_mount(int qus_mount) {
		this.qus_mount = qus_mount;
	}

	@Column(name="paper_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy="paper",cascade={CascadeType.ALL},fetch=FetchType.EAGER)
	public Set<Paper_Question> getPaper_questions() {
		return paper_questions;
	}

	public void setPaper_questions(Set<Paper_Question> paper_questions) {
		this.paper_questions = paper_questions;
	}
}
