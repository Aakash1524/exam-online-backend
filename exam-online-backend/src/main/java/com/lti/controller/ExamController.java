package com.lti.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.ExamDto;
import com.lti.dto.ExamStatus;
import com.lti.entity.QuestionBank;
import com.lti.service.ExamServiceImpl;

@RestController
@CrossOrigin
public class ExamController {

		@Autowired
		private ExamServiceImpl examServiceImpl;
		
		
		@PostMapping("/viewQue")
		public List<QuestionBank> es(@RequestBody ExamDto examDto) {
			ExamStatus status = new ExamStatus();
			List<QuestionBank> list = examServiceImpl.findbyname(examDto.getSubName());
		//	System.out.println(list.toString());
			return list;
			
		}
		
}
