package com.terawarehouse;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-integration.properties")
@ActiveProfiles(profiles = "development-h2")
public class TerawarehouseCatalogApplicationTests {

	@Test
	public void contextLoads() {
	}
}
