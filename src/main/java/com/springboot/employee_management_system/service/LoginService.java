package com.springboot.employee_management_system.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.employee_management_system.model.Login;
import com.springboot.employee_management_system.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;
	
	public List<Login> insertInBatch(List<Login> list){
		return loginRepository.saveAll(list);
	}
}
