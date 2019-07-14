package com.terawarehouse.web.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.terawarehouse.business.exception.CategoryNotFoundException;

/**
 * @author Edward P. Legaspi
 */
@RestControllerAdvice
public class CategoryNotFoundAdvice {

	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	String categoryNotFoundHandler(CategoryNotFoundException ex) {
		return ex.getMessage();
	}
}
