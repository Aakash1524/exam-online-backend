package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.entity.Subject;
import com.lti.repository.SubjectRepository;

@Service
@Transactional
public class SubjectService {
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	public List<Subject> fetchSubjectNames(){
		return subjectRepository.fetchSubjectName();
	}

}
