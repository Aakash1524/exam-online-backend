package com.lti.dto;

public class DisplayResultDto {
	private int score;
	private int attempts;
	
	
	public DisplayResultDto(int score, int attempts) {
		super();
		this.score = score;
		this.attempts = attempts;
	}
	
	public DisplayResultDto() {
		// TODO Auto-generated constructor stub
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
	
	 @Override
		public String toString() {
			return "DisplayResultDto [score : " + score + ", attempts : " + attempts + "]";
		}
}
