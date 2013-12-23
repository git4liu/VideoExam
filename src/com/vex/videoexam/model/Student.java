package com.vex.videoexam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;


@Entity
@Table(name="vex_stu")
public class Student {
	
	private int id;
	
	private String name;
	
	private String pswd;
	
	private String mail;
	
	private String picAddr;
	
	private List<Paper> papers = new ArrayList<Paper>();
	
	private List<Question> qustions = new ArrayList<Question>();

	
	@Id
	@GeneratedValue
	@Column(name="stu_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
	@Column(name="stu_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="stu_pswd")
	public String getPswd() {
		return pswd;
	}

	public void setPswd(String pswd) {
		this.pswd = pswd;
	}

	@Column(name="stu_mail")
	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	@Column(name="stu_pic")
	public String getPicAddr() {
		return picAddr;
	}

	public void setPicAddr(String picAddr) {
		this.picAddr = picAddr;
	}

	
	@ManyToMany
	@JoinTable(
		    name="vex_stu_paper",
		    joinColumns=
		        @JoinColumn(name="stu_id"),
		    inverseJoinColumns=
		        @JoinColumn(name="paper_id")
		    )
	public List<Paper> getPapers() {
		return papers;
	}

	public void setPapers(List<Paper> papers) {
		this.papers = papers;
	}

	

	
	@ManyToMany
	@JoinTable(
		    name="vex_stu_qus",
		    joinColumns=
		        @JoinColumn(name="stu_id"),
		    inverseJoinColumns=
		        @JoinColumn(name="qus_id")
		    )
	public List<Question> getQustions() {
		return qustions;
	}

	public void setQustions(List<Question> qustions) {
		this.qustions = qustions;
	}
	
	
}
