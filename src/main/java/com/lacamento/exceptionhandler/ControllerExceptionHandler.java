package com.lacamento.exceptionhandler;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler({EmptyResultDataAccessException.class})
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public void handleEmptyResultDataAccessException() {
		
	}
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(
			MethodArgumentNotValidException ex,
			HttpHeaders headers,
			HttpStatus status,
			WebRequest request
			) {
		
		List<String> errors = new ArrayList<>();
		
		ex.getBindingResult().getAllErrors().forEach(error -> {errors.add(error.getDefaultMessage());
		});
		
		String defaultMessage = "Campo(s) inválido(s).";
		ApiErrorList error = new ApiErrorList(HttpStatus.BAD_REQUEST.value(), defaultMessage,LocalDate.now(), errors);
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

}
