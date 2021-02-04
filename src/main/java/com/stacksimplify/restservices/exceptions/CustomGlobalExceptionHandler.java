package com.stacksimplify.restservices.exceptions;

import java.util.Date;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

//@ControllerAdvice
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"From MethodArgumentNotValid Exception in GEH", ex.getMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(),
				"From HttpRequestMethodNotSupportedException in GEH - Method Not allowed", ex.getMessage());

		return new ResponseEntity<>(customErrorDetails, HttpStatus.METHOD_NOT_ALLOWED);

	}

	@ExceptionHandler(UserNameNotFoundException.class)
	public final ResponseEntity<Object> handleUserNotFound(UserNameNotFoundException ex, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(customErrorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {
		CustomErrorDetails customErrorDetails = new CustomErrorDetails(new Date(), ex.getMessage(),
				request.getDescription(false));
		return new ResponseEntity<Object>(customErrorDetails, HttpStatus.BAD_REQUEST);
	}

}
