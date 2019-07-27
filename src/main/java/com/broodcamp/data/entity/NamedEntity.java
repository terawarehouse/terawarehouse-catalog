package com.broodcamp.data.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author Edward P. Legaspi
 */
@Data
@EqualsAndHashCode(callSuper = false)
@MappedSuperclass
public class NamedEntity extends EnableEntity {

	private static final long serialVersionUID = -279038813396705269L;

	@Column(name = "NAME", nullable = false, length = 250)
	@Size(max = 250)
	protected String name;
}
