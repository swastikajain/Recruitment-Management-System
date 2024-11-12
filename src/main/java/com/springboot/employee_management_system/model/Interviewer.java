package com.springboot.employee_management_system.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Interviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false)
	private String contact;

	@Column(nullable = false)
	private String emailId;

	@Column(nullable = false)
	private String interviewSpeciality;

	@Column(nullable = false)
	private String position;

	@OneToOne
	@JoinColumn(name = "loginId", nullable = false)
	private Login login;

	@OneToMany(mappedBy = "interviewer")
	private List<InterviewSchedular> interviewSchedulars;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getInterviewSpeciality() {
		return interviewSpeciality;
	}

	public void setInterviewSpeciality(String interviewSpeciality) {
		this.interviewSpeciality = interviewSpeciality;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Login getLogin() {
		return login;
	}

	public void setLogin(Login login) {
		this.login = login;
	}

	public List<InterviewSchedular> getInterviewSchedulars() {
		return interviewSchedulars;
	}

	public void setInterviewSchedulars(List<InterviewSchedular> interviewSchedulars) {
		this.interviewSchedulars = interviewSchedulars;
	}

}
