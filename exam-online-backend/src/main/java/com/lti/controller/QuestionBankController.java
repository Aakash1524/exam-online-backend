package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lti.dto.QuestionBankStatus;
import com.lti.dto.RegisterStatus;
import com.lti.entity.QuestionBank;
import com.lti.exception.QuestionBankException;
import com.lti.service.QuestionBankService;
//import com.lti.service.SubjectService;

@RestController
@CrossOrigin
public class QuestionBankController {
	
	@Autowired
	private QuestionBankService questionBankService;
	
	//@Autowired
	//private SubjectService subjectService;
	
	//@PostMapping("/add") 
	/*public QuestionBankStatus storeQuestion(@RequestBody SubjectDto subjectDto) {
		try {
			SubjectDto sdto = new SubjectDto();
			int sid = questionBankService.fetchSub(qbdto.getSubName());
			questionBank.setSubjects().set //(sdto.setId(sid);
			int id = questionBankService.addQuestion(questionBank, sid);
			QuestionBankStatus status = new QuestionBankStatus();
			
			return status;
		}
	}*/
	
	@PostMapping("/add")
	public QuestionBankStatus storeQuestions(@RequestBody QuestionBank questionBank) {
		try {
			int id = questionBankService.addQuestion(questionBank);
			QuestionBankStatus status = new QuestionBankStatus();
			//SubjectDto sdto=new SubjectDto();
			status.setStatus(true);
			status.setMessage("Question Added successfully!");
			status.setId(id);
			return status;
		}
		catch(QuestionBankException e) {
			QuestionBankStatus status = new QuestionBankStatus();
			status.setStatus(false);
			status.setMessage(e.getMessage());
			return status;
		}
	}
	
	
	
	
	
	@GetMapping("/viewQuestion") 
	public List<QuestionBank> fetchQuestion(@RequestParam("subName") String subName ) {
		 
			List<QuestionBank> qb = questionBankService.viewQuestion(subName);
			
			return qb;
			
			/*status.setCorrectAnswer(qb.getCorrectAnswer());
			status.setQuestion(((QuestionBank) qb).getQuestion());
			status.setOption1(((QuestionBank) qb).getOption1());
			status.setOption2(((QuestionBankDto) qb).getOption2());
			status.setOption3(((QuestionBankDto) qb).getOption3());
			status.setOption4(((QuestionBankDto) qb).getOption4());
			status.setMarks(((QuestionBankDto) qb).getMarks());*/
			
		
	
	}
	
	/*@PostMapping("/viewQuestion")
	public List<QuestionBank> fetchQuestions(@RequestBody SubjectDto subjectDto){
		QuestionBankStatus status = new QuestionBankStatus();
		List<QuestionBank> list = questionBankService.viewQuestion(subjectDto.getSubName());
		return list;
		
	}*/
}
