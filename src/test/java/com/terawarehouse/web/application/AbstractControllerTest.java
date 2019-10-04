package com.terawarehouse.web.application;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.event.annotation.BeforeTestClass;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-integration.properties")
@ActiveProfiles("development")
public abstract class AbstractControllerTest {

	protected static final ObjectMapper om = new ObjectMapper();

	@LocalServerPort
	int port;

	@BeforeTestClass
	public void setup() {

		RestAssured.port = port;
		RestAssured.baseURI = "http://localhost";
	}
}
