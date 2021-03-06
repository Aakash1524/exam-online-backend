package com.lti.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ExamDto;
import com.lti.dto.QuestionBankDto;
//import com.lti.dto.ExamStatus;
import com.lti.entity.QuestionBank;
import com.lti.service.ExamServiceImpl;

@RestController
@CrossOrigin
public class ExamController {

		@Autowired
		private ExamServiceImpl examServiceImpl;
		
		
		@GetMapping("/viewQue/{subName}/{levels}/{status}")
		public List<QuestionBankDto> es(@PathVariable("subName") String subName, 
				@PathVariable("levels") int levels, @PathVariable("status") boolean status) {
			
			List<QuestionBankDto> list = examServiceImpl.findbyname(subName,levels,status);
		//	System.out.println(list.toString());
			Collections.shuffle(list);
			return list;
			
		}
		
		@GetMapping("/view/{id}/{levels}/{status}")
		public List<QuestionBankDto> qs(@PathVariable("id") int id , 
				@PathVariable ("levels") int levels, @PathVariable("status") boolean status){
			List<QuestionBankDto> list = examServiceImpl.findbyid(id,levels,status);
			//ExamStatus es = new ExamStatus();
			//es.getQuestion();
		//	es.getOption1();
			//es.getOption2();
			//for(QuestionBank questionBank : examDto.getId()) {
				//examServiceImpl.findbyid(examStatus.get);
			//}
			//List<QuestionBank> list = examServiceImpl.findbyid(examDto.getId());
			return list;
		}
		
		//@GetMapping("/que")
		//public List<QuestionBank> qb(@RequestParam("id")int id){
		//	List<QuestionBank> list = examServiceImpl.fetchQuestions(id);
			//return list;
		//}
		
		
}
