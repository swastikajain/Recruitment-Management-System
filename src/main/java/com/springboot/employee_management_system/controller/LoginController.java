package com.springboot.employee_management_system.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee_management_system.model.Login;
import com.springboot.employee_management_system.service.LoginService;

@RestController
public class LoginController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/login/batch/addlogin")
	public List<Login> addLoginBatch(@RequestBody List<Login> list) {
		return loginService.insertInBatch(list);
	}
}
