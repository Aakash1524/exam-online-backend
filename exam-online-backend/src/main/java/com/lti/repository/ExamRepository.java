package com.lti.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.dto.QuestionBankDto;
import com.lti.entity.QuestionBank;

@Repository
//@EnableMapRepositories(mapType = WeakHashMap.class)
public class ExamRepository extends GenericRepository {

	

		@SuppressWarnings("unchecked")
		public List<QuestionBankDto> fetchQuestion(int id,int levels){
		return 
				entityManager
				.createQuery("select new com.lti.dto.QuestionBankDto(q.id,q.question,q.option1,q.option2,q.option3,q.option4) from QuestionBank q inner join q.subject s where s.id = :id and q.levels=: levels")
				.setParameter("id", id)
				.setParameter("levels", levels)
				.getResultList();
	}
		@SuppressWarnings("unchecked")
		public List<QuestionBankDto> fetchQuestions(String subName,int levels){
			return 
					entityManager
					.createQuery("select new com.lti.dto.QuestionBankDto(q.id,q.question,q.option1,q.option2,q.option3,q.option4) from QuestionBank q inner join q.subject s where s.subName = :name and q.levels=: levels")
					.setParameter("name",subName)
					.setParameter("levels", levels)
					.getResultList();
					
	
		}
		
		
		
		
		
		
		
}
