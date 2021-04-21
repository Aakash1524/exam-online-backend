package com.lti.dto;

import java.util.List;

import com.lti.entity.QuestionBank;
import com.lti.entity.Subject;

public class ExamDto {
	

	private String subName;
	private int id;
	private int levels;

	

	public int getLevels() {
		return levels;
	}

	public void setLevels(int levels) {
		this.levels= levels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}
	
	
	
	

	

	


}
