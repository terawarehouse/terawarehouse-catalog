package com.terawarehouse.web.application.catalog;

import java.util.List;

import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.web.application.AbstractControllerTest;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
public class CategoryControllerIntegrationTest extends AbstractControllerTest {

	private static final String CATEGORY_URL = "/api/v1/categories/";

//	@Autowired
//	protected CategoryRepository categoryRepository;

	protected List<Category> categories;

//	@Before
//	public void setupDataset() {
//		categoryRepository.deleteAll();
//
//		categories = Arrays.asList( //
//				categoryRepository.save(new Category("Aircon", "Aircon")) //
//				, categoryRepository.save(new Category("ElectricStove", "ElectricStove")) //
//				, categoryRepository.save(new Category("Refrigerator", "Refrigerator")) //
//				, categoryRepository.save(new Category("TV", "TV")) //
//				, categoryRepository.save(new Category("WashingMachine", "WashingMachine")));
//	}

//	@Test
//	public void whenSpringContextIsBootstrapped_thenNoExceptions() {
//	}
//
//	@Test
//	public void create_category_Ok() throws JSONException, JsonProcessingException {
//
//		Map<String, String> request = new HashMap<>();
//		request.put("code", "COMPUTER");
//		request.put("description", "Computer");
//
//		final ExtractableResponse<Response> extractable = RestAssured.given() //
//				.contentType(ContentType.JSON) //
//				.body(request) //
//				.when() //
//				.post(CATEGORY_URL) //
//				.then() //
//				.assertThat() //
//				.statusCode(HttpStatus.CREATED.value()) //
//				.and() //
//				.extract();
//
//		assertThat(extractable.body().asString()).isNotNull();
//	}
//
//	@Test
//	public void find_category_byCode_Ok() throws JSONException {
//
//		RestAssured.get(CATEGORY_URL + "code/Aircon") //
//				.then() //
//				.assertThat() //
//				.statusCode(HttpStatus.OK.value()) //
//				.body("code", equalTo(categories.get(0).getCode()));
//
//		Category c1x = RestAssured.get(CATEGORY_URL + "code/Aircon") //
//				.then() //
//				.assertThat() //
//				.statusCode(HttpStatus.OK.value()) //
//				.extract() //
//				.as(Category.class);
//
//		assertThat(c1x.getCode()).isEqualTo(categories.get(0).getCode());
//
//		String c1String = RestAssured.get(CATEGORY_URL + "code/Aircon") //
//				.then() //
//				.assertThat() //
//				.statusCode(HttpStatus.OK.value()) //
//				.extract() //
//				.asString();
//
//		assertThat(c1String).isNotNull();
//	}
//
//	@Test
//	public void update_category_Ok() throws JSONException, JsonProcessingException {
//
//		Category c1 = categoryRepository.findByCode(categories.get(0).getCode()).get();
//
//		Map<String, String> request = new HashMap<>();
//		request.put("code", "COMPUTER");
//		request.put("description", "Computer - Updated");
//
//		final ExtractableResponse<Response> extractable = RestAssured.given() //
//				.contentType(ContentType.JSON) //
//				.body(request) //
//				.when() //
//				.put(CATEGORY_URL + c1.getEntityId()) //
//				.then() //
//				.assertThat() //
//				.statusCode(HttpStatus.NO_CONTENT.value()) //
//				.and() //
//				.extract();
//
//		assertThat(extractable.body().asString()).isNotNull();
//	}
//
//	@Test
//	public void list_category_Ok() throws JSONException, JsonProcessingException {
//
//		RestAssured.given() //
//				.contentType(ContentType.JSON) //
//				.when() //
//				.get(CATEGORY_URL) //
//				.then() //
//				.assertThat() //
//				.statusCode(HttpStatus.OK.value()) //
//				.and() //
//				.body("_embedded.categories", Matchers.hasSize(5));
//	}
}
