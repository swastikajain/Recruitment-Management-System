package com.springboot.employee_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.employee_management_system.model.Job;

public interface JobRepository extends JpaRepository<Job, Integer> {

	@Query("SELECT j FROM Job j " + "JOIN j.hr hr " + "WHERE j.title = :roleName")
	List<Job> findJobsByRole(@Param("roleName") String roleName);
}