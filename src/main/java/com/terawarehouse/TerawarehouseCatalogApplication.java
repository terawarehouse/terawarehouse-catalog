package com.terawarehouse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.broodcamp.bean.ExtendedJPARepositoryFactoryBean;
import com.broodcamp.data.repository.BaseRepositoryImpl;

@SpringBootApplication
@EnableJpaRepositories( //
		basePackages = { "com.broodcamp.data.repository", "com.terawarehouse.data.repository" } //
		, repositoryBaseClass = BaseRepositoryImpl.class, repositoryFactoryBeanClass = ExtendedJPARepositoryFactoryBean.class)
@EntityScan(basePackages = { "com.broodcamp.data.entity", "com.terawarehouse.data.entity" })
@ComponentScan(basePackages = { "com.broodcamp", "com.terawarehouse" })
public class TerawarehouseCatalogApplication {

	public static void main(String[] args) {
		SpringApplication.run(TerawarehouseCatalogApplication.class, args);
	}

}
