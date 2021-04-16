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
@Table(name = "tbl_question_bank")
public class QuestionBank {
	@Id
	@GeneratedValue
	@Column(name = "question_id")
	private int id;
	
	@Column(name = "ques_type")
	private String type;
	
	@Column(name = "marks")
	private int marks;
	
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
	
	@Column(name = "option_5")
	private String option5;
	
	@Column(name = "correct_answer")
	private String correctAnswer;
	
	@Column(name = "hint")
	private String hint;
	
	@ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "subject_id")
    private Subject subjects;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_answer_id")
    private UserAnswer userAnswers;
	
	
	
	public UserAnswer getUserAnswers() {
		return userAnswers;
	}
	public void setUserAnswers(UserAnswer userAnswers) {
		this.userAnswers = userAnswers;
	}
	public Subject getSubjects() {
		return subjects;
	}
	public void setSubjects(Subject subjects) {
		this.subjects = subjects;
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
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	public String getOption5() {
		return option5;
	}
	public void setOption5(String option5) {
		this.option5 = option5;
	}
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
}
