package com.lti.repository;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.QuestionBank;

@Repository
public class QuestionBankRepository extends GenericRepository {
	
	public List<QuestionBank> fetchBySubjectNameAndLevel(String subName, int level){
		return
				entityManager
				.createQuery("select q from QuestionBank q inner join q.subject s where s.subName = :name and q.levels= :levels")
				.setParameter("name", subName)
				.setParameter("level", level)
				.getResultList();
	}
}