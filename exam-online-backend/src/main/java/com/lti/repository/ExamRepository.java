package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Exam;
import com.lti.entity.QuestionBank;

@Repository
public class ExamRepository extends GenericRepository {

		public List<QuestionBank> fetchQuestion(int id){
		return (List<QuestionBank>)
				entityManager
				.createQuery("select q from QuestionBank q inner join q.subjects s where s.id = :id")
				.setParameter("id", id)
				.getResultList();
	}
		public List<QuestionBank> fetchQuestions(String subName){
			return
					entityManager
					.createQuery("select q from QuestionBank q inner join q.subjects s where s.subName = :name ")
					.setParameter("name",subName)
					.getResultList();
					
	
		}
		
		
		
		
		
}