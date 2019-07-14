package com.terawarehouse.business.exception;

import java.util.UUID;

/**
 * @author Edward P. Legaspi
 */
public class CategoryNotFoundException extends EntityNotFoundException {

	private static final long serialVersionUID = -2577283996806163977L;

	public CategoryNotFoundException(UUID id) {
		super(CategoryNotFoundException.class.getSimpleName(), id);
	}

	public CategoryNotFoundException(String code) {
		super(CategoryNotFoundException.class.getSimpleName(), code);
	}
}
