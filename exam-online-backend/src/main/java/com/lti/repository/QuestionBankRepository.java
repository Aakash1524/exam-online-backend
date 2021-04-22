package com.lti.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.QuestionBank;

@Repository
public class QuestionBankRepository extends GenericRepository {
	
	public List<QuestionBank> fetchBySubjectNameAndLevel(String subName, int levels){
		return
				entityManager
				.createQuery("select q from QuestionBank q inner join q.subject s where s.subName = :name and q.levels= :levels")
				.setParameter("name", subName)
				.setParameter("levels", levels)			
				.getResultList();
	}
	public void updateStatus(List<Integer> qb) {
		
			entityManager
			.createQuery("UPDATE QuestionBank q SET q.status = :status where q.id in :(qb)")
			.setParameter("status", false)
			.executeUpdate();	
	}
}