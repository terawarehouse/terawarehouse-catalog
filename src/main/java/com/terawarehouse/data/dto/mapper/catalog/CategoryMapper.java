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
package com.terawarehouse.data.dto.mapper.catalog;

import java.util.Optional;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.broodcamp.data.dto.mapper.GenericMapper;
import com.terawarehouse.data.dto.catalog.CategoryDto;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.repository.catalog.CategoryRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Mapper
public abstract class CategoryMapper implements GenericMapper<Category, CategoryDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Mapping(source = "parentCategory.id", target = "parentId")
    @Override
    public abstract CategoryDto toDto(Category source);

    @AfterMapping
    public void fillParentCategory(CategoryDto source, @MappingTarget Category target) {

        if (source.getParentId() != null) {
            Optional<Category> optParentCategory = categoryRepository.findById(source.getParentId());
            if (optParentCategory.isPresent()) {
                target.setParentCategory(optParentCategory.get());
            }
        }
    }
}
