package com.springboot.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee_management_system.model.Hr;
import com.springboot.employee_management_system.service.HrService;

@RestController
public class HrController {

	@Autowired
	private HrService hrService;

	@PostMapping("/hr/batch/addhr")
	public List<Hr> addHrBatch(@RequestBody List<Hr> list) {
		return hrService.insertInBatch(list);
	}
}
