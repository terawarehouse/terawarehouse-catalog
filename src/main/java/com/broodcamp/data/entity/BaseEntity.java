package com.broodcamp.data.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Edward P. Legaspi
 */
@Data
@NoArgsConstructor
@MappedSuperclass
@JsonIgnoreProperties(ignoreUnknown = true)
@ApiModel
public abstract class BaseEntity implements Serializable, IEntity {

	private static final long serialVersionUID = 3986494663579679129L;

	public static final int NB_PRECISION = 23;
	public static final int NB_DECIMALS = 12;

	@Id
	@GeneratedValue
	@Column(columnDefinition = "uuid", updatable = false)
	private UUID id;

	/**
	 * The entity.id. Unfortunately, the field "id" is already reserved/use by
	 * Spring Data JPA.
	 * 
	 * @return entity.id
	 */
	public UUID getEntityId() {
		return id;
	}

	@Override
	public boolean isTransient() {
		return id == null;
	}

	@Override
	public String toString() {
		return "BaseEntity [entityId=" + id + "]";
	}

}
