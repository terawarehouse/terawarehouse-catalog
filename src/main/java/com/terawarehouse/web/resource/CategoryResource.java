package com.terawarehouse.web.resource;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.web.application.AbstractController;
import com.terawarehouse.web.application.catalog.CategoryController;

import lombok.ToString;

/**
 * @author Edward P. Legaspi
 */
@ToString
public class CategoryResource extends ResourceSupport {

	public static final String JSON_FILTER = "CategoryFilter";

	private final Category category;

	@JsonCreator
	public CategoryResource(@NotNull final Category entity) {

		this.category = entity;
		this.add(linkTo(methodOn(CategoryController.class).one(entity.getEntityId())).withSelfRel());
		this.add(linkTo(methodOn(CategoryController.class).all(AbstractController.DEFAULT_PAGE_SIZE, 0)).withRel("categories"));
		this.add(linkTo(methodOn(CategoryController.class).oneCode(entity.getCode())).withRel("oneCode"));
	}

	@JsonFilter(JSON_FILTER)
	public Category getCategory() {

		return category;
	}
}
