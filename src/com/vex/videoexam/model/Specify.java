package com.vex.videoexam.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="vex_specify")
public class Specify {

	private int id;
	
	private Specify father;
	
	private int child_size;
	
	private int lev;
	
	private String name;
	
	private String desc;
	
	private char leaf;
	
	private int mgr_id;
	
	private List<Specify> childs = new ArrayList<Specify> () ;
		
	@Column(name="specify_leaf")
	public char getLeaf() {
		return leaf;
	}

	public void setLeaf(char leaf) {
		this.leaf = leaf;
	}

	@Id
	@GeneratedValue
	@Column(name="specify_id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@ManyToOne
	@JoinColumn(name="father_id")
	public Specify getFather() {
		return father;
	}

	public void setFather(Specify father) {
		this.father = father;
	}

	@Column(name="specify_name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="specify_desc")
	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}


	@OneToMany(mappedBy="father",cascade={CascadeType.REMOVE},fetch=FetchType.LAZY,orphanRemoval=true)
	public List<Specify> getChilds() {
		return childs;
	}

	public void setChilds(List<Specify> child) {
		this.childs = child;
	}

	
	@Column(name="child_size")
	public int getChild_size() {
		return child_size;
	}

	public void setChild_size(int child_size) {
		this.child_size = child_size;
	}

	
	@Column(name="specify_lev")
	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	@Column(name="mgr_id")
	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}



	

	
	
}
