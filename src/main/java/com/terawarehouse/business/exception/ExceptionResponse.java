package com.terawarehouse.business.exception;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi
 */
@JsonInclude(Include.NON_NULL)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {

	private Date timestamp;
	private String message;
	private String details;
	private List<String> errors;

	public ExceptionResponse(Date timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

	public ExceptionResponse(final String message, final String error) {
		super();
		this.timestamp = new Date();
		this.message = message;
		errors = Arrays.asList(error);
	}

	public ExceptionResponse(final String message, final List<String> errors) {
		super();
		this.timestamp = new Date();
		this.message = message;
		this.errors = errors;
	}

}
