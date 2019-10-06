/**
 * (C) Copyright 2019 Edward P. Legaspi (https://github.com/czetsuya).
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.terawarehouse.web.assembler.catalog;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.broodcamp.web.application.AbstractBaseController;
import com.broodcamp.web.assembler.AbstractResourceAssembler;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.web.application.catalog.CategoryController;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Component
public class CategoryResourceAssembler extends AbstractResourceAssembler<Category> implements RepresentationModelAssembler<Category, EntityModel<Category>> {

	@Override
	public EntityModel<Category> toModel(Category entity) {
		return new EntityModel<>(entity, //
				linkTo(methodOn(CategoryController.class).findById(entity.getId())).withSelfRel(), //
				linkTo(methodOn(CategoryController.class).findAll(AbstractBaseController.DEFAULT_PAGE_SIZE, 0)).withRel("categories"),
				linkTo(methodOn(CategoryController.class).findByCode(entity.getCode())).withRel("code"));
	}

}
