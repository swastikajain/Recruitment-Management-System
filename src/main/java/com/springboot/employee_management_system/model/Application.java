package com.springboot.employee_management_system.model;

import jakarta.persistence.*;

@Entity
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String applicationStatus;

	@Column(nullable = false)
	private String dateApplied;

	@Column(nullable = false)
	private String coverLetter;

	@ManyToOne
	@JoinColumn(name = "Job_idJob", nullable = false)
	private Job job;

	@ManyToOne
	@JoinColumn(name = "JobSeeker_id", nullable = false)
	private JobSeeker jobSeeker;

	@ManyToOne
	@JoinColumn(name = "Interview_id", nullable = false)
	private InterviewSchedular interviewSchedular;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(String applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public String getDateApplied() {
		return dateApplied;
	}

	public void setDateApplied(String dateApplied) {
		this.dateApplied = dateApplied;
	}

	public String getCoverLetter() {
		return coverLetter;
	}

	public void setCoverLetter(String coverLetter) {
		this.coverLetter = coverLetter;
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

	public JobSeeker getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(JobSeeker jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public InterviewSchedular getInterviewSchedular() {
		return interviewSchedular;
	}

	public void setInterviewSchedular(InterviewSchedular interviewSchedular) {
		this.interviewSchedular = interviewSchedular;
	}

}
