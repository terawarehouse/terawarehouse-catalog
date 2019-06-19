package com.terawarehouse.data.repository.catalog;

import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.catalog.Category;

/**
 * @author Edward P. Legaspi
 */
@Repository
//if we don't want to expose an entity via REST API uncomment the line below
//@RepositoryRestResource(exported = false)
public interface CategoryRepository extends BusinessRepository<Category, String> {

}
