package com.terawarehouse;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.terawhars.data.entity.H2JpaConfig;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource("classpath:application-integration.properties")
//@ContextConfiguration(classes = { H2JpaConfig.class })
public class TerawarehouseCatalogApplicationTests {

	@Test
	public void contextLoads() {
	}
}
