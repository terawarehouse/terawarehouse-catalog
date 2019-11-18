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

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

import java.util.UUID;

import javax.transaction.NotSupportedException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.sleuth.SpanName;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.business.exception.ResourceFoundException;
import com.broodcamp.web.application.AbstractBusinessController;
import com.terawarehouse.business.domain.catalog.ProductDto;
import com.terawarehouse.business.service.catalog.ProductService;
import com.terawarehouse.data.entity.catalog.Product;
import com.terawarehouse.data.repository.catalog.ProductRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@SpanName("product")
@RestController
@RequestMapping(path = "/catalog/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
@Slf4j
public class ProductController extends AbstractBusinessController<Product, ProductDto, UUID> {

    @Autowired
    private ProductService productService;

    @Override
    @PostMapping
    public ResponseEntity<EntityModel<ProductDto>> create(@RequestBody @NotNull @Valid ProductDto dto) throws NotSupportedException {

        Product entity = genericMapper.toModel(dto);

        if (((ProductRepository) repository).findByCode(dto.getCode()).isPresent()) {
            throw new ResourceFoundException(entityClass, dto.getCode());
        }

        final EntityModel<ProductDto> resource = modelAssembler.toModel(genericMapper.toDto(productService.save(entity)));
        return ResponseEntity.created(linkTo(controllerClass).slash(entity.getId()).withSelfRel().toUri()).body(resource);
    }

    @Override
    @GetMapping(path = "/{uid}")
    public EntityModel<ProductDto> findById(@PathVariable UUID uid) throws NotSupportedException {

        log.debug("GET /catalog/products productId={}", uid);

        return super.findById(uid);
    }
}
