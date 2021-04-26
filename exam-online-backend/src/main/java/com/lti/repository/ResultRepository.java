package com.lti.repository;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.lti.dto.DisplayResultDto;
import com.lti.dto.ResultDto;
import com.lti.dto.TestHistoryDto;
import com.lti.dto.UserDto;

@Repository
public class ResultRepository extends GenericRepository{
	
	@SuppressWarnings("unchecked")
	public List<Integer> currentLevel(int sid, int uid) {
			return (List<Integer>)
						entityManager
						.createQuery("select r.currentLevel from Result r where subId= :sid and userId=: uid")
						.setParameter("sid", sid)
						.setParameter("uid", uid)
						.getResultList();
		
	
	}
	
	@SuppressWarnings("unchecked")
	public List levelWithAttempts(int sid, int uid, int currLevel){
		return (List<ResultDto>)
							entityManager
							.createQuery("select r.attempts, r.currentLevel from Result r where subId= :sid and userId= :uid"
										+ " and currentLevel=: cl")
							.setParameter("sid", sid)
							.setParameter("uid", uid)
							.setParameter("cl", currLevel)
							.getResultList();
	}
	
	public int sid(String sub) {
		return (Integer)
				entityManager
				.createQuery("select s.id from Subject s where s.subName=: sub")
				.setParameter("sub", sub)
				.getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Integer> score(String sName, int uid, int level) {  
		return entityManager
				.createQuery("select r.score from Result r inner join r.subject s where s.subName=: sName "
						+ "and r.user.id=: uid and r.rLevel=:level") 
				.setParameter("sName", sName)
				.setParameter("uid",uid)
				.setParameter("level",level)
				.getResultList();
	}
	@SuppressWarnings("unchecked")
	public List<Integer> attempts(String sName, int uid, int level) {
		return 
				entityManager
				.createQuery("select r.attempts from Result r inner join r.subject s where s.subName=: sName "
						+ "and r.user.id=: uid and r.rLevel=:level")
				.setParameter("sName",sName)
				.setParameter("uid",uid)
				.setParameter("level",level)
				.getResultList();			
	}
	
	@SuppressWarnings("unchecked")
	public List<DisplayResultDto> viewResult(int rid) {
		return entityManager
				.createQuery("select new com.lti.dto.DisplayResultDto(r.score, r.attempts) from Result r where r.id=: rid")
				.setParameter("rid",rid)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<TestHistoryDto> testHistory(int uid) {
		return  entityManager
				.createQuery("select new com.lti.dto.TestHistoryDto(r.subject.subName, r.rLevel, r.attempts, r.score) "
						+ "from Result r inner join r.user u where u.id= : uid")
				.setParameter("uid", uid)
				.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	public List<UserDto> adminSearch(String subject, int level, String city, String state){
		return entityManager
				.createQuery("select distinct new com.lti.dto.UserDto(u.firstName, u.middleName, u.lastName, u.phoneNo, "
						+ "u.email, u.city, u.state) from User u inner join u.results r inner join r.subject s "
						+ "where r.user.city = :city and r.user.state = :state and r.subject.subName = :subject "
						+ "and r.rLevel = :level")
				.setParameter("city",city)
				.setParameter("state",state)
				.setParameter("subject",subject)
				.setParameter("level",level)
				.getResultList();
	}
	
	public int fetchAttempts(String subject, int level, int uid) {
		return (int) entityManager
				.createQuery("select max(r.attempts) from Result r where r.subject.subName =: subject and "
						+ "r.rLevel =: level and r.user.id =: uid")
				.setParameter("subject", subject)
				.setParameter("level", level)
				.setParameter("uid", uid)
				.getSingleResult();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
