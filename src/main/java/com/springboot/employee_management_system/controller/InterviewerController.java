package com.springboot.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee_management_system.model.InterviewSchedular;
import com.springboot.employee_management_system.model.Interviewer;
import com.springboot.employee_management_system.service.InterviewSchedularService;
import com.springboot.employee_management_system.service.InterviewerService;

@RestController
public class InterviewerController {
	@Autowired
	private InterviewerService interviewerService;
	@Autowired
	private InterviewSchedularService interviewSchedularService;

	@PostMapping("/interviewer/batch/addInterviewer")
	public List<Interviewer> addInterviewerBatch(@RequestBody List<Interviewer> list) {
		return interviewerService.insertInBatch(list);
	}

	@PostMapping("/interviewer/scheduleinterview")
	public ResponseEntity<?> scheduleInterview(@RequestBody List<InterviewSchedular> list) {
		try {
			Integer id = null;
			for (InterviewSchedular schedular : list) {
				Interviewer interviewer = new Interviewer();
				id = interviewer.getId();
			}
			// ID validation
			if (id == null || !interviewerService.findById(id)) {
				return ResponseEntity.badRequest().body("Invalid ID: " + id);
			}

			interviewSchedularService.insertInBatch(list);
			return ResponseEntity.ok("Interview Scheduled successfully");
		} catch (

		Exception e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
					.body("Error scheduling interview: " + e.getMessage());
		}
	}
}
