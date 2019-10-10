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
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@Configuration
@Slf4j
public class LoadDatabase {

	@Bean
	CommandLineRunner initDatabase(final CategoryRepository categoryRepository, final ProductRepository productRepository) {

		return args -> {
//			Category cat = categoryRepository.save(new Category("Aircon", "Aircon"));
//			categoryRepository.save(new Category("ElectricStove", "ElectricStove"));
//			categoryRepository.save(new Category("Refrigerator", "Refrigerator"));
//			categoryRepository.save(new Category("TV", "TV"));
//			categoryRepository.save(new Category("WashingMachine", "WashingMachine"));
//
//			log.info("Preloading " + cat);
//			log.info("Preloading " + productRepository.save(new Product(cat, "Inverter", "Inverter", new BigDecimal(25000))));
//			log.info("Preloading " + productRepository.save(new Product(cat, "Window", "Window", new BigDecimal(80000))));
		};
	}
}
