package com.terawarehouse.data.entity.catalog;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.terawarehouse.data.repository.catalog.CategoryRepository;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
//@RunWith(SpringRunner.class)
//@DataJpaTest
//@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
//@ActiveProfiles("development-test")
public class CategoryRepositoryIntegrationDBTest {

//	@Autowired
//	private CategoryRepository categoryRepository;
//
//	@Test
//	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
//	}

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
