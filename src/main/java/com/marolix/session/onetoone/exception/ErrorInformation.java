package com.marolix.session.onetoone.exception;

import java.time.LocalDateTime;

public class ErrorInformation {
	private String errorMessage;
	private String errorCode;
	private LocalDateTime errorOccuredAt;

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public LocalDateTime getErrorOccuredAt() {
		return errorOccuredAt;
	}

	public void setErrorOccuredAt(LocalDateTime errorOccuredAt) {
		this.errorOccuredAt = errorOccuredAt;
	}

}
