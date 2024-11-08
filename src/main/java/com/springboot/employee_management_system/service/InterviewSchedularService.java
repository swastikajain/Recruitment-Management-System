package com.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employee_management_system.model.InterviewSchedular;
import com.springboot.employee_management_system.repository.InterviewSchedularRepository;

@Service
public class InterviewSchedularService {
	@Autowired
	private InterviewSchedularRepository interviewSchedularRepository;

	public List<InterviewSchedular> insertInBatch(List<InterviewSchedular> list) {
		return interviewSchedularRepository.saveAll(list);
	}
}
