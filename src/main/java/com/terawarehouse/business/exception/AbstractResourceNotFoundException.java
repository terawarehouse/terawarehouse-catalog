package com.terawarehouse.business.exception;

import java.util.UUID;

import org.springframework.data.rest.webmvc.ResourceNotFoundException;

/**
 * @author Edward P. Legaspi
 */
public abstract class AbstractResourceNotFoundException extends ResourceNotFoundException {

	private static final long serialVersionUID = -3959094123571588527L;

	public AbstractResourceNotFoundException(String simpleName, UUID uid) {
		super(String.format("Could not find %s with id %s", simpleName, uid));
	}

	public AbstractResourceNotFoundException(String simpleName, String code) {
		super(String.format("Could not find %s with code %s", simpleName, code));
	}

}
