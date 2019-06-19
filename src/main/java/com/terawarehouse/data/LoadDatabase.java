package com.terawarehouse.data;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.terawarehouse.data.entity.catalog.Category;
import com.terawarehouse.data.entity.catalog.Product;
import com.terawarehouse.data.repository.catalog.CategoryRepository;
import com.terawarehouse.data.repository.catalog.ProductRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * @author Edward P. Legaspi
 */
@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(final CategoryRepository categoryRepository, final ProductRepository productRepository) {

		return args -> {
			Category cat = categoryRepository.save(new Category("Aircon", "Aircon"));
			categoryRepository.save(new Category("ElectricStove", "ElectricStove"));
			categoryRepository.save(new Category("Refrigerator", "Refrigerator"));
			categoryRepository.save(new Category("TV", "TV"));
			categoryRepository.save(new Category("WashingMachine", "WashingMachine"));

			log.info("Preloading " + cat);
			log.info("Preloading " + productRepository.save(new Product(cat, "Inverter", "Inverter", new BigDecimal(25000))));
			log.info("Preloading " + productRepository.save(new Product(cat, "Window", "Window", new BigDecimal(80000))));
		};
	}
}
