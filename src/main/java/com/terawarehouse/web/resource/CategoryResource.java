package com.terawarehouse.web.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.web.application.catalog.CategoryController;

import lombok.ToString;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@ToString
public class CategoryResource extends RepresentationModel {

	public static final String JSON_FILTER = "CategoryFilter";

	private final Category category;

	@JsonCreator
	public CategoryResource(@NotNull final Category entity) {

		this.category = entity;
		this.add(linkTo(methodOn(CategoryController.class).findById(entity.getId())).withSelfRel());
//		this.add(linkTo(methodOn(CategoryController.class).findAll(AbstractController.DEFAULT_PAGE_SIZE, 0)).withRel("categories"));
//		this.add(linkTo(methodOn(CategoryController.class).findByCode(entity.getCode())).withRel("findByCode"));
	}

	@JsonFilter(JSON_FILTER)
	public Category getCategory() {

		return category;
	}
}
