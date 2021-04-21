package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ExamDto;
//import com.lti.dto.ExamStatus;
import com.lti.entity.QuestionBank;
import com.lti.service.ExamServiceImpl;

@RestController
@CrossOrigin
public class ExamController {

		@Autowired
		private ExamServiceImpl examServiceImpl;
		
		
		@GetMapping("/viewQue")
		public List<QuestionBank> es(@RequestParam("subName") String subName) {
			
			List<QuestionBank> list = examServiceImpl.findbyname(subName);
		//	System.out.println(list.toString());
			return list;
			
		}
		
		@GetMapping("/view")
		public List<QuestionBank> qs(@RequestParam("id") int id ){
			List<QuestionBank> list = examServiceImpl.findbyid(id);
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
		
}