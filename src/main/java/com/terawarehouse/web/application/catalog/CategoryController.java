package com.terawarehouse.web.application.catalog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Edward P. Legaspi
 */
@RestController
@RequestMapping("/categories")
@Api(value = "Manage Category object", tags = { "catalog" })
public class CategoryController {

	@Autowired
	private MessageSource messageSource;

	@GetMapping("/hello")
	@ApiOperation(value = "Returns a localized hello word")
	public String helloWorld() {
		return messageSource.getMessage("hello", null, LocaleContextHolder.getLocale());
	}

}
