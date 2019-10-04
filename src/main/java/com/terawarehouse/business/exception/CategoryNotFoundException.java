package com.terawarehouse.business.exception;

import java.io.Serializable;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.broodcamp.business.exception.ResourceNotFoundException;
import com.terawarehouse.data.entity.catalog.Category;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = -2577283996806163977L;

	public CategoryNotFoundException(Serializable uid) {
		super(Category.class.getSimpleName(), uid);
	}
}
