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
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.transaction.NotSupportedException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.business.exception.ResourceNotFoundException;
import com.broodcamp.web.application.AbstractBusinessController;
import com.broodcamp.web.application.AbstractController;
import com.terawarehouse.business.domain.catalog.ProductDto;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.entity.catalog.Product;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.data.repository.catalog.ProductRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(path = "/catalog/categories/{cid}/products", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class ProductController extends AbstractBusinessController<Product, ProductDto, UUID> {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

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

    @GetMapping(path = "/")
    public CollectionModel<EntityModel<ProductDto>> findAll(@Valid @NotNull @PathVariable UUID parentId, @RequestParam(required = false) Integer size,
            @RequestParam(required = false) Integer page) {

        if (size == null) {
            size = AbstractController.DEFAULT_PAGE_SIZE;
        }
        if (page == null) {
            page = 0;
        }

        Pageable pageable = PageRequest.of(page, size);

        Category category = categoryRepository.findById(parentId).orElseThrow(() -> new ResourceNotFoundException(Category.class.getSimpleName(), parentId));

        List<EntityModel<ProductDto>> entities = productRepository.findByCategory(category, pageable).stream().map(e -> modelAssembler.toModel(genericMapper.toDto(e)))
                .collect(Collectors.toList());

        return new CollectionModel<>(entities, linkTo(methodOn(ProductController.class).findAll(parentId, size, page)).withSelfRel());
    }
}
