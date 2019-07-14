package com.broodcamp.data.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi
 */
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
@ToString(callSuper = true)
public abstract class BusinessEntity extends EnableEntity {

	private static final long serialVersionUID = 6694541298135798276L;

	@NotNull
	private String code;
	private String description;

}
