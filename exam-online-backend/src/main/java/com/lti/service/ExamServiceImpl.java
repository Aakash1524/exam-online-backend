package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.QuestionBank;
import com.lti.entity.Subject;
import com.lti.repository.ExamRepository;

@Service
@Transactional
public class ExamServiceImpl {
	
	@Autowired
	private ExamRepository examRepository;
	
	public List<QuestionBank> findbyname(String subName) {
		return  examRepository.fetchQuestions(subName);
	}
	public List<QuestionBank> findbyid(int id){
		return examRepository.fetchQuestion(id);
	}
}