package com.terawarehouse.data.entity.catalog;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import com.terawarehouse.data.repository.catalog.CategoryRepository;

/**
 * @author Edward P. Legaspi
 */
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
//@ActiveProfiles("development-test")
public class CategoryRepositoryIntegrationDBTest {

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Test
	public void contextLoads() {
	}
	
//	@Before
//	public void setUp() {
//
//		categoryRepository.save(new Category("Aircon", "Aircon"));
//		categoryRepository.save(new Category("ElectricStove", "ElectricStove"));
//		categoryRepository.save(new Category("Refrigerator", "Refrigerator"));
//		categoryRepository.save(new Category("TV", "TV"));
//		categoryRepository.save(new Category("WashingMachine", "WashingMachine"));
//	}
//
//	@Test
//	public void whenRequestingSize() {
//
//		List<Category> allCats = categoryRepository.findAll();
//		assertEquals(5, allCats.size());
//	}
//
//	@Test
//	public void whenRequestingFirstPageOfSizeTwo_ThenReturnFirstPage() {
//
//		Pageable pageRequest = PageRequest.of(0, 2);
//
//		Page<Category> result = categoryRepository.findAll(pageRequest);
//
//		assertThat(result.getContent(), hasSize(2));
//		assertTrue(result.stream().map(Category::getCode).allMatch(code -> Arrays.asList("Aircon", "ElectricStove").contains(code)));
//	}
//
//	@Test
//	public void whenRequestingSecondPageOfSizeTwo_ThenReturnSecondPage() {
//
//		Pageable pageRequest = PageRequest.of(1, 2);
//
//		Page<Category> result = categoryRepository.findAll(pageRequest);
//		assertThat(result.getContent(), hasSize(2));
//		assertTrue(result.stream().map(Category::getCode).allMatch(code -> Arrays.asList("Refrigerator", "TV").contains(code)));
//	}
//
//	@Test
//	public void whenRequestingLastPage_ThenReturnLastPageWithRemData() {
//
//		Pageable pageRequest = PageRequest.of(2, 2);
//
//		Page<Category> result = categoryRepository.findAll(pageRequest);
//
//		assertThat(result.getContent(), hasSize(1));
//		assertTrue(result.stream().map(Category::getCode).allMatch(code -> Arrays.asList("WashingMachine").contains(code)));
//	}
//
//	@Test
//	public void whenSortingByNameAscAndPaging_ThenReturnSortedPagedResult() {
//
//		Pageable pageRequest = PageRequest.of(0, 3, Sort.by("code"));
//
//		Page<Category> result = categoryRepository.findAll(pageRequest);
//
//		assertThat(result.getContent(), hasSize(3));
//		assertThat(result.getContent().stream().map(Category::getCode).collect(Collectors.toList()), equalTo(Arrays.asList("Aircon", "ElectricStove", "Refrigerator")));
//	}
}
