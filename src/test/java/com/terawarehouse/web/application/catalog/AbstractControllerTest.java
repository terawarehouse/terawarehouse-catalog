package com.terawarehouse.web.application.catalog;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

/**
 * @author Edward P. Legaspi
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-integration.properties")
@ActiveProfiles("development-test")
public abstract class AbstractControllerTest {

	protected static final ObjectMapper om = new ObjectMapper();

	@LocalServerPort
	int port;

	@Before
	public void setup() {

		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}
}
