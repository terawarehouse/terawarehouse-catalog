package com.broodcamp.data.entity;

import javax.persistence.MappedSuperclass;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Edward P. Legaspi
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
@ApiModel
public abstract class EnableEntity extends AuditableEntity {

	private static final long serialVersionUID = -7084847683632507391L;

	private boolean disabled;
	
}
