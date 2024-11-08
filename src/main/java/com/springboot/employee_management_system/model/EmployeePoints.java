package com.springboot.employee_management_system.model;

import jakarta.persistence.*;

@Entity
public class EmployeePoints {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int pointsId;

	@Column(nullable = false)
	private double totalPointsEarned;

	@Column(nullable = false)
	private double totalPointsRedeemed;

	@Column(nullable = false)
	private double balancePoints;

	@Column(nullable = false)
	private String lastUpdated;

	@ManyToOne
	@JoinColumn(name = "Manager_id", nullable = false)
	private Manager manager;

	public int getPointsId() {
		return pointsId;
	}

	public void setPointsId(int pointsId) {
		this.pointsId = pointsId;
	}

	public double getTotalPointsEarned() {
		return totalPointsEarned;
	}

	public void setTotalPointsEarned(double totalPointsEarned) {
		this.totalPointsEarned = totalPointsEarned;
	}

	public double getTotalPointsRedeemed() {
		return totalPointsRedeemed;
	}

	public void setTotalPointsRedeemed(double totalPointsRedeemed) {
		this.totalPointsRedeemed = totalPointsRedeemed;
	}

	public double getBalancePoints() {
		return balancePoints;
	}

	public void setBalancePoints(double balancePoints) {
		this.balancePoints = balancePoints;
	}

	public String getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(String lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

}
