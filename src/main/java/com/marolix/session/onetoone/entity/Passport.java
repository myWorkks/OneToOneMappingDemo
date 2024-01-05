package com.marolix.session.onetoone.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "passport_details")
public class Passport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long passportId;
	private String passportNumber;
	private LocalDate dateOfIssue;
	private LocalDate expiryDate;
	public Long getPassportId() {
		return passportId;
	}
	public void setPassportId(Long passportId) {
		this.passportId = passportId;
	}
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	public LocalDate getDateOfIssue() {
		return dateOfIssue;
	}
	public void setDateOfIssue(LocalDate dateOfIssue) {
		this.dateOfIssue = dateOfIssue;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	
}
