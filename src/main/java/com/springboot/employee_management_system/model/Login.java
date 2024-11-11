package com.springboot.employee_management_system.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Login {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int loginId;

	@Column(nullable = false)
	private String password;

	@Column(nullable = false)
	private String role;

	// Getters and Setters

	public String getPassword() {
		return password;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
