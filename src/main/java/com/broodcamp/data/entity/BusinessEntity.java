package com.broodcamp.data.entity;

import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonView;
import com.terawarehouse.data.view.catalog.CategoryView;

import io.swagger.annotations.ApiModel;
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
@ApiModel
public abstract class BusinessEntity extends EnableEntity {

	private static final long serialVersionUID = 6694541298135798276L;

	@JsonView(CategoryView.Public.class)
	@NotEmpty(message = "{businessEntity.notEmpty}")
	@Size(min = 3, max = 50)
	private String code;

	@JsonView(CategoryView.Public.class)
	private String description;

}
