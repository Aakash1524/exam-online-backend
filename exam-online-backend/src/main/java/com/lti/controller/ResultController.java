package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DisplayResultDto;
import com.lti.dto.ResultDto;
import com.lti.dto.SubjectDto;
import com.lti.dto.TestHistoryDto;
import com.lti.dto.UserDto;
import com.lti.exception.UserServiceException;
import com.lti.service.ResultService;

@RestController
@CrossOrigin
public class ResultController {
	
	@Autowired
	public ResultService resultService;
	
	@GetMapping("/score")
	public ResultDto marks(@RequestParam(value="sName") String sName, @RequestParam(value="uid") int uid, 
			@RequestParam(value="level") int level ) {  
		int attempts;
		try {
			int currScore = resultService.fetchScore(sName, uid, level);
			try{
				attempts = resultService.fetchAttempts(sName, uid, level);
				System.out.println(attempts);
			}
			catch(UserServiceException e) {
				attempts = 0;
				System.out.println(attempts);
			}
			
			ResultDto rdto = new ResultDto();
			if(currScore<70) {
				rdto.setScore(currScore);
				rdto.setStatus("Fail");
				rdto.setAttempts(attempts);
				return rdto;
			}
			
			else {
				rdto.setScore(currScore);
				rdto.setStatus("Pass");
				rdto.setAttempts(attempts);
				return rdto;
			}
		}
		
		catch(UserServiceException e) {
			ResultDto rdto = new ResultDto();
			rdto.setStatus(e.getMessage());
			return rdto ;
		}
	}
	
	/*@GetMapping("/subName")
	public SubjectDto sid(@RequestParam(value="subName") String subName) {
		int sid = resultService.fetchSid(subName);
		SubjectDto sdto = new SubjectDto();
		sdto.setSubjectId(sid);
		return sdto;
	}*/
	
	
	/* Fetching of result on submit test */
	
	@GetMapping("/rid")
	public ResultDto fetchResult(@RequestParam(value="rid") int rid, @RequestParam(value="sName") String sName,
			@RequestParam(value="uid") int uid, @RequestParam(value="level") int level){
		List<DisplayResultDto> result = resultService.fetchResult(rid);
		
		int highestMarks = resultService.fetchScore(sName, uid, level);
		
		ResultDto rdto = new ResultDto();
		rdto.setScore((int)result.get(0).getScore());
		rdto.setAttempts((int)result.get(0).getAttempts());
		rdto.setHighestMarks(highestMarks);
		if(rdto.getScore()<70) {
			rdto.setStatus("Fail");
		}
		else {
			rdto.setStatus("Pass");
		}
		return rdto;
	}
	
	@GetMapping("/resultHistory")
	public List<TestHistoryDto> testHistory(@RequestParam(value="uid") int uid) {
		List<TestHistoryDto> testHistory = resultService.history(uid);
		return testHistory;
	}
	
	@GetMapping("/adminSearch")
	public List<UserDto> adminSearch(@RequestParam(value="subject") String subject, @RequestParam(value="level") int level,
			@RequestParam(value="city") String city, @RequestParam(value="state") String state){
		List<UserDto> list = resultService.searchUser(subject, level, city, state);
		System.out.println(list);
		return list;
	}
}
