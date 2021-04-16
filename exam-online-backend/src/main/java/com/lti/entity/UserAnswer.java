package com.lti.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_user_answer")
public class UserAnswer {
	@Id
	@GeneratedValue
	@Column(name = "user_answer_id")
	private int id;
	
	@Column(name = "answer_given")
	private String answerGiven;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="question_id")
	private QuestionBank questionBank;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "exam_id")
	private Exam exam;

	public Exam getExam() {
		return exam;
	}
	public void setExam(Exam exam) {
		this.exam = exam;
	}
	public QuestionBank getQuestionBank() {
		return questionBank;
	}
	public void setQuestionBank(QuestionBank questionBank) {
		this.questionBank = questionBank;
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
	public String getAnswerGiven() {
		return answerGiven;
	}
	public void setAnswerGiven(String answerGiven) {
		this.answerGiven = answerGiven;
	}

	

}
