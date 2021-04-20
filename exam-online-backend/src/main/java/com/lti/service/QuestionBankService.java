
package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lti.entity.QuestionBank;
import com.lti.entity.Subject;
import com.lti.repository.QuestionBankRepository;

@Service
@Transactional
public class QuestionBankService {
	
	@Autowired
	private QuestionBankRepository questionBankRepository;
	
	
	
	public int addQuestion(QuestionBank questionBank) {
		QuestionBank add = (QuestionBank) questionBankRepository.save(questionBank);
		return add.getId();
	}
	public List<QuestionBank> viewQuestion(String subName) {
		return questionBankRepository.fetchBySubjectName(subName);
		
	}
}