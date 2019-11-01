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

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
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

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class CategoryControllerIntegrationTest extends AbstractControllerTest {

    private static final String CATEGORY_URL = "/api/v1/categories/";

    @Autowired
    protected CategoryRepository categoryRepository;

    protected List<Category> categories;

    @BeforeEach
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
