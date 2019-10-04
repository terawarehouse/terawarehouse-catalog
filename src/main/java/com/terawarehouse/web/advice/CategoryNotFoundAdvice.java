package com.terawarehouse.web.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import com.broodcamp.business.exception.ExceptionResponse;
import com.terawarehouse.business.exception.CategoryNotFoundException;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@RestControllerAdvice
public class CategoryNotFoundAdvice {

	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(value = HttpStatus.NOT_FOUND)
	public ExceptionResponse categoryNotFoundHandler(CategoryNotFoundException ex, WebRequest request) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage(), request.getDescription(false));
		return exceptionResponse;
	}
}