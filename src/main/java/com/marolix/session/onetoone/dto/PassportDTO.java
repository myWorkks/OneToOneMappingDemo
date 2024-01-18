package com.marolix.session.onetoone.dto;

import java.time.LocalDate;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

public class PassportDTO {
	private Long passportId;
	@NotNull(message = "please provide passprt number")
	@Pattern(regexp = "[A-Z][1-9][0-9][A-Z]{6}", message = "please provide valid passport number")
	private String passportNumber;
	@Past(message = "please provide a past date")
	private LocalDate pasprtIssueDate;
	@Future(message="{PassportExpiryDate_Invalid}")
	private LocalDate passportExpiryDate;
	@NotNull(message="please provide image")
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
