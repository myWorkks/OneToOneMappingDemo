package com.marolix.session.onetoone.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public class PassportDTO {
	private Long passportId;
	@NotNull
	@Pattern(regexp = "[A-Z][1-9][0-9][A-Z]{7}")
	private String passportNumber;
	private LocalDate pasprtIssueDate;
	private LocalDate passportExpiryDate;
	private MultipartFile passprtImage;

	public PassportDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

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

	public LocalDate getPasprtIssueDate() {
		return pasprtIssueDate;
	}

	public void setPasprtIssueDate(LocalDate pasprtIssueDate) {
		this.pasprtIssueDate = pasprtIssueDate;
	}

	public LocalDate getPassportExpiryDate() {
		return passportExpiryDate;
	}

	public void setPassportExpiryDate(LocalDate passportExpiryDate) {
		this.passportExpiryDate = passportExpiryDate;
	}

	public MultipartFile getPassprtImage() {
		return passprtImage;
	}

	public void setPassprtImage(MultipartFile passprtImage) {
		this.passprtImage = passprtImage;
	}

	@Override
	public String toString() {
		return "PassportDTO [passportId=" + passportId + ", passportNumber=" + passportNumber + ", pasprtIssueDate="
				+ pasprtIssueDate + ", passportExpiryDate=" + passportExpiryDate + ", passprtImage=" + passprtImage
				+ "]";
	}

}
