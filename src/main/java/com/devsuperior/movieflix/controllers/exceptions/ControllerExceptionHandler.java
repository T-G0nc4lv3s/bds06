package com.devsuperior.movieflix.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.devsuperior.movieflix.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {

		StandardError err = new StandardError();
		HttpStatus status = HttpStatus.NOT_FOUND;

		err.setTimestamp(Instant.now());
		err.setStatus(status.value());
		err.setMessage(e.getMessage());
		err.setError("Resource not found");
		err.setPath(request.getRequestURI());
		return ResponseEntity.status(status).body(err);

	}
}
