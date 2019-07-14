package com.terawarehouse.business.exception;

import java.util.UUID;

/**
 * @author Edward P. Legaspi
 */
public abstract class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 4095322113122922316L;

	public EntityNotFoundException(String className, UUID id) {
		super("Could not find " + className + " with id " + id);
	}

	public EntityNotFoundException(String className, String code) {
		super("Could not find " + className + " with code " + code);
	}

}
