package com.terawarehouse.business.exception;

import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.terawarehouse.data.entity.catalog.Category;

/**
 * @author Edward P. Legaspi
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class CategoryNotFoundException extends AbstractResourceNotFoundException {

	private static final long serialVersionUID = -2577283996806163977L;

	public CategoryNotFoundException(UUID uid) {
		super(Category.class.getSimpleName(), uid);
	}

	public CategoryNotFoundException(String code) {
		super(Category.class.getSimpleName(), code);
	}
}
