package com.springboot.employee_management_system.service;

import java.util.List;
import java.util.Optional;

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

	public boolean validate(Integer id) {
		Optional<Interviewer> optional = interviewerRespository.findById(id);
		if (optional.isEmpty())
			return false;
		return true;
	}

	public List<Interviewer> getAllInterviewer() {
		return interviewerRespository.findAll();
	}
}
