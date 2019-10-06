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
package com.terawarehouse.web.application;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.broodcamp.data.entity.Auditable;
import com.fasterxml.jackson.annotation.JsonView;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.view.catalog.CategoryView;
import com.terawarehouse.web.resource.CategoryResource;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@RestController
@RequestMapping(path = "test")
public class FilteredController {

	private MessageSource messageSource;

	@Autowired
	public FilteredController(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	@GetMapping("/hello")
//	@ApiOperation(value = "Returns a localized hello word")
	public String helloWorld() {

		return messageSource.getMessage("hello", null, LocaleContextHolder.getLocale());
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
