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
	
	@PostMapping("/score")
	public SaveResultDto marks(@RequestBody Result result) { 

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
