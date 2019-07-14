package com.terawarehouse.web.application.catalog;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.terawarehouse.business.exception.CategoryNotFoundException;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.web.assembler.catalog.CategoryResourceAssembler;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;

/**
 * @author Edward P. Legaspi
 */
@RestController
@RequestMapping(path = "/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Manage Category object", tags = { "catalog" }, produces = MediaType.APPLICATION_JSON_VALUE)
public class CategoryController {

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private CategoryResourceAssembler categoryResourceAssembler;

	@GetMapping("/hello")
	@ApiOperation(value = "Returns a localized hello word")
	public String helloWorld() {
		return messageSource.getMessage("hello", null, LocaleContextHolder.getLocale());
	}

	@ApiModelProperty(notes = "Get all categories")
	@ApiResponse(message = "Returns all the categories", code = 200)
	@GetMapping
	public Resources<Resource<Category>> all() {

		List<Resource<Category>> entities = categoryRepository.findAll().stream().map(categoryResourceAssembler::toResource).collect(Collectors.toList());

		return new Resources<>(entities, linkTo(methodOn(CategoryController.class).all()).withSelfRel());
	}

	@ApiModelProperty(notes = "Get a category with a given id")
	@GetMapping(path = "/{id}")
	public Resource<Category> one(@PathVariable UUID id) {

		Category entity = categoryRepository.findById(id).orElseThrow(() -> new CategoryNotFoundException(id));

		return categoryResourceAssembler.toResource(entity);
	}

	@ApiModelProperty(notes = "Get a category with a given code")
	@GetMapping(path = "/code/{code}")
	public Resource<Category> oneCode(@PathVariable String code) {

		Category entity = categoryRepository.findByCode(code).orElseThrow(() -> new CategoryNotFoundException(code));

		return categoryResourceAssembler.toResource(entity);
	}

	@ApiModelProperty(notes = "Create a new category")
	@PostMapping
	public ResponseEntity<Resource<Category>> newCategory(@Valid @RequestBody Category entity) throws URISyntaxException {

		Resource<Category> resource = categoryResourceAssembler.toResource(categoryRepository.save(entity));
		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	@ApiModelProperty(notes = "Update an category")
	@PutMapping(path = "/{id}")
	public ResponseEntity<?> replaceCategory(@Valid @RequestBody Category newCategory, @PathVariable UUID id) throws URISyntaxException {

		categoryRepository.findById(id).map(category -> {
			category.setDescription(newCategory.getDescription());
			return categoryRepository.save(category);

		}).orElseGet(() -> {
			newCategory.setId(id);
			return categoryRepository.save(newCategory);
		});

		return ResponseEntity.noContent().build();
	}

	@ApiModelProperty(notes = "Delete category with a given id")
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable UUID id) {

		categoryRepository.deleteById(id);

		return ResponseEntity.noContent().build();
	}

}
