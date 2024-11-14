package com.springboot.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee_management_system.model.Job;
import com.springboot.employee_management_system.service.JobService;

@RestController
public class JobController {
	@Autowired
	private JobService jobService;

	@PostMapping("/batch/add")
	public List<Job> addJobBatch(@RequestBody List<Job> list) {
		return jobService.insertInBatch(list);
	}

	@GetMapping("/batch/all")
	public List<Job> getAllJob() {
		List<Job> job = jobService.getAllJob();
		return job;
	}

}
