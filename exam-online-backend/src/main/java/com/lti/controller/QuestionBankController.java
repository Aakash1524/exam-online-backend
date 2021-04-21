package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.lti.dto.QuestionBankStatus;
import com.lti.dto.RegisterStatus;
import com.lti.entity.QuestionBank;
import com.lti.exception.QuestionBankException;
import com.lti.service.QuestionBankService;


@RestController
@CrossOrigin
public class QuestionBankController {
	
	@Autowired
	private QuestionBankService questionBankService;
	

	@PostMapping("/add")
	public QuestionBankStatus storeQuestions(@RequestBody QuestionBank questionBank) {
		try {
			int id = questionBankService.addQuestion(questionBank);
			QuestionBankStatus status = new QuestionBankStatus();
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
	@GetMapping("/viewQuestion/{subName}/{levels}") 
	public List<QuestionBank> fetchQuestion(@PathVariable("subName") String subName,@PathVariable("levels") int levels ) {
		 
			List<QuestionBank> qb = questionBankService.viewQuestion(subName,levels);
			
			return qb;
	}
}
