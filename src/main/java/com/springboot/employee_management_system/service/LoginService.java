package com.springboot.employee_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.springboot.employee_management_system.exception.InvalidUsernameException;
import com.springboot.employee_management_system.model.Login;
import com.springboot.employee_management_system.repository.LoginRepository;

@Service
public class LoginService {
	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private BCryptPasswordEncoder passEncoder;

	public List<Login> insertInBatch(List<Login> list) {
		return loginRepository.saveAll(list);
	}

	public Login signup(Login login) throws InvalidUsernameException {
		Optional<Login> optional = loginRepository.findByUsername(login.getUsername());
		if (optional.isPresent()) {
			throw new InvalidUsernameException("username already exists");
		}

		// password encryption
		String encryptedPass = passEncoder.encode(login.getPassword());
		login.setPassword(encryptedPass);

		return loginRepository.save(login);
	}

	public Login findByUsername(String username) {
		return loginRepository.findByUsername(username).get();
	}
}
