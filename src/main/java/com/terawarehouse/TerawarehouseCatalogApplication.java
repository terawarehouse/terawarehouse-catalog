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
package com.terawarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.broodcamp.bean.ExtendedJPARepositoryFactoryBean;
import com.broodcamp.data.repository.BaseRepositoryImpl;

/**
 * @author Edward P. Legaspi | czetsuya@gmail.com
 */
@SpringBootApplication
@EnableJpaRepositories( //
		basePackages = { "com.broodcamp.data.repository", "com.terawarehouse.data.repository" } //
		, repositoryBaseClass = BaseRepositoryImpl.class, repositoryFactoryBeanClass = ExtendedJPARepositoryFactoryBean.class)
@EntityScan(basePackages = { "com.broodcamp.data.entity", "com.terawarehouse.data.entity" })
@ComponentScan(basePackages = { "com.broodcamp", "com.terawarehouse" })
@EnableDiscoveryClient
public class TerawarehouseCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerawarehouseCatalogApplication.class, args);
	}

}
