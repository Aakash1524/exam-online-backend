package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Subject;

@Repository
public class SubjectRepository extends GenericRepository{
	
	public List<Subject> fetchSubjectName(){
		return 
				entityManager
				.createQuery("select s.subName from Subject s")
				.getResultList();
	}
	public List<Subject> fetchSubjectNameAndId(){
		return
				entityManager
				.createQuery("select s from Subject s")
				.getResultList();
	}
	
}
