package com.marolix.session.onetoone.dto;

import java.time.LocalDate;

public class PassportDTO {
private Long passportId;
private String passportNumber;
private LocalDate pasprtIssueDate;
private LocalDate passportExpiryDate;
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

}
