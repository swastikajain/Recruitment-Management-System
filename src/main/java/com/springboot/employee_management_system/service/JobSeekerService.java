package com.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employee_management_system.model.JobSeeker;
import com.springboot.employee_management_system.repository.JobSeekerRepository;

@Service
public class JobSeekerService {

	@Autowired
	JobSeekerRepository jobSeekerRepository;

	public List<JobSeeker> insertInBatch(List<JobSeeker> list) {
		return jobSeekerRepository.saveAll(list);
	}

	public List<JobSeeker> getAllJobSeeker() {
		return jobSeekerRepository.findAll();
	}

}
