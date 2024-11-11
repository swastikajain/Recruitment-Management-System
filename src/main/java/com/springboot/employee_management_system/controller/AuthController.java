package com.springboot.employee_management_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.employee_management_system.dto.ResponseMessageDto;
import com.springboot.employee_management_system.exception.InvalidUsernameException;
import com.springboot.employee_management_system.model.Login;
import com.springboot.employee_management_system.service.LoginService;

@RestController
public class AuthController {
	@Autowired
	private LoginService loginService;

	@PostMapping("/auth/signup")
	public ResponseEntity<?> signup(@RequestBody Login login, ResponseMessageDto dto) {
		try {
			return ResponseEntity.ok(loginService.signup(login));
		} catch (InvalidUsernameException e) {
			dto.setMsg(e.getMessage());
			return ResponseEntity.badRequest().body(dto);
		}

	}
}
