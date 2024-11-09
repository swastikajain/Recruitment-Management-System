package com.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employee_management_system.model.Interviewer;
import com.springboot.employee_management_system.repository.InterviewerRepository;

@Service
public class InterviewerService {
	@Autowired
	private InterviewerRepository interviewerRespository;

	public List<Interviewer> insertInBatch(List<Interviewer> list) {
		return interviewerRespository.saveAll(list);
	}

	public boolean findById(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
}
