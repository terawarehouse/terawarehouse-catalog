package com.terawarehouse.web.application.catalog;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.web.application.AbstractControllerTest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.ExtractableResponse;
import io.restassured.response.Response;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Edward P. Legaspi
 */
@Slf4j
public class CategoryControllerIntegrationTest extends AbstractControllerTest {

	private static final String CATEGORY_URL = "/v1/categories/";

	@Autowired
	protected CategoryRepository categoryRepository;

	protected List<Category> categories;

	@Before
	public void setupDataset() {
		categoryRepository.deleteAll();

		categories = Arrays.asList( //
				categoryRepository.save(new Category("Aircon", "Aircon")) //
				, categoryRepository.save(new Category("ElectricStove", "ElectricStove")) //
				, categoryRepository.save(new Category("Refrigerator", "Refrigerator")) //
				, categoryRepository.save(new Category("TV", "TV")) //
				, categoryRepository.save(new Category("WashingMachine", "WashingMachine")));
	}

	@Test
	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
	}

	@Test
	public void create_category_Ok() throws JSONException, JsonProcessingException {

		Map<String, String> request = new HashMap<>();
		request.put("code", "COMPUTER");
		request.put("description", "Computer");

		final ExtractableResponse<Response> extractable = RestAssured.given() //
				.contentType(ContentType.JSON) //
				.body(request) //
				.when() //
				.post(CATEGORY_URL) //
				.then() //
				.assertThat() //
				.statusCode(HttpStatus.CREATED.value()) //
				.and() //
				.extract();

		assertThat(extractable.body().asString()).isNotNull();
	}

	@Test
	public void find_category_byCode_Ok() throws JSONException {

		RestAssured.get(CATEGORY_URL + "code/Aircon") //
				.then() //
				.assertThat() //
				.statusCode(HttpStatus.OK.value()) //
				.body("code", equalTo(categories.get(0).getCode()));

		Category c1x = RestAssured.get(CATEGORY_URL + "code/Aircon") //
				.then() //
				.assertThat() //
				.statusCode(HttpStatus.OK.value()) //
				.extract() //
				.as(Category.class);

		assertThat(c1x.getCode()).isEqualTo(categories.get(0).getCode());

		String c1String = RestAssured.get(CATEGORY_URL + "code/Aircon") //
				.then() //
				.assertThat() //
				.statusCode(HttpStatus.OK.value()) //
				.extract() //
				.asString();

		assertThat(c1String).isNotNull();
	}

	@Test
	public void update_category_Ok() throws JSONException, JsonProcessingException {

		Category c1 = categoryRepository.findByCode(categories.get(0).getCode()).get();

		Map<String, String> request = new HashMap<>();
		request.put("code", "COMPUTER");
		request.put("description", "Computer - Updated");

		final ExtractableResponse<Response> extractable = RestAssured.given() //
				.contentType(ContentType.JSON) //
				.body(request) //
				.when() //
				.put(CATEGORY_URL + c1.getEntityId()) //
				.then() //
				.assertThat() //
				.statusCode(HttpStatus.NO_CONTENT.value()) //
				.and() //
				.extract();

		assertThat(extractable.body().asString()).isNotNull();
	}

	@Test
	public void list_category_Ok() throws JSONException, JsonProcessingException {

		RestAssured.given() //
				.contentType(ContentType.JSON) //
				.when() //
				.get(CATEGORY_URL) //
				.then() //
				.assertThat() //
				.statusCode(HttpStatus.OK.value()) //
				.and() //
				.body("_embedded.categories", Matchers.hasSize(5));
	}
}
