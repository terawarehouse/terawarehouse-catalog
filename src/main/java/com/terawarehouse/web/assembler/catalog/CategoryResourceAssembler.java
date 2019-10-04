package com.terawarehouse.web.assembler.catalog;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.broodcamp.web.application.BaseController;
import com.broodcamp.web.assembler.AbstractResourceAssembler;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.web.application.catalog.CategoryController;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@Component
public class CategoryResourceAssembler extends AbstractResourceAssembler<Category> implements RepresentationModelAssembler<Category, EntityModel<Category>> {

	@Override
	public EntityModel<Category> toModel(Category entity) {
		return new EntityModel<>(entity, //
				linkTo(methodOn(CategoryController.class).findById(entity.getId())).withSelfRel(), //
				linkTo(methodOn(CategoryController.class).findAll(BaseController.DEFAULT_PAGE_SIZE, 0)).withRel("categories"),
				linkTo(methodOn(CategoryController.class).findByCode(entity.getCode())).withRel("code"));
	}

}
