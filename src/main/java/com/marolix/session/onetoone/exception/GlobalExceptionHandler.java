package com.marolix.session.onetoone.exception;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorInformation> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {

		ErrorInformation er = new ErrorInformation();
		er.setErrorOccuredAt(LocalDateTime.now());
		er.setErrorCode(Integer.valueOf(HttpStatus.BAD_REQUEST.value()).toString());
		String error1 = e.getBindingResult().getAllErrors().stream()
				.map((ObjectError error) -> error.getDefaultMessage()).collect(Collectors.joining(", "));
		er.setErrorMessage(error1);
		return new ResponseEntity<ErrorInformation>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(EmployeeManagementException.class)
	public ResponseEntity<ErrorInformation> handleUserDefinedException(EmployeeManagementException e) {

		ErrorInformation er = new ErrorInformation();
		er.setErrorOccuredAt(LocalDateTime.now());
		er.setErrorCode(Integer.valueOf(HttpStatus.BAD_REQUEST.value()).toString());

		er.setErrorMessage(e.getMessage());
		return new ResponseEntity<ErrorInformation>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorInformation> handleConstraintViolationException(ConstraintViolationException e) {

		ErrorInformation er = new ErrorInformation();
		er.setErrorOccuredAt(LocalDateTime.now());
		er.setErrorCode(Integer.valueOf(HttpStatus.BAD_REQUEST.value()).toString());

		er.setErrorMessage(
				e.getConstraintViolations().stream().map(c -> c.getMessage()).collect(Collectors.joining(" ,")));
		return new ResponseEntity<ErrorInformation>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorInformation> handleMethodArgumentTypeMismatchException(
			MethodArgumentTypeMismatchException e) {

		ErrorInformation er = new ErrorInformation();
		er.setErrorOccuredAt(LocalDateTime.now());
		er.setErrorCode(Integer.valueOf(HttpStatus.BAD_REQUEST.value()).toString());

		er.setErrorMessage(
				"please check the datatype of the provided request params :" + e.getParameter().getParameterName());
		return new ResponseEntity<ErrorInformation>(er, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorInformation> handlegeneralException(Exception e) {

		ErrorInformation er = new ErrorInformation();
		er.setErrorOccuredAt(LocalDateTime.now());
		er.setErrorCode(Integer.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()).toString());

		er.setErrorMessage("some thing went wrong :" + e.getMessage());
		return new ResponseEntity<ErrorInformation>(er, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
