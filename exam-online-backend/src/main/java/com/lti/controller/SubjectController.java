package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.entity.Subject;
import com.lti.service.SubjectService;

@RestController
@CrossOrigin
public class SubjectController {
	
	@Autowired 
	private SubjectService subjectService;

	@GetMapping("/fetchQuestion") 
	public List<Subject> fetchSubjects() {
		 
			List<Subject> sub = subjectService.fetchSubjectNames();
			
			return sub;
	}
	@GetMapping("/fetchSubjects") 
	public List<Subject> fetchSub() {
		 
			List<Subject> sub = subjectService.fetchSubjects();
			
			return sub;
	}
}
