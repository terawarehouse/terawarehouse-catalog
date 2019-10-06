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
package com.terawarehouse.web.application.catalog;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.validation.Validator;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.web.application.AbstractBusinessController;
import com.broodcamp.web.application.IController;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.web.assembler.catalog.CategoryResourceAssembler;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CategoryController extends AbstractBusinessController<Category, UUID> implements IController<Category> {

    @Autowired
    public CategoryController(@Qualifier("validator") Validator validator, CategoryResourceAssembler categoryResourceAssembler, CategoryRepository categoryRepository,
            MessageSource messageSource) {

        super(categoryRepository, categoryResourceAssembler, validator, IController.class);
    }

    public int sum1(int a, int b) {
        return a + b;
    }

    public int sum2(int a, int b) {
        return a + b;
    }

//	@PostMapping
//	@ApiOperation(value = "Create new entity" //
//			, notes = "Creates new entity. Returns the created entity with uid.")
//	public ResponseEntity<Resource<Category>> create(@RequestBody @Valid Category entity) throws URISyntaxException {
//
//		Resource<Category> resource = resourceAssembler.toResource(categoryRepository.save(entity));
//		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
//	}

//	@ApiOperation(value = "Get entity by uid" //
//			, notes = "Returns entity for uid specified.")
//	@ApiResponses(value = { @ApiResponse(code = 404, message = "Entity not found") })
//	@GetMapping(path = "/{uid}")
//	public EntityModel<Category> findById(@PathVariable /* @ApiParam(value = "entity identifier", required = true) */ UUID uid) {
//
//		Category entity = categoryRepository.findById(uid).orElseThrow(() -> createNewNotFoundException(uid));
//
//		return categoryResourceAssembler.toModel(entity);
//	}

}
