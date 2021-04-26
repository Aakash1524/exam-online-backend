package com.lti.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DisplayResultDto;
import com.lti.dto.ResultDto;
import com.lti.dto.SaveResultDto;
import com.lti.dto.SubjectDto;
import com.lti.dto.TestHistoryDto;
import com.lti.dto.UserDto;
import com.lti.entity.Result;
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
	
	@PostMapping("/result")
	public SaveResultDto fetchResult(@RequestBody Result result){
		System.out.println("In result component");
		Result result1 = resultService.saveResult(result); 
		
		SaveResultDto srd = new SaveResultDto();
		srd.setAttempts(result1.getAttempts());
		srd.setScore(result1.getScore());
		if(result1.getScore()>= 70) {
			srd.setStatus("Pass");
		}
		else {
			srd.setStatus("Fail");
		}
		return srd;
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
