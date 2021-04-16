package com.lti.entity;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_subjects")
public class Subject {
	@Id
	@GeneratedValue
	@Column(name = "subject_id")
	private int id;
	
	@Column(name = "subject_name")
	private String subName;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subjects" )
	private List<QuestionBank> questions;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "subject")
	private List<Result> results;
	
	
	
	
	public List<Result> getResults() {
		return results;
	}

	public void setResults(List<Result> results) {
		this.results = results;
	}

	public List<QuestionBank> getQuestions() {
		return questions;
	}

	public void setQuestions(List<QuestionBank> questions) {
		this.questions = questions;
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
