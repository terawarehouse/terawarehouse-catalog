package com.terawarehouse.data.repository.catalog;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.broodcamp.data.repository.BusinessRepository;
import com.terawarehouse.data.entity.catalog.Product;

/**
 * @author Edward P. Legaspi <czetsuya@gmail.com>
 */
@Repository
public interface ProductRepository extends BusinessRepository<Product, UUID> {

}
