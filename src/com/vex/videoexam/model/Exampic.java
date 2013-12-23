package com.vex.videoexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="vex_exampic")
public class Exampic {
	
	private int id;
	
	private String time;
	
	private Exam exam;
	
	private String addr;

	
	@Id
	@GeneratedValue
	@Column(name="exampic_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name="exampic_time")
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@ManyToOne
	@JoinTable(
		    name="vex_pic_exam",
		    joinColumns=
		        @JoinColumn(name="pic_id"),
		    inverseJoinColumns=
		        @JoinColumn(name="exam_id")
		    )
	public Exam getExam() {
		return exam;
	}

	public void setExam(Exam exam) {
		this.exam = exam;
	}

	@Column(name="exampic_addr")
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
