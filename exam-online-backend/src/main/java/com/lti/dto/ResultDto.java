package com.lti.dto;

public class ResultDto {

	private int score;
	private String status;
	private int attempts;
	private String subject;
	private int level;
	private int highestMarks;
	
	public int getHighestMarks() {
		return highestMarks;
	}
	public void setHighestMarks(int highestMarks) {
		this.highestMarks = highestMarks;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public int getAttempts() {
		return attempts;
	}
	public void setAttempts(int attempts) {
		this.attempts = attempts;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
}
