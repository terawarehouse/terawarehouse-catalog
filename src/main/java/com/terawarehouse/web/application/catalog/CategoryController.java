package com.terawarehouse.web.application.catalog;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import javax.validation.Valid;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.Resources;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.data.entity.Auditable;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.terawarehouse.business.exception.CategoryNotFoundException;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.data.view.catalog.CategoryView;
import com.terawarehouse.web.application.AbstractController;
import com.terawarehouse.web.assembler.catalog.CategoryResourceAssembler;
import com.terawarehouse.web.resource.CategoryResource;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Edward P. Legaspi
 */
@RestController
@RequestMapping(path = "/v1/categories", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class CategoryController extends AbstractController {

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

	@GetMapping
	@ApiOperation(value = "Get all categories" //
			, notes = "Returns first N categories specified by the size parameter with page offset specified by page parameter." //
			, response = Category.class)
	public Resources<Resource<Category>> all(
			@ApiParam(value = "The size of the page to be returned", defaultValue = "" + DEFAULT_PAGE_SIZE) @RequestParam(required = false) Integer size //
			, @ApiParam(value = "Zero-based page index", defaultValue = "0") @RequestParam(required = false) Integer page) {

		if (size == null) {
			size = DEFAULT_PAGE_SIZE;
		}
		if (page == null) {
			page = 0;
		}

		Pageable pageable = PageRequest.of(page, size);

		List<Resource<Category>> entities = categoryRepository.findAll(pageable).stream().map(categoryResourceAssembler::toResource).collect(Collectors.toList());

		return new Resources<>(entities, linkTo(methodOn(CategoryController.class).all(size, page)).withSelfRel());
	}

	@GetMapping(path = "/{uid}")
	@ApiOperation(value = "Get category by uid" //
			, notes = "Returns category for uid specified." //
			, response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Category not found") })
	public Resource<Category> one(@PathVariable @ApiParam(value = "entity identifier", required = true) UUID uid) {

		Category entity = categoryRepository.findById(uid).orElseThrow(() -> new CategoryNotFoundException(uid));

		return categoryResourceAssembler.toResource(entity);
	}

	@GetMapping(path = "/code/{code}")
	@ApiOperation(value = "Get category by code" //
			, notes = "Returns category for code specified." //
			, response = Category.class)
	@ApiResponses(value = { @ApiResponse(code = 404, message = "Category not found") })
	public Resource<Category> oneCode(@PathVariable @Size(min = 3, max = 50) @ApiParam(value = "entity code", required = true) String code) {

		Category entity = categoryRepository.findByCode(code).orElseThrow(() -> new CategoryNotFoundException(code));

		return categoryResourceAssembler.toResource(entity);
	}

	@PostMapping
	@ApiOperation(value = "Create new category" //
			, notes = "Creates new category. Returns the created category with uid." //
			, response = Category.class)
	public ResponseEntity<Resource<Category>> newCategory(@RequestBody @Valid Category entity) throws URISyntaxException {

		Resource<Category> resource = categoryResourceAssembler.toResource(categoryRepository.save(entity));
		return ResponseEntity.created(new URI(resource.getId().expand().getHref())).body(resource);
	}

	@PutMapping(path = "/{uid}")
	@ApiOperation(value = "Update new category" //
			, notes = "Updates new category. Returns the updated category." //
			, response = Category.class)
	public ResponseEntity<?> replaceCategory(@RequestBody Category newCategory, @PathVariable @ApiParam(value = "entity uid", required = true) UUID uid) throws URISyntaxException {

		Category updatedEntity = categoryRepository.findById(uid).map(category -> {
			category.setDescription(newCategory.getDescription());
			return categoryRepository.save(category);

		}).orElseGet(() -> {
			newCategory.setId(uid);
			return categoryRepository.save(newCategory);
		});

		return ResponseEntity.ok().body(updatedEntity);
	}

	@ApiModelProperty(notes = "Delete category with a given id")
	@DeleteMapping(path = "/{uid}")
	@ApiOperation(value = "Delete category" //
			, notes = "Deletes a category for uid specified. No content is returned.")
	public ResponseEntity<?> deleteCategory(@PathVariable @ApiParam(value = "entity uid", required = true) UUID uid) {

		categoryRepository.deleteById(uid);

		return ResponseEntity.noContent().build();
	}

	@GetMapping("/filtered")
	public MappingJacksonValue filteredCategory() {

		final Category category = new Category("Aircon", "Aircon");
		final CategoryResource categoryResource = new CategoryResource(category);
		final SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("code");
		final FilterProvider filters = new SimpleFilterProvider().addFilter(CategoryResource.JSON_FILTER, filter);
		final MappingJacksonValue mapping = new MappingJacksonValue(categoryResource);
		mapping.setFilters(filters);

		return mapping;
	}

	@GetMapping("/filtered-list")
	public MappingJacksonValue filteredListCategory() {

		final List<Category> categories = Arrays.asList(new Category("Aircon", "Aircon"), new Category("WashingMachine", "Washing Machine"));
		final List<CategoryResource> categoryResources = categories.stream().map(CategoryResource::new).collect(Collectors.toList());
		final SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("code", "description");
		final FilterProvider filters = new SimpleFilterProvider().addFilter(CategoryResource.JSON_FILTER, filter);
		final MappingJacksonValue mapping = new MappingJacksonValue(categoryResources);
		mapping.setFilters(filters);

		return mapping;
	}

	@JsonView(CategoryView.Public.class)
	@GetMapping("/filtered-view")
	public MappingJacksonValue filteredView() {

		Auditable auditable = new Auditable();
		auditable.setCreatorRef("czetsuya");
		auditable.setCreated(new Date());

		Category c1 = new Category("Aircon", "Aircon");
		c1.setAuditable(auditable);
		Category c2 = new Category("WashingMachine", "Washing Machine");
		c2.setAuditable(auditable);

		final List<Category> categories = Arrays.asList(c1, c2);
		final FilterProvider filterProvider = new SimpleFilterProvider().addFilter(CategoryResource.JSON_FILTER, SimpleBeanPropertyFilter.serializeAll());
		final MappingJacksonValue mapping = new MappingJacksonValue(categories);
		mapping.setFilters(filterProvider);

		return mapping;
	}
}
