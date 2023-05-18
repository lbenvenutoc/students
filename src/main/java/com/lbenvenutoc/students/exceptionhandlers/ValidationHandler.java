package com.lbenvenutoc.students.exceptionhandlers;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;

@ControllerAdvice
public class ValidationHandler {

	@ExceptionHandler(WebExchangeBindException.class)
	public ResponseEntity<List<String>> handleBeanValidationException(WebExchangeBindException exception) {
		var errors = exception.getBindingResult().getAllErrors().stream()
				.map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
		return ResponseEntity.badRequest().body(errors);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<List<String>> handleCheckedStudentException(Exception exception) {
		var errors = Arrays.asList(exception.getMessage());
		return ResponseEntity.badRequest().body(errors);
	}

}
