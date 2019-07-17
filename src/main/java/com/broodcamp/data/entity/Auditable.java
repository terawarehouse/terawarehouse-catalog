package com.broodcamp.data.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi
 */
@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel
public class Auditable implements Serializable {

	private static final long serialVersionUID = 6534747210502098594L;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created", nullable = false, updatable = false)
	private Date created;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "updated")
	private Date updated;

	@Column(name = "creator_ref")
	private String creatorRef;

	@Column(name = "updater_ref")
	private String updaterRef;

	public Auditable(String userRef) {
		super();
		this.creatorRef = userRef;
		this.created = new Date();
	}

	public void updateWith(String userRef) {
		this.updated = new Date();
		this.updaterRef = userRef;

		if (this.creatorRef == null) {
			this.creatorRef = userRef;
		}
		if (this.created == null) {
			this.created = this.updated;
		}

	}

}
