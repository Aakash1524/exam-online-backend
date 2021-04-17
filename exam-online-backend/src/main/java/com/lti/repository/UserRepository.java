package com.lti.repository;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends GenericRepository {
	
	public boolean isUserPresent(String email) {
		return (Long)
				entityManager
				.createQuery("select count(u.id) from User u where u.email=:em")
				.setParameter("em", email)
				.getSingleResult() == 1 ? true : false;
	}
	
	public int fetchIdByEmailAndPassword(String email, String password) {
		return (Integer)
				entityManager
				.createQuery("select u.id from User u where u.email=:em and u.password=:pw")
				.setParameter("em", email)
				.setParameter("pw", password)
				.getSingleResult();
	}
}
