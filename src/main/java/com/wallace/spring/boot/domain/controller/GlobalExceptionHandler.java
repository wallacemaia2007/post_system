package com.wallace.spring.boot.domain.controller;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.wallace.spring.boot.domain.dtos.ErrorResponse;
import com.wallace.spring.boot.exceptions.UserNotFoundException;

public class GlobalExceptionHandler {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFoundExceptionn(UserNotFoundException ex, WebRequest web){
		
		ErrorResponse error = new ErrorResponse(LocalDateTime.now(), ex.getMessage(), web.getDescription(false));
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
		
	}

}
