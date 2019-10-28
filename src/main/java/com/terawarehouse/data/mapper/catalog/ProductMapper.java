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
package com.terawarehouse.data.mapper.catalog;

import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import com.broodcamp.data.mapper.GenericMapper;
import com.terawarehouse.business.domain.catalog.ProductDto;
import com.terawarehouse.data.entity.catalog.Product;
import com.terawarehouse.data.repository.catalog.BrandRepository;
import com.terawarehouse.data.repository.catalog.CategoryRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Mapper
public abstract class ProductMapper implements GenericMapper<Product, ProductDto> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Mapping(target = "categoryId", source = "category.id")
    @Mapping(target = "brandId", source = "brand.id")
    public abstract ProductDto toDto(Product source);

    @AfterMapping
    public void afterMapping(ProductDto source, @MappingTarget Product target) {

        if (source.getCategoryId() != null) {
            categoryRepository.findById(source.getCategoryId()).ifPresent(target::setCategory);
        }

        if (source.getBrandId() != null) {
            brandRepository.findById(source.getBrandId()).ifPresent(target::setBrand);
        }
    }
}
