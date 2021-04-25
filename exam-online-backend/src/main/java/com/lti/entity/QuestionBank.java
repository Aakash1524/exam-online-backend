package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tbl_question_bank_trial")
public class QuestionBank {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "my_seq_ques")
	@SequenceGenerator(sequenceName = "question_seq", allocationSize = 1, name = "my_seq_ques")
	@Column(name = "question_id")
	private int id;
	
	@Column(name = "question")
	private String question;
	
	@Column(name = "option_1")
	private String option1;
	
	@Column(name = "option_2")
	private String option2;
	
	@Column(name = "option_3")
	private String option3;
	
	@Column(name = "option_4")
	private String option4;
	
	@Column(name = "correct_answer")
	private String correctAnswer;
	
	@Column(name = "marks")
	private int marks;
	
	@Column(name = "levels")
	private int levels;
	
	@Column(name = "status")
	private boolean status = true; 
	
	@ManyToOne//(fetch=FetchType.LAZY)
    @JoinColumn(name = "subject_id")
    private Subject subject;
	
	/*@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_answer_id")
    private UserAnswer userAnswers;*/
	

	public QuestionBank(int parseInt, String string, String string2, String string3, String string4, String string5,
			String string6, int parseInt2, int parseInt3, boolean parseBoolean) {
		// TODO Auto-generated constructor stub
	}
	/*public UserAnswer getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(UserAnswer userAnswers) {
		this.userAnswers = userAnswers;
	}*/
	public Subject getSubject() {
		return subject;
	}
	public void setSubject(Subject subject) {
		this.subject = subject;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	
	public String getCorrectAnswer() {
		return correctAnswer;
	}
	public void setCorrectAnswer(String correctAnswer) {
		this.correctAnswer = correctAnswer;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getOption3() {
		return option3;
	}
	public void setOption3(String option3) {
		this.option3 = option3;
	}
	public String getOption4() {
		return option4;
	}
	public void setOption4(String option4) {
		this.option4 = option4;
	}
	public int getLevels() {
		return levels;
	}
	public void setLevels(int levels) {
		this.levels = levels;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	  @Override
	  public String toString() {
	    return "Tutorial [id=" + id + ", question=" + question + ", option1=" + option1 + ", option2=" + option2 + ", option3=" + option3 + ""
	    		+ " , option4=" + option4 + ", correctAnswer=" + correctAnswer + ", marks=" + marks + ", levels=" + levels + ", status=" + status + ", subject=" + subject +"]";
	  }
	
}
