package com.springboot.employee_management_system.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springboot.employee_management_system.model.InterviewSchedular;
import com.springboot.employee_management_system.model.Interviewer;

public interface InterviewSchedularRepository extends JpaRepository<InterviewSchedular, Integer> {

	@Query("SELECT DISTINCT i.interviewer FROM InterviewSchedular i WHERE i.interviewDate = :date")
	List<Interviewer> findInterviewersByScheduleDate(@Param("date") String date);

}
