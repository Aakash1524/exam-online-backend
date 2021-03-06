package com.lti.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_result_boot")
public class Result {
	@Id
	@GeneratedValue
	@Column(name = "result_id")
	private int id;
	
	@Column(name = "score")
	private int score;
	
	@Column(name = "attempts")
	private int attempts;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	@JoinColumn(name = "sub_level")
	private int rLevel;
	
	
	public int getrLevel() {
		return rLevel;
	}
	public void setrLevel(int rLevel) {
		this.rLevel = rLevel;
	}

	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
}