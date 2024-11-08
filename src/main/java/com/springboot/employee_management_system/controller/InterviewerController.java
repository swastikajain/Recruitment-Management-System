package com.springboot.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee_management_system.model.Interviewer;
import com.springboot.employee_management_system.service.InterviewerService;

@RestController
public class InterviewerController {
	@Autowired
	private InterviewerService interviewerService;

	@PostMapping("/interviewer/batch/addInterviewer")
	public List<Interviewer> addInterviewerBatch(@RequestBody List<Interviewer> list) {
		return interviewerService.insertInBatch(list);
	}
}
