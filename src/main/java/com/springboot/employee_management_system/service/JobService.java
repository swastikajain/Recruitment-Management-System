package com.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employee_management_system.model.Job;
import com.springboot.employee_management_system.repository.JobRepository;

@Service
public class JobService {

	@Autowired
	private JobRepository jobRepository;

	public List<Job> insertInBatch(List<Job> list) {
		return jobRepository.saveAll(list);
	}

	public List<Job> getAllJob() {
		return jobRepository.findAll();
	}

	public List<Job> getJobsByRole(String roleName) {
        return jobRepository.findJobsByRole(roleName);
    }

}
