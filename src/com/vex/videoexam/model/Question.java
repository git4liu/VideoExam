package com.vex.videoexam.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="vex_qus")
@Inheritance(strategy=InheritanceType.JOINED)
public class Question {
	
	private int id;
	
	private char category;
	
	private Specify specify;
	
	private String analys;
	
	private int degree;

	private int mgr_id;
	
	private Set<Paper_Question>  qus_papers = new HashSet<Paper_Question>();
	
	private List<Student> students = new ArrayList<Student>();

	@Id
	@GeneratedValue
	@Column(name="qus_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="qus_category")
	public char getCategory() {
		return category;
	}

	public void setCategory(char category) {
		this.category = category;
	}
	

	@ManyToMany(mappedBy="qustions")
	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
	@ManyToOne
	public Specify getSpecify() {
		return specify;
	}

	public void setSpecify(Specify specify) {
		this.specify = specify;
	}
	
	@Column(name="qus_analys")
	public String getAnalys() {
		return analys;
	}

	public void setAnalys(String analys) {
		this.analys = analys;
	}

	


	@Column(name="mgr_id")
	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	@Column(name="qus_degree")
	public int getDegree() {
		return degree;
	}

	public void setDegree(int degree) {
		this.degree = degree;
	}

	@OneToMany(mappedBy="qus",cascade=CascadeType.ALL)
	public Set<Paper_Question> getQus_papers() {
		return qus_papers;
	}

	public void setQus_papers(Set<Paper_Question> qus_papers) {
		this.qus_papers = qus_papers;
	}


}
