package com.vex.videoexam.Dto;

import org.springframework.stereotype.Component;


@Component("specifyDto")
public class SpecifyDto {
	
	private int id;
	
	private int id_range;
	
	private int father_id;
	
	private int father_id_range;
	
	private String name;
	
	private String name_range;
	
	private String desc;
	
	private String desc_range;
	
	private char leaf;
	
	private char leaf_range;
	
	private int  mgr_id;
	
	private int mgr_id_range;
	
	private int child_size;
	
	private int child_size_range;
	
	private int lev;
	
	private int lev_range;
	
	

	public int getId_range() {
		return id_range;
	}

	public void setId_range(int id_range) {
		this.id_range = id_range;
	}

	public String getName_range() {
		return name_range;
	}

	public void setName_range(String name_range) {
		this.name_range = name_range;
	}

	public String getDesc_range() {
		return desc_range;
	}

	public void setDesc_range(String desc_range) {
		this.desc_range = desc_range;
	}

	public char getLeaf_range() {
		return leaf_range;
	}

	public void setLeaf_range(char leaf_range) {
		this.leaf_range = leaf_range;
	}

	public int getMgr_id() {
		return mgr_id;
	}

	public void setMgr_id(int mgr_id) {
		this.mgr_id = mgr_id;
	}

	public int getMgr_id_range() {
		return mgr_id_range;
	}

	public void setMgr_id_range(int mgr_id_range) {
		this.mgr_id_range = mgr_id_range;
	}

	public char getLeaf() {
		return leaf;
	}

	public void setLeaf(char leaf) {
		this.leaf = leaf;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getFather_id() {
		return father_id;
	}

	public void setFather_id(int father_id) {
		this.father_id = father_id;
	}

	public int getFather_id_range() {
		return father_id_range;
	}

	public void setFather_id_range(int father_id_range) {
		this.father_id_range = father_id_range;
	}

	public int getChild_size() {
		return child_size;
	}

	public void setChild_size(int child_size) {
		this.child_size = child_size;
	}

	public int getChild_size_range() {
		return child_size_range;
	}

	public void setChild_size_range(int child_size_range) {
		this.child_size_range = child_size_range;
	}

	public int getLev() {
		return lev;
	}

	public void setLev(int lev) {
		this.lev = lev;
	}

	public int getLev_range() {
		return lev_range;
	}

	public void setLev_range(int lev_range) {
		this.lev_range = lev_range;
	}
	
}
