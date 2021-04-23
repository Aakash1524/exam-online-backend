package com.lti.dto;

public class TestHistoryDto {
	private  String subName;
	private int level;
	private int attempts;
	private int score;
	
	
	public TestHistoryDto(String subName, int level, int attempts, int score) {
		super();
		this.subName = subName;
		this.level = level;
		this.attempts = attempts;
		this.score = score;
	}
	
	public TestHistoryDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getSubName() {
		return subName;
	}
	public void setSubName(String subName) {
		this.subName = subName;
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
		attempts = attempts;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	} 
	
	 @Override
		public String toString() {
			return "TestHistoryDto [subject : " + subName + ", level : " + level + ", attempts : " + attempts + ", score : " + score +
					"]";
		}
}
