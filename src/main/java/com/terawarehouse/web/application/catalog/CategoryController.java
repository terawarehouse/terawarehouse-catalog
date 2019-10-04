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

import com.broodcamp.web.application.BusinessController;
import com.broodcamp.web.application.IController;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.web.assembler.catalog.CategoryResourceAssembler;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@RestController
@RequestMapping(path = "/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CategoryController extends BusinessController<Category, UUID> implements IController<Category> {

	private CategoryRepository categoryRepository;
	private CategoryResourceAssembler categoryResourceAssembler;

	@Autowired
	public CategoryController(@Qualifier("validator") Validator validator, CategoryResourceAssembler categoryResourceAssembler, CategoryRepository categoryRepository,
			MessageSource messageSource) {

		super(categoryRepository, categoryResourceAssembler, validator, IController.class);
		this.categoryRepository = categoryRepository;
		this.categoryResourceAssembler = categoryResourceAssembler;
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
