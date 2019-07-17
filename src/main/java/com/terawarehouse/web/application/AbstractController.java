package com.terawarehouse.web.application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

/**
 * @author Edward P. Legaspi
 */
public abstract class AbstractController {

	public static final int DEFAULT_PAGE_SIZE = 10;

	@Autowired
	@Qualifier("validator")
	private Validator validator;

	@InitBinder
	protected void initBinder(WebDataBinder binder) {
		binder.setValidator(validator);
	}
}
