package com.lti.dto;

public class TestHistoryDto {
	private  String subName;
	private int rLevel;
	private int attempts;
	private int score;
	
	
	public TestHistoryDto(String subName, int rLevel, int attempts, int score) {
		super();
		this.subName = subName;
		this.rLevel = rLevel;
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
	
	public int getrLevel() {
		return rLevel;
	}

	public void setrLevel(int rLevel) {
		this.rLevel = rLevel;
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
			return "TestHistoryDto [subject : " + subName + ", rLevel : " + rLevel + ", attempts : " + attempts + ", score : " + score +
					"]";
		}
}
