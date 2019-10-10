/**
 * An Open Source Inventory and Sales Management System
 * Copyright (C) 2019 Edward P. Legaspi (https://github.com/czetsuya)
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */
package com.terawarehouse.web.resource;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import javax.validation.constraints.NotNull;

import org.springframework.hateoas.RepresentationModel;

import com.broodcamp.web.application.AbstractBaseController;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFilter;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.web.application.catalog.CategoryController;

import lombok.ToString;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@ToString
public class CategoryResource extends RepresentationModel {

    public static final String JSON_FILTER = "CategoryFilter";

    private final Category category;

    @JsonCreator
    public CategoryResource(@NotNull final Category entity) {

        this.category = entity;
        this.add(linkTo(methodOn(CategoryController.class).findById(entity.getId())).withSelfRel());
        this.add(linkTo(methodOn(CategoryController.class).findAll(AbstractBaseController.DEFAULT_PAGE_SIZE, 0)).withRel("categories"));
        this.add(linkTo(methodOn(CategoryController.class).findByCode(entity.getCode())).withRel("findByCode"));
    }

    @JsonFilter(JSON_FILTER)
    public Category getCategory() {

        return category;
    }
}
