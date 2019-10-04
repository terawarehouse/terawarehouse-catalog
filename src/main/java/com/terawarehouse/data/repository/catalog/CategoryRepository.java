package com.terawarehouse.data.repository.catalog;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.catalog.Category;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@Repository
public interface CategoryRepository extends BusinessRepository<Category, UUID> {

}
