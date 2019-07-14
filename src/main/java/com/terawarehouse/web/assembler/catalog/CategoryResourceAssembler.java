package com.terawarehouse.web.assembler.catalog;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceAssembler;
import org.springframework.stereotype.Component;

import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.web.application.catalog.CategoryController;

/**
 * @author Edward P. Legaspi
 */
@Component
public class CategoryResourceAssembler implements ResourceAssembler<Category, Resource<Category>> {

	@Override
	public Resource<Category> toResource(Category entity) {
		return new Resource<>(entity, //
				linkTo(methodOn(CategoryController.class).one(entity.getEntityId())).withSelfRel(), //
				linkTo(methodOn(CategoryController.class).all()).withRel("categories"), //
				linkTo(methodOn(CategoryController.class).oneCode(entity.getCode())).withRel("oneCode"));
	}

}
