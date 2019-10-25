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

import javax.transaction.NotSupportedException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.web.application.AbstractBusinessController;
import com.terawarehouse.business.domain.catalog.ProductDto;
import com.terawarehouse.data.entity.catalog.Product;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(path = "/catalog/categories/{cid}/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ProductController extends AbstractBusinessController<Product, ProductDto, UUID> {

    @Override
    @PostMapping
    public ResponseEntity<EntityModel<ProductDto>> create(@RequestBody @NotNull @Valid ProductDto dto) throws NotSupportedException {
        
        throw new NotSupportedException();
    }

    @PostMapping(path = "/create")
    public ResponseEntity<EntityModel<ProductDto>> create(@PathVariable @NotNull UUID cid, @RequestBody @Valid ProductDto dto) throws NotSupportedException {

        dto.setCategoryId(cid);

        return super.create(dto);
    }
}