package com.lti.service;

import java.util.Collections;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.lti.dto.DisplayResultDto;
import com.lti.dto.ResultDto;
import com.lti.dto.TestHistoryDto;
import com.lti.dto.UserDto;
import com.lti.exception.UserServiceException;
import com.lti.repository.ResultRepository;

@Service
@Transactional
public class ResultService {
	@Autowired
	public ResultRepository resultRepository;
	
	public int fetchCurrentLevel(int sid, int uid) {
		try {
		System.out.println(sid);
		List<Integer> level = resultRepository.currentLevel(sid, uid);
		//List<ResultDto> levelAttempts = resultRepository.levelWithAttempts(sid, uid, level);
		System.out.println(level);
		level.add(1);
		return Collections.max(level);
		}
		catch(EmptyResultDataAccessException e) {	
			throw new UserServiceException("1");
		}
	}
	
	public int fetchSid(String sub) {
			int sid = resultRepository.sid(sub);
			return sid;		
	}
	
	public int fetchScore(String sName, int uid, int level) { 
		try {
			List<Integer> score = resultRepository.score(sName, uid, level); 
			//System.out.println("list: "+list);
			score.add(0);
			int maxScore = Collections.max(score);
			return maxScore;
		}
		catch(EmptyResultDataAccessException e){
			throw new UserServiceException("Please clear previous level");
		}
	}
	public int fetchAttempts(String sName, int uid, int level) {
		try {
			List<Integer> attempts = resultRepository.attempts(sName, uid, level);
			//System.out.println(attempts);
			attempts.add(0);
			int maxAttempts = Collections.max(attempts);
			return maxAttempts;
			}
			catch(EmptyResultDataAccessException e){
				throw new UserServiceException("0");
			}
	}
	
	public List<DisplayResultDto> fetchResult(int rid) {
		return resultRepository.viewResult(rid);
	}
	
	public List<TestHistoryDto> history(int uid){
		List<TestHistoryDto> list = resultRepository.testHistory(uid);
		//System.out.println(list);
		return list;
	}
	
	public List<UserDto> searchUser(String subject, int level, String city, String state){
		List<UserDto> list = resultRepository.adminSearch(subject, level, city, state);
		return list;
	}
	
}
