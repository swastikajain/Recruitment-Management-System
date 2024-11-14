package com.springboot.employee_management_system.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.employee_management_system.model.Application;

public interface ApplicationRepository extends JpaRepository<Application, Integer> {

}
