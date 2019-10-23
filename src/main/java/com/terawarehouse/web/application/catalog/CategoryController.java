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
package com.terawarehouse.web.application.catalog;

import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.data.dto.mapper.GenericMapper;
import com.broodcamp.data.dto.mapper.GenericMapperService;
import com.broodcamp.util.StringUtils;
import com.broodcamp.web.application.AbstractBusinessController;
import com.broodcamp.web.application.IController;
import com.terawarehouse.data.dto.catalog.CategoryDto;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.web.assembler.catalog.CategoryResourceAssembler;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CategoryController extends AbstractBusinessController<Category, CategoryDto, UUID> implements IController<Category> {

    private GenericMapperService<Category, CategoryDto> genericMapperService;

    @Autowired
    public CategoryController(@Qualifier("validator") Validator validator, CategoryResourceAssembler categoryResourceAssembler, CategoryRepository categoryRepository,
            MessageSource messageSource, GenericMapperService<Category, CategoryDto> genericMapperService) {

        super(categoryRepository, categoryResourceAssembler, validator, IController.class);
        this.genericMapperService = genericMapperService;
    }

    @Override
    public GenericMapper<Category, CategoryDto> getGenericMapper() {
        return genericMapperService.getMapper(Category.class, CategoryDto.class);
    }

    @PostMapping(path = "/{pcid}")
    public ResponseEntity<EntityModel<Category>> create(@PathVariable @NotNull UUID pcid, @RequestBody @Valid CategoryDto dto) {

        if (!StringUtils.isBlank(pcid)) {
            dto.setParentId(pcid);
        }

        return super.create(dto);
    }

}