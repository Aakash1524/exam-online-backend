package com.lti.service;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dto.ExamDto;
import com.lti.dto.QuestionBankDto;
import com.lti.entity.QuestionBank;
import com.lti.entity.Subject;
import com.lti.repository.ExamRepository;

@Service
@Transactional
public class ExamServiceImpl {
	
	@Autowired
	private ExamRepository examRepository;
	
	public List<QuestionBankDto> findbyname(String subName,int levels, boolean status) {
		return  examRepository.fetchQuestions(subName,levels,status);
	}
	
	public List<QuestionBankDto> findbyid(int id,int levels, boolean status){
		return examRepository.fetchQuestion(id,levels,status);
	}
	
	/*public Subject get(String subName) {
		return examRepository.fetch(QuestionBank.class, subName);
	}*/
	
	//public Set<QuestionBankDto> fetchQuestions(ExamDto examdto){
		//QuestionBank qb = examRepository.get(examdto.getId())
		//List<QuestionBank> questionBank=
		//return examRepository.get(id);
	//}
	
}
