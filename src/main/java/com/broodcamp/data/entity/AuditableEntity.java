package com.broodcamp.data.entity;

import javax.persistence.Embedded;
import javax.persistence.MappedSuperclass;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public abstract class AuditableEntity extends BaseEntity {

	private static final long serialVersionUID = 2522072952461930125L;

	@Embedded
	private Auditable auditable;

	public void updateAudit(String userRef) {
		if (auditable == null) {
			auditable = new Auditable(userRef);
		} else {
			auditable.updateWith(userRef);
		}
	}

}
