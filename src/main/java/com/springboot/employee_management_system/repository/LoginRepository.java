package com.springboot.employee_management_system.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employee_management_system.model.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {

	Optional<Login> findByUsername(String username);
}
