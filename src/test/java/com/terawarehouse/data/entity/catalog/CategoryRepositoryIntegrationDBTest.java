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
package com.terawarehouse.data.entity.catalog;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;

import com.terawarehouse.data.repository.catalog.CategoryRepository;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@SpringBootTest
@DataJpaTest
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
@ActiveProfiles("development-test")
public class CategoryRepositoryIntegrationDBTest {

    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

    @BeforeEach
    public void setUp() {

        categoryRepository.save(new Category("Aircon", "Aircon"));
        categoryRepository.save(new Category("ElectricStove", "ElectricStove"));
        categoryRepository.save(new Category("Refrigerator", "Refrigerator"));
        categoryRepository.save(new Category("TV", "TV"));
        categoryRepository.save(new Category("WashingMachine", "WashingMachine"));
    }

    @Test
    public void whenRequestingSize() {

        List<Category> allCats = categoryRepository.findAll();
        assertEquals(5, allCats.size());
    }

    @Test
    public void whenRequestingFirstPageOfSizeTwo_ThenReturnFirstPage() {

        Pageable pageRequest = PageRequest.of(0, 2);

        Page<Category> result = categoryRepository.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(2));
        assertTrue(result.stream().map(Category::getCode).allMatch(code -> Arrays.asList("Aircon", "ElectricStove").contains(code)));
    }

    @Test
    public void whenRequestingSecondPageOfSizeTwo_ThenReturnSecondPage() {

        Pageable pageRequest = PageRequest.of(1, 2);

        Page<Category> result = categoryRepository.findAll(pageRequest);
        assertThat(result.getContent(), hasSize(2));
        assertTrue(result.stream().map(Category::getCode).allMatch(code -> Arrays.asList("Refrigerator", "TV").contains(code)));
    }

    @Test
    public void whenRequestingLastPage_ThenReturnLastPageWithRemData() {

        Pageable pageRequest = PageRequest.of(2, 2);

        Page<Category> result = categoryRepository.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(1));
        assertTrue(result.stream().map(Category::getCode).allMatch(code -> Arrays.asList("WashingMachine").contains(code)));
    }

    @Test
    public void whenSortingByNameAscAndPaging_ThenReturnSortedPagedResult() {

        Pageable pageRequest = PageRequest.of(0, 3, Sort.by("code"));

        Page<Category> result = categoryRepository.findAll(pageRequest);

        assertThat(result.getContent(), hasSize(3));
        assertThat(result.getContent().stream().map(Category::getCode).collect(Collectors.toList()), equalTo(Arrays.asList("Aircon", "ElectricStove", "Refrigerator")));
    }
}
