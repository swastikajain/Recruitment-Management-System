package com.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employee_management_system.model.Hr;
import com.springboot.employee_management_system.repository.HrRepository;

@Service
public class HrService {
	@Autowired
	private HrRepository hrRepository;

	public List<Hr> insertInBatch(List<Hr> list) {
		return hrRepository.saveAll(list);
	}
}
