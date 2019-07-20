package com.terawarehouse.data.repository.catalog;

import java.util.List;
import java.util.UUID;

import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.catalog.Brand;

/**
 * @author Edward P. Legaspi
 */
@Repository
//if we don't want to expose an entity via REST API uncomment the line below
//@RepositoryRestResource(exported = false)
public interface BrandRepository extends BusinessRepository<Brand, UUID> {

	@Override
//	@RestResource(exported = false)
	List<Brand> findAll();
}
